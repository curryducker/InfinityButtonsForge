package net.larsmans.infinitybuttons.block.custom.largebutton;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
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
import java.util.List;
import java.util.Random;

public abstract class AbstractLargeButton extends HorizontalFaceBlock {
    public static final BooleanProperty PRESSED = BooleanProperty.create("pressed");

    private static final VoxelShape FLOOR_SHAPE = Block.makeCuboidShape(4, 0, 4, 12, 2, 12);
    private static final VoxelShape FLOOR_PRESSED_SHAPE = Block.makeCuboidShape(4, 0, 4, 12, 1, 12);
    private static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(4, 4, 14, 12, 12, 16);
    private static final VoxelShape NORTH_PRESSED_SHAPE = Block.makeCuboidShape(4, 4, 15, 12, 12, 16);
    private static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(0, 4, 4, 2, 12, 12);
    private static final VoxelShape EAST_PRESSED_SHAPE = Block.makeCuboidShape(0, 4, 4, 1, 12, 12);
    private static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(4, 4, 0, 12, 12, 2);
    private static final VoxelShape SOUTH_PRESSED_SHAPE = Block.makeCuboidShape(4, 4, 0, 12, 12, 1);
    private static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(14, 4, 4, 16, 12, 12);
    private static final VoxelShape WEST_PRESSED_SHAPE = Block.makeCuboidShape(15, 4, 4, 16, 12, 12);
    private static final VoxelShape CEILING_SHAPE = Block.makeCuboidShape(4, 14, 4, 12, 16, 12);
    private static final VoxelShape CEILING_PRESSED_SHAPE = Block.makeCuboidShape(4, 15, 4, 12, 16, 12);
    private final boolean wooden;

    protected AbstractLargeButton(boolean isWooden, AbstractBlock.Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(PRESSED, false).with(FACE, AttachFace.FLOOR));
        this.wooden = isWooden;
    }

    public abstract int getActiveDuration();

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction direction = state.get(HORIZONTAL_FACING);
        boolean flag = state.get(PRESSED);
        switch((AttachFace)state.get(FACE)) {
            case FLOOR:
                return flag ? FLOOR_PRESSED_SHAPE : FLOOR_SHAPE;
            case WALL:
                switch(direction) {
                    case EAST:
                        return flag ? EAST_PRESSED_SHAPE : EAST_SHAPE;
                    case WEST:
                        return flag ? WEST_PRESSED_SHAPE : WEST_SHAPE;
                    case SOUTH:
                        return flag ? SOUTH_PRESSED_SHAPE : SOUTH_SHAPE;
                    case NORTH:
                    default:
                        return flag ? NORTH_PRESSED_SHAPE : NORTH_SHAPE;
                }
            case CEILING:
            default:
                return flag ? CEILING_PRESSED_SHAPE : CEILING_SHAPE;
        }
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (state.get(PRESSED)) {
            return ActionResultType.CONSUME;
        } else {
            this.powerBlock(state, worldIn, pos);
            this.playSound(player, worldIn, pos, true);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        }
    }

    public void powerBlock(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(PRESSED, Boolean.TRUE), 3);
        this.updateNeighbors(state, world, pos);
        world.getPendingBlockTicks().scheduleTick(pos, this, this.getActiveDuration());
    }

    protected void playSound(@Nullable PlayerEntity playerIn, IWorld worldIn, BlockPos pos, boolean hitByArrow) {
        worldIn.playSound(hitByArrow ? playerIn : null, pos, this.getSoundEvent(hitByArrow), SoundCategory.BLOCKS, 0.3F, hitByArrow ? 0.6F : 0.5F);
    }

    protected abstract SoundEvent getSoundEvent(boolean isOn);

    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!isMoving && !state.matchesBlock(newState.getBlock())) {
            if (state.get(PRESSED)) {
                this.updateNeighbors(state, worldIn, pos);
            }

            super.onReplaced(state, worldIn, pos, newState, isMoving);
        }
    }

    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(PRESSED) ? 15 : 0;
    }

    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(PRESSED) && getFacing(blockState) == side ? 15 : 0;
    }

    public boolean canProvidePower(BlockState state) {
        return true;
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (state.get(PRESSED)) {
            if (this.wooden) {
                this.checkPressed(state, worldIn, pos);
            } else {
                worldIn.setBlockState(pos, state.with(PRESSED, Boolean.FALSE), 3);
                this.updateNeighbors(state, worldIn, pos);
                this.playSound((PlayerEntity)null, worldIn, pos, false);
            }

        }
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.isRemote && this.wooden && !state.get(PRESSED)) {
            this.checkPressed(state, worldIn, pos);
        }
    }

    private void checkPressed(BlockState state, World worldIn, BlockPos pos) {
        List<? extends Entity> list = worldIn.getEntitiesWithinAABB(AbstractArrowEntity.class, state.getShape(worldIn, pos).getBoundingBox().offset(pos));
        boolean flag = !list.isEmpty();
        boolean flag1 = state.get(PRESSED);
        if (flag != flag1) {
            worldIn.setBlockState(pos, state.with(PRESSED, flag), 3);
            this.updateNeighbors(state, worldIn, pos);
            this.playSound((PlayerEntity)null, worldIn, pos, flag);
        }

        if (flag) {
            worldIn.getPendingBlockTicks().scheduleTick(new BlockPos(pos), this, this.getActiveDuration());
        }

    }

    public void updateNeighbors(BlockState state, World worldIn, BlockPos pos) {
        worldIn.notifyNeighborsOfStateChange(pos, this);
        worldIn.notifyNeighborsOfStateChange(pos.offset(getFacing(state).getOpposite()), this);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, PRESSED, FACE);
    }
}