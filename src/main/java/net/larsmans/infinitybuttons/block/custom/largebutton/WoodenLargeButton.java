package net.larsmans.infinitybuttons.block.custom.largebutton;

import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class WoodenLargeButton extends AbstractLargeButton {
    public WoodenLargeButton(Properties properties) {
        super(true, properties);
    }

    @Override
    public int getActiveDuration() {
        return 30;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return isOn ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF;
    }
}
