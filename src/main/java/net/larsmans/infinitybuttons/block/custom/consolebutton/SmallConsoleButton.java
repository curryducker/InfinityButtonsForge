package net.larsmans.infinitybuttons.block.custom.consolebutton;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class SmallConsoleButton extends ConsoleButton{
    protected static final VoxelShape CEILING_X_SHAPE = makeCuboidShape(5, 14, 3, 11, 16, 13);
    protected static final VoxelShape CEILING_Z_SHAPE = makeCuboidShape(3, 14, 5, 13, 16, 11);
    protected static final VoxelShape FLOOR_X_SHAPE = makeCuboidShape(5, 0, 3, 11, 2, 13);
    protected static final VoxelShape FLOOR_Z_SHAPE = makeCuboidShape(3, 0, 5, 13, 2, 11);
    protected static final VoxelShape NORTH_SHAPE = makeCuboidShape(3, 5, 14, 13, 11, 16);
    protected static final VoxelShape SOUTH_SHAPE = makeCuboidShape(3, 5, 0, 13, 11, 2);
    protected static final VoxelShape WEST_SHAPE = makeCuboidShape(14, 5, 3, 16, 11, 13);
    protected static final VoxelShape EAST_SHAPE = makeCuboidShape(0, 5, 3, 2, 11, 13);

    public SmallConsoleButton(Properties settings, boolean lever) {
        super(settings, lever);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction direction = state.get(HORIZONTAL_FACING);
        switch (state.get(FACE)) {
            case FLOOR: {
                if (direction.getAxis() == Direction.Axis.X) {
                    return FLOOR_X_SHAPE;
                }
                return FLOOR_Z_SHAPE;
            }
            case WALL: {
                switch (direction) {
                    case EAST: {
                        return EAST_SHAPE;
                    }
                    case WEST: {
                        return WEST_SHAPE;
                    }
                    case SOUTH: {
                        return SOUTH_SHAPE;
                    }
                }
                return NORTH_SHAPE;
            }
        }
        if (direction.getAxis() == Direction.Axis.X) {
            return CEILING_X_SHAPE;
        }
        return CEILING_Z_SHAPE;
    }
}
