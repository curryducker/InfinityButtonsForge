package net.larsmans.infinitybuttons.block.custom.button;

import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class StoneButton extends AbstractSmallButton{
    public StoneButton(Properties properties, boolean large) {
        super(false, large, properties);
    }

    @Override
    public int getActiveDuration() {
        return 20;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean pressed) {
        return pressed ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    }
}
