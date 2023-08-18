package net.larsmans.infinitybuttons.block.custom.button;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public abstract class AbstractSmallButton extends AbstractButton{

    protected static final VoxelShape CEILING_X_SHAPE = Block.makeCuboidShape(6, 14, 5, 10, 16, 11);
    protected static final VoxelShape CEILING_Z_SHAPE = Block.makeCuboidShape(5, 14, 6, 11, 16, 10);
    protected static final VoxelShape FLOOR_X_SHAPE = Block.makeCuboidShape(6, 0, 5, 10, 2, 11);
    protected static final VoxelShape FLOOR_Z_SHAPE = Block.makeCuboidShape(5, 0, 6, 11, 2, 10);
    protected static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(5, 6, 14, 11, 10, 16);
    protected static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(5, 6, 0, 11, 10, 2);
    protected static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(14, 6, 5, 16, 10, 11);
    protected static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(0, 6, 5, 2, 10, 11);
    protected static final VoxelShape CEILING_X_PRESSED_SHAPE = Block.makeCuboidShape(6, 15, 5, 10, 16, 11);
    protected static final VoxelShape CEILING_Z_PRESSED_SHAPE = Block.makeCuboidShape(5, 15, 6, 11, 16, 10);
    protected static final VoxelShape FLOOR_X_PRESSED_SHAPE = Block.makeCuboidShape(6, 0, 5, 10, 1, 11);
    protected static final VoxelShape FLOOR_Z_PRESSED_SHAPE = Block.makeCuboidShape(5, 0, 6, 11, 1, 10);
    protected static final VoxelShape NORTH_PRESSED_SHAPE = Block.makeCuboidShape(5, 6, 15, 11, 10, 16);
    protected static final VoxelShape SOUTH_PRESSED_SHAPE = Block.makeCuboidShape(5, 6, 0, 11, 10, 1);
    protected static final VoxelShape WEST_PRESSED_SHAPE = Block.makeCuboidShape(15, 6, 5, 16, 10, 11);
    protected static final VoxelShape EAST_PRESSED_SHAPE = Block.makeCuboidShape(0, 6, 5, 1, 10, 11);

    private final boolean large;

    protected AbstractSmallButton(boolean projectile, boolean large, Properties properties) {
        super(projectile, properties);
        this.large = large;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (large) {
            return LargeButtonShape.outlineShape(state);
        }
        Direction direction = state.get(HORIZONTAL_FACING);
        boolean flag = state.get(PRESSED);
        switch(state.get(FACE)) {
            case FLOOR:
                if (direction.getAxis() == Direction.Axis.X) {
                    return flag ? FLOOR_X_PRESSED_SHAPE : FLOOR_X_SHAPE;
                }

                return flag ? FLOOR_Z_PRESSED_SHAPE : FLOOR_Z_SHAPE;
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
                if (direction.getAxis() == Direction.Axis.X) {
                    return flag ? CEILING_X_PRESSED_SHAPE : CEILING_X_SHAPE;
                } else {
                    return flag ? CEILING_Z_PRESSED_SHAPE : CEILING_Z_SHAPE;
                }
        }
    }

    public boolean isLarge() {
        return large;
    }
}
