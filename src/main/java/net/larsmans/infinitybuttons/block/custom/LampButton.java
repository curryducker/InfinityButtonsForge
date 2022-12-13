package net.larsmans.infinitybuttons.block.custom;

import net.larsmans.infinitybuttons.block.custom.button.AbstractButton;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class LampButton extends AbstractButton {
    public LampButton(Properties properties) {
        super(false, properties);
    }

    @Override
    public int getActiveDuration() {
        return 20;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean pressed) {
        return pressed ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    }

    private static final VoxelShape FLOOR_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(3, 0, 3, 13, 1, 13),
            Block.makeCuboidShape(4, 1, 4, 12, 8, 12));
    private static final VoxelShape CEILING_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(3, 15, 3, 13, 16, 13),
            Block.makeCuboidShape(4, 8, 4, 12, 15, 12));
    private static final VoxelShape NORTH_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(3, 3, 15, 13, 13, 16),
            Block.makeCuboidShape(4, 4, 8, 12, 12, 15));
    private static final VoxelShape EAST_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(0, 3, 3, 1, 13, 13),
            Block.makeCuboidShape(1, 4, 4, 8, 12, 12));
    private static final VoxelShape SOUTH_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(3, 3, 0, 13, 13, 1),
            Block.makeCuboidShape(4, 4, 1, 12, 12, 8));
    private static final VoxelShape WEST_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(15, 3, 3, 16, 13, 13),
            Block.makeCuboidShape(8, 4, 4, 15, 12, 12));

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction direction = state.get(HORIZONTAL_FACING);
        switch(state.get(FACE)) {
            case FLOOR: {
                return FLOOR_SHAPE;
            }
            case WALL: {
                switch(direction) {
                    case EAST:
                        return EAST_SHAPE;
                    case WEST:
                        return WEST_SHAPE;
                    case SOUTH:
                        return SOUTH_SHAPE;
                    case NORTH:
                    default:
                        return NORTH_SHAPE;
                }
            }
            case CEILING:
            default:
                return CEILING_SHAPE;
        }
    }
}
