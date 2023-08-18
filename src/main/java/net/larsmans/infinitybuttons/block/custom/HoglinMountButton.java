package net.larsmans.infinitybuttons.block.custom;

import net.larsmans.infinitybuttons.block.custom.button.AbstractWallButton;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HoglinMountButton extends AbstractWallButton {

    protected static final VoxelShape NORTH_SHAPE = makeCuboidShape(0, 0, 13, 16, 16, 16);
    protected static final VoxelShape EAST_SHAPE =  makeCuboidShape(0, 0, 0, 3, 16, 16);
    protected static final VoxelShape SOUTH_SHAPE =  makeCuboidShape(0, 0, 0, 16, 16, 3);
    protected static final VoxelShape WEST_SHAPE =  makeCuboidShape(13, 0, 0, 16, 16, 16);

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

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(this)));
    }
}
