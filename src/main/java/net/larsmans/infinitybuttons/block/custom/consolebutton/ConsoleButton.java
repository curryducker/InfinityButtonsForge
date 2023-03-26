package net.larsmans.infinitybuttons.block.custom.consolebutton;

import net.larsmans.infinitybuttons.block.custom.button.AbstractLeverableButton;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class ConsoleButton extends AbstractLeverableButton {
    protected static final VoxelShape CEILING_X_SHAPE = makeCuboidShape(3, 14, 4, 13, 16, 12);
    protected static final VoxelShape CEILING_Z_SHAPE = makeCuboidShape(4, 14, 3, 12, 16, 13);
    protected static final VoxelShape FLOOR_X_SHAPE = makeCuboidShape(3, 0, 4, 13, 2, 12);
    protected static final VoxelShape FLOOR_Z_SHAPE = makeCuboidShape(4, 0, 3, 12, 2, 13);
    protected static final VoxelShape NORTH_SHAPE = makeCuboidShape(4, 3, 14, 12, 13, 16);
    protected static final VoxelShape SOUTH_SHAPE = makeCuboidShape(4, 3, 0, 12, 13, 2);
    protected static final VoxelShape WEST_SHAPE = makeCuboidShape(14, 3, 4, 16, 13, 12);
    protected static final VoxelShape EAST_SHAPE = makeCuboidShape(0, 3, 4, 2, 13, 12);

    public ConsoleButton(Properties settings, boolean lever) {
        super(lever, settings);
    }

    @Override
    public int getActiveDuration() {
        return 60;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean pressed) {
        return SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON;
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
