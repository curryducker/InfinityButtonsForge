package net.larsmans.infinitybuttons.block.custom.button;

import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class EmeraldButton extends AbstractSmallButton {

    public EmeraldButton(Properties properties, boolean large) {
        super(false, large, properties);
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
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        InfinityButtonsUtil.tooltip(tooltip, "emerald_button1", "emerald_button2");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
