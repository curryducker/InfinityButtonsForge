package net.larsmans.infinitybuttons.block.custom.button;

import net.larsmans.infinitybuttons.block.custom.button.AbstractButton;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;

public abstract class LargeButtonShape extends AbstractButton {
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

    protected LargeButtonShape(boolean projectile, Properties properties, boolean large) {
        super(projectile, large, properties);
    }

    public static VoxelShape outlineShape(BlockState state) {
        Direction direction = state.get(HORIZONTAL_FACING);
        boolean flag = state.get(PRESSED);
        switch(state.get(FACE)) {
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
}