package net.larsmans.infinitybuttons.block.custom.button;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class AbstractHorizontalButton extends HorizontalBlock {
    public static final BooleanProperty PRESSED = BooleanProperty.create("pressed");

    public final VoxelShape NORTH_SHAPE;
    public final VoxelShape EAST_SHAPE;
    public final VoxelShape SOUTH_SHAPE;
    public final VoxelShape WEST_SHAPE;
    public final VoxelShape NORTH_PRESSED_SHAPE;
    public final VoxelShape EAST_PRESSED_SHAPE;
    public final VoxelShape SOUTH_PRESSED_SHAPE;
    public final VoxelShape WEST_PRESSED_SHAPE;

    protected AbstractHorizontalButton(Properties properties, VoxelShape north_shape, VoxelShape east_shape, VoxelShape south_shape, VoxelShape west_shape, VoxelShape north_pressed_shape, VoxelShape east_pressed_shape, VoxelShape south_pressed_shape, VoxelShape west_pressed_shape) {
        super(properties);
        NORTH_SHAPE = north_shape;
        EAST_SHAPE = east_shape;
        SOUTH_SHAPE = south_shape;
        WEST_SHAPE = west_shape;
        NORTH_PRESSED_SHAPE = north_pressed_shape;
        EAST_PRESSED_SHAPE = east_pressed_shape;
        SOUTH_PRESSED_SHAPE = south_pressed_shape;
        WEST_PRESSED_SHAPE = west_pressed_shape;
        this.setDefaultState(this.getStateContainer().getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(PRESSED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        boolean bl = state.get(PRESSED);
        switch (state.get(HORIZONTAL_FACING)) {
            case NORTH: {
                return bl ? NORTH_PRESSED_SHAPE : NORTH_SHAPE;
            }
            case EAST: {
                return bl ? EAST_PRESSED_SHAPE : EAST_SHAPE;
            }
            case SOUTH: {
                return bl ? SOUTH_PRESSED_SHAPE : SOUTH_SHAPE;
            }
        }
        return bl ? WEST_PRESSED_SHAPE : WEST_SHAPE;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(PRESSED, HORIZONTAL_FACING);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (state.get(PRESSED)) {
            return ActionResultType.CONSUME;
        }
        this.powerBlock(state, worldIn, pos);
        this.playSound(player, worldIn, pos, true);
        return ActionResultType.func_233537_a_(worldIn.isRemote);
    }

    public void powerBlock(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(PRESSED, true), 3);
        this.updateNeighbors(state, world, pos);
        world.getPendingBlockTicks().scheduleTick(pos, this, this.getPressDuration());
    }

    public abstract int getPressDuration();

    protected void playSound(@Nullable PlayerEntity playerIn, IWorld worldIn, BlockPos pos, boolean hitByArrow) {
        worldIn.playSound(hitByArrow ? playerIn : null, pos, this.getSoundEvent(hitByArrow), SoundCategory.BLOCKS, 0.3f, hitByArrow ? 0.6f : 0.5f);
    }

    protected abstract SoundEvent getSoundEvent(boolean pressed);

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (isMoving || state.matchesBlock(newState.getBlock())) {
            return;
        }
        if (state.get(PRESSED)) {
            this.updateNeighbors(state, worldIn, pos);
        }
        super.onReplaced(state, worldIn, pos, newState, isMoving);
    }

    @Override
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(PRESSED) ? 15 : 0;
    }

    @Override
    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(PRESSED) && blockState.get(HORIZONTAL_FACING) == side ? 15 : 0;
    }

    @Override
    public boolean canProvidePower(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (state.get(PRESSED)) {
            worldIn.setBlockState(pos, state.with(PRESSED, false), 3);
            this.updateNeighbors(state, worldIn, pos);
            this.playSound(null, worldIn, pos, false);
        }
    }

    @Override
    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public void updateNeighbors(BlockState state, World world, BlockPos pos) {
        world.notifyNeighborsOfStateChange(pos, this);
        world.notifyNeighborsOfStateChange(pos.offset(state.get(HORIZONTAL_FACING).getOpposite()), this);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        return this.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, ctx.getPlacementHorizontalFacing().getOpposite());
    }
}
