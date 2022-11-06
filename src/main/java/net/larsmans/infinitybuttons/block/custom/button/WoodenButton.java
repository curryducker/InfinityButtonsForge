package net.larsmans.infinitybuttons.block.custom.button;

import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class WoodenButton extends AbstractButton{
    protected WoodenButton(Properties properties) {
        super(true, properties);
    }

    @Override
    public int getActiveDuration() {
        return 30;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean pressed) {
        return pressed ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF;
    }
}
