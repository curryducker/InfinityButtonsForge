package net.larsmans.infinitybuttons.block.custom;

import net.larsmans.infinitybuttons.block.custom.button.AbstractWallButton;
import net.minecraft.block.Block;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.shapes.VoxelShape;

public class HoglinMountButton extends AbstractWallButton {

    protected static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(0, 0, 13, 16, 16, 16);
    protected static final VoxelShape EAST_SHAPE =  Block.makeCuboidShape(0, 0, 0, 3, 16, 16);
    protected static final VoxelShape SOUTH_SHAPE =  Block.makeCuboidShape(0, 0, 0, 16, 16, 3);
    protected static final VoxelShape WEST_SHAPE =  Block.makeCuboidShape(13, 0, 0, 16, 16, 16);

    public HoglinMountButton (Properties settings) {
        super(settings, NORTH_SHAPE, EAST_SHAPE, SOUTH_SHAPE, WEST_SHAPE, NORTH_SHAPE, EAST_SHAPE, SOUTH_SHAPE, WEST_SHAPE);
    }

    @Override
    public int getPressDuration() {
        return 15;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean pressed) {
        return pressed ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    }
}
