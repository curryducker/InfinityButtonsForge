package net.larsmans.infinitybuttons.block.custom.button;

import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class AbstractWallButton extends AbstractHorizontalButton {

    protected AbstractWallButton(Properties settings, VoxelShape north_shape, VoxelShape east_shape, VoxelShape south_shape, VoxelShape west_shape, VoxelShape north_pressed_shape, VoxelShape east_pressed_shape, VoxelShape south_pressed_shape, VoxelShape west_pressed_shape) {
        super(settings, north_shape, east_shape, south_shape, west_shape, north_pressed_shape, east_pressed_shape, south_pressed_shape, west_pressed_shape);
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
        BlockState blockState = this.getDefaultState();
        World worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getPos();
        for (Direction direction : ctx.getNearestLookingDirections()) {
            if (!direction.getAxis().isHorizontal() || !(blockState = blockState.with(HORIZONTAL_FACING, direction.getOpposite())).isValidPosition(worldView, blockPos)) continue;
            return blockState;
        }
        return null;
    }
}