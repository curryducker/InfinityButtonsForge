package net.larsmans.infinitybuttons;

import me.shedaniel.autoconfig.AutoConfig;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.emergencybutton.SafeEmergencyButton;
import net.larsmans.infinitybuttons.block.custom.letterbutton.LetterButton;
import net.larsmans.infinitybuttons.config.InfinityButtonsConfig;
import net.larsmans.infinitybuttons.item.custom.SafeEmergencyButtonItem;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
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

    public static void buildSafety() {
        if (SAFETY_BUTTONS == null) {
            SAFETY_BUTTONS = new ArrayList<>();
            for (RegistryObject<? extends Block> entry : InfinityButtonsBlocks.BLOCKS.getEntries())
                if (entry.get() instanceof SafeEmergencyButton)
                    SAFETY_BUTTONS.add((SafeEmergencyButtonItem) entry.get().asItem());
        }
    }
}