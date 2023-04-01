package net.larsmans.infinitybuttons;

import me.shedaniel.autoconfig.AutoConfig;
import net.larsmans.infinitybuttons.config.InfinityButtonsConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class InfinityButtonsUtil {

    public static void tooltip(List<ITextComponent> tooltip, String name) {
        if (AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig().tooltips) {
            if (Screen.hasShiftDown()) {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip." + name));
            } else {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip.hold_shift"));
            }
        }
    }

    public static void tooltip(List<ITextComponent> tooltip, String name1, String name2) {
        if (AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig().tooltips) {
            if (Screen.hasShiftDown()) {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip." + name1));
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip." + name2));
            } else {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip.hold_shift"));
            }
        }
    }

    public static void playGlobalSound (World level, BlockPos pos, SoundEvent soundEvent, SoundCategory soundSource) {
        ActiveRenderInfo cam = Minecraft.getInstance().gameRenderer.getActiveRenderInfo();
        if (cam.isValid()) {
            double x = cam.getProjectedView().x;
            double y = cam.getProjectedView().y;
            double z = cam.getProjectedView().z;
            double d0 = (double)pos.getX() - x;
            double d1 = (double)pos.getY() - y;
            double d2 = (double)pos.getZ() - z;
            double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
            if (d3 > 0.0D) {
                x += d0 / d3 * 2.0D;
                y += d1 / d3 * 2.0D;
                z += d2 / d3 * 2.0D;
            }
            level.playSound(x, y, z, soundEvent, soundSource, 1.0F, 1.0F, false);
        }
    }
}