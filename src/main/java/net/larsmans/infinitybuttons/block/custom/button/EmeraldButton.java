package net.larsmans.infinitybuttons.block.custom.button;

import me.shedaniel.autoconfig.AutoConfig;
import net.larsmans.infinitybuttons.InfinityButtonsConfig;
import net.larsmans.infinitybuttons.block.custom.largebutton.AbstractLargeButton;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.List;

public class EmeraldButton extends AbstractButton {
    InfinityButtonsConfig config = AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig();

    public EmeraldButton(Properties properties) {
        super(false, properties);
    }

    @Override
    public int getActiveDuration() {
        return (int)Math.floor(Math.random()*(90-10+1)+10);
    }

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return isOn ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (config.tooltips) {
            if(Screen.hasShiftDown()) {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip.emerald_button"));
            } else {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip.hold_shift"));
            }
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
