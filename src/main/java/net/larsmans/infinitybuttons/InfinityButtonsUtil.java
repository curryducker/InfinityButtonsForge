package net.larsmans.infinitybuttons;

import me.shedaniel.autoconfig.AutoConfig;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.emergencybutton.SafeEmergencyButton;
import net.larsmans.infinitybuttons.block.custom.letterbutton.LetterButton;
import net.larsmans.infinitybuttons.config.InfinityButtonsConfig;
import net.larsmans.infinitybuttons.item.custom.SafeEmergencyButtonItem;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.item.Item;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class InfinityButtonsUtil {
    public static List<RegistryObject<Item>> REGISTRY_FOR_TAB = new ArrayList<>();

    public static final IFormattableTextComponent HOLD_SHIFT_TEXT = new TranslationTextComponent("infinitybuttons.tooltip.hold_shift").mergeStyle(TextFormatting.GRAY);
    public static final IFormattableTextComponent SAFE_EMERGENCY_BUTTON_ACTIONBAR_TEXT = new TranslationTextComponent("infinitybuttons.actionbar.closed_safety_button");

    public static List<SafeEmergencyButtonItem> SAFETY_BUTTONS;

    public static boolean crouchClickOverrides(Block block) {
        return block instanceof SafeEmergencyButton || block instanceof LetterButton;
    }

    public static void tooltip(List<ITextComponent> tooltip, String name) {
        if (AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig().tooltips) {
            if (Screen.hasShiftDown()) {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip." + name).mergeStyle(TextFormatting.GRAY));
            } else {
                tooltip.add(HOLD_SHIFT_TEXT);
            }
        }
    }

    public static void tooltip(List<ITextComponent> tooltip, String name1, String name2) {
        if (AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig().tooltips) {
            if (Screen.hasShiftDown()) {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip." + name1).mergeStyle(TextFormatting.GRAY));
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip." + name2).mergeStyle(TextFormatting.GRAY));
            } else {
                tooltip.add(HOLD_SHIFT_TEXT);
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

    public static void buildSafety() {
        if (SAFETY_BUTTONS == null) {
            SAFETY_BUTTONS = new ArrayList<>();
            for (RegistryObject<? extends Block> entry : InfinityButtonsBlocks.BLOCKS.getEntries())
                if (entry.get() instanceof SafeEmergencyButton)
                    SAFETY_BUTTONS.add((SafeEmergencyButtonItem) entry.get().asItem());
        }
    }
}