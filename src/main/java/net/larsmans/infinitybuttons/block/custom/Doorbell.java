package net.larsmans.infinitybuttons.block.custom;

import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class Doorbell extends HorizontalBlock {
    public static final BooleanProperty PRESSED = BooleanProperty.create("pressed");

    protected static final VoxelShape NORTH_PRESSED_SHAPE =
            Block.makeCuboidShape(6, 4, 14, 10, 12, 16);

    protected static final VoxelShape EAST_PRESSED_SHAPE =
            Block.makeCuboidShape(0, 4, 6, 2, 12, 10);

    protected static final VoxelShape SOUTH_PRESSED_SHAPE =
            Block.makeCuboidShape(6, 4, 0, 10, 12, 2);

    protected static final VoxelShape WEST_PRESSED_SHAPE =
            Block.makeCuboidShape(14, 4, 6, 16, 12, 10);

    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.or(NORTH_PRESSED_SHAPE,
            Block.makeCuboidShape(7, 6, 13, 9, 10, 14));

    protected static final VoxelShape EAST_SHAPE = VoxelShapes.or(EAST_PRESSED_SHAPE,
            Block.makeCuboidShape(2, 6, 7, 3, 10, 9));

    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.or(SOUTH_PRESSED_SHAPE,
            Block.makeCuboidShape(7, 6, 2, 9, 10, 3));

    protected static final VoxelShape WEST_SHAPE = VoxelShapes.or(WEST_PRESSED_SHAPE,
            Block.makeCuboidShape(13, 6, 7, 14, 10, 9));

    public Doorbell(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(PRESSED, false));
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
        world.getPendingBlockTicks().scheduleTick(pos, this, 15);
    }

    protected void playSound(@Nullable PlayerEntity playerIn, IWorld worldIn, BlockPos pos, boolean hitByArrow) {
        worldIn.playSound(hitByArrow ? playerIn : null, pos, InfinityButtonsSounds.DOORBELL.get(), SoundCategory.BLOCKS, 0.3F, 1f);
    }

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
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!state.get(PRESSED)) {
            return;
        }
        worldIn.setBlockState(pos, state.with(PRESSED, false), 3);
        this.updateNeighbors(state, worldIn, pos);
    }

    public void updateNeighbors(BlockState state, World worldIn, BlockPos pos) {
        worldIn.notifyNeighborsOfStateChange(pos, this);
        worldIn.notifyNeighborsOfStateChange(pos.offset(state.get(HORIZONTAL_FACING).getOpposite()), this);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, PRESSED);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Direction direction = state.get(HORIZONTAL_FACING);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = worldIn.getBlockState(blockPos);
        return blockState.isSolidSide(worldIn, blockPos, direction);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        Direction[] directions;
        BlockState blockState = this.getDefaultState();
        World worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getPos();
        for (Direction direction : directions = ctx.getNearestLookingDirections()) {
            Direction direction2;
            if (!direction.getAxis().isHorizontal() || !(blockState = blockState.with(HORIZONTAL_FACING, direction2 = direction.getOpposite())).isValidPosition(worldView, blockPos)) continue;
            return blockState;
        }
        return null;
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing.getOpposite() == stateIn.get(HORIZONTAL_FACING) && !stateIn.isValidPosition(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        }
        return stateIn;
    }
}
