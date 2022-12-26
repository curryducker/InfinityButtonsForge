package net.larsmans.infinitybuttons.block.custom.secretbutton;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
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

public abstract class AbstractSecretButton extends HorizontalBlock {
    public static final BooleanProperty PRESSED = BooleanProperty.create("pressed");

    public final VoxelShape NORTH_SHAPE;
    public final VoxelShape EAST_SHAPE;
    public final VoxelShape SOUTH_SHAPE;
    public final VoxelShape WEST_SHAPE;
    public final VoxelShape OFF_SHAPE;

    public AbstractSecretButton(Properties properties, VoxelShape north_shape, VoxelShape east_shape, VoxelShape south_shape, VoxelShape west_shape, VoxelShape off_shape) {
        super(properties);
        NORTH_SHAPE = north_shape;
        EAST_SHAPE = east_shape;
        SOUTH_SHAPE = south_shape;
        WEST_SHAPE = west_shape;
        OFF_SHAPE = off_shape;
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(PRESSED, Boolean.FALSE));
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (state.get(PRESSED)) {
            switch (state.get(HORIZONTAL_FACING)) {
                case NORTH: {
                    return NORTH_SHAPE;
                }
                case EAST: {
                    return EAST_SHAPE;
                }
                case SOUTH: {
                    return SOUTH_SHAPE;
                }
                case WEST: {
                    return WEST_SHAPE;
                }
            }
        }
        return OFF_SHAPE;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, PRESSED);
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (hit.getFace() == state.get(HORIZONTAL_FACING)) {
            this.powerBlock(state, worldIn, pos);
            this.playSound(player, worldIn, pos, true);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        }
        return ActionResultType.FAIL;
    }

    public void powerBlock(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(PRESSED, Boolean.TRUE), 3);
        this.updateNeighbors(state, world, pos);
        world.getPendingBlockTicks().scheduleTick(pos, this, 50);
    }

    protected void playSound(@Nullable PlayerEntity playerIn, IWorld worldIn, BlockPos pos, boolean hitByArrow) {
        worldIn.playSound(hitByArrow ? playerIn : null, pos, this.getSoundEvent(hitByArrow), SoundCategory.BLOCKS, 1F, hitByArrow ? 0.6F : 0.5F);
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
        if (blockState.get(PRESSED) && blockState.get(HORIZONTAL_FACING) == side) {
            return 15;
        }
        return 0;
    }

    public boolean canProvidePower(BlockState state) {
        return true;
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (state.get(PRESSED)) {
            worldIn.setBlockState(pos, state.with(PRESSED, Boolean.FALSE), 3);
            this.updateNeighbors(state, worldIn, pos);
            this.playSound(null, worldIn, pos, false);
        }
    }

    public void updateNeighbors(BlockState state, World worldIn, BlockPos pos) {
        worldIn.notifyNeighborsOfStateChange(pos, this);
        worldIn.notifyNeighborsOfStateChange(pos.offset(state.get(HORIZONTAL_FACING).getOpposite()), this);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        return this.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, ctx.getPlacementHorizontalFacing().getOpposite());
    }
}
