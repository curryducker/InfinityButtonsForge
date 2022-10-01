package net.larsmans.infinitybuttons.block.custom.largebutton;

import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class StoneLargeButton extends AbstractLargeButton {
    public StoneLargeButton(Properties properties) {
        super(false, properties);
    }

    @Override
    public int getActiveDuration() {
        return 20;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return isOn ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    }
}
