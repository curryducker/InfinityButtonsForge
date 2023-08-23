package net.larsmans.infinitybuttons.block.custom;

import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

import static net.larsmans.infinitybuttons.InfinityButtonsUtil.checkChains;
import static net.minecraft.block.LanternBlock.WATERLOGGED;

public class LanternButton extends Block implements IWaterLoggable {

    public static final BooleanProperty PRESSED = BooleanProperty.create("pressed");
    private static final VoxelShape HANGING_SHAPES = VoxelShapes.or(Block.makeCuboidShape(5.0D, 1.0D, 5.0D, 11.0D, 8.0D, 11.0D), Block.makeCuboidShape(6.0D, 8.0D, 6.0D, 10.0D, 10.0D, 10.0D));
    public static final VoxelShape SHAPE_PRESSED = HANGING_SHAPES.withOffset(0, (double) -1 / 16, 0);
    private final boolean isLever;
    public final Block jadeBlock;

    public LanternButton(Properties properties, boolean isLever, Block jadeBlock) {
        super(properties);
        this.isLever = isLever;
        this.jadeBlock = jadeBlock;
        this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false).with(PRESSED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return state.get(PRESSED) ? SHAPE_PRESSED : HANGING_SHAPES;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getPos());
        for (Direction direction : ctx.getNearestLookingDirections()) {
            if (direction != Direction.UP) continue;
            return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        }
        return null;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, PRESSED);
    }

    protected int getPressDuration() {
        return 30;
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState facingState, IWorld world, BlockPos pos, BlockPos facingPos) {
        if (state.get(WATERLOGGED)) {
            world.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return direction == Direction.UP && !state.isValidPosition(world, pos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(state, direction, facingState, world, pos, facingPos);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (isLever) {
            if (state.get(PRESSED)) {
                this.powerOff(state, worldIn, pos);
                this.playSound(player, worldIn, pos, false);
            } else {
                this.powerOn(state, worldIn, pos);
                this.playSound(player, worldIn, pos, true);
            }
        } else {
            if (state.get(PRESSED)) {
                return ActionResultType.CONSUME;
            }
            this.powerOn(state, worldIn, pos);
            worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.getPressDuration());
            this.playSound(player, worldIn, pos, true);
        }
        return ActionResultType.func_233537_a_(worldIn.isRemote);
    }

    public void powerOn(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(PRESSED, true), 3);
        this.updateNeighbors(world, pos);
    }

    public void powerOff(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(PRESSED, false), 3);
        this.updateNeighbors(world, pos);
    }

    protected void playSound(@Nullable PlayerEntity playerIn, IWorld worldIn, BlockPos pos, boolean pressed) {
        worldIn.playSound(pressed ? playerIn : null, pos, this.getSoundEvent(), SoundCategory.BLOCKS, 0.3f, pressed ? 0.6f : 0.5f);
    }

    protected SoundEvent getSoundEvent() {
        return SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (isMoving || state.matchesBlock(newState.getBlock())) {
            return;
        }
        if (state.get(PRESSED)) {
            this.updateNeighbors(worldIn, pos);
        }
        super.onReplaced(state, worldIn, pos, newState, isMoving);
    }

    @Override
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(PRESSED) ? 15 : 0;
    }

    @Override
    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return (blockState.get(PRESSED) && side == Direction.DOWN) ? 15 : 0;
    }

    @Override
    public boolean canProvidePower(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!state.get(PRESSED)) {
            return;
        }
        worldIn.setBlockState(pos, state.with(PRESSED, false), 3);
        this.updateNeighbors(worldIn, pos);
        this.playSound(null, worldIn, pos, false);
    }

    public void updateNeighbors(World world, BlockPos pos) {
        int distance = checkChains(world, pos);
        world.notifyNeighborsOfStateChange(pos, this);
        world.notifyNeighborsOfStateChange(pos.up(distance), this);
        world.notifyNeighborsOfStateChange(pos.up(distance + 1), this);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        InfinityButtonsUtil.tooltip(tooltip, "lantern_button");
    }

    @Override
    public boolean allowsMovement(BlockState state, IBlockReader world, BlockPos pos, PathType type) {
        return false;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        return Block.hasEnoughSolidSide(world, pos.offset(Direction.UP), Direction.DOWN);
    }
}