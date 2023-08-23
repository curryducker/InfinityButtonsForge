package net.larsmans.infinitybuttons.item;

import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.DoorbellButton;
import net.larsmans.infinitybuttons.block.custom.LampButton;
import net.larsmans.infinitybuttons.block.custom.LanternButton;
import net.larsmans.infinitybuttons.block.custom.button.*;
import net.larsmans.infinitybuttons.block.custom.consolebutton.ConsoleButton;
import net.larsmans.infinitybuttons.block.custom.emergencybutton.EmergencyButton;
import net.larsmans.infinitybuttons.block.custom.emergencybutton.SafeEmergencyButton;
import net.larsmans.infinitybuttons.block.custom.letterbutton.LetterButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.AbstractSecretButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.BookshelfSecretButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.PlankSecretButton;
import net.larsmans.infinitybuttons.block.custom.torch.RedstoneTorchButton;
import net.larsmans.infinitybuttons.block.custom.torch.TorchButton;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.RegistryObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import static net.larsmans.infinitybuttons.InfinityButtonsUtil.REGISTRY_FOR_TAB;
import static net.larsmans.infinitybuttons.InfinityButtonsUtil.blockPathContains;

public class InfinityButtonsItemGroup extends ItemGroup {

    public static final ItemGroup INFINITYBUTTONS = new InfinityButtonsItemGroup("infinityButtonsTab");

    public InfinityButtonsItemGroup(String infinityButtonsTab) {
        super(infinityButtonsTab);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(InfinityButtonsBlocks.OAK_LARGE_BUTTON.get());
    }

    @Override
    public void fill(NonNullList<ItemStack> items) {
        String[] BEFORE_PLANKS = {"brick_secret_button", "stone_brick_secret_button", "mossy_stone_brick_secret_button", "cracked_stone_brick_secret_button", "chiseled_stone_brick_secret_button", "deepslate_brick_secret_button", "cracked_deepslate_brick_secret_button", "deepslate_tile_secret_button", "cracked_deepslate_tile_secret_button"};
        REGISTRY_FOR_TAB.sort(Comparator.comparing(o -> {
            Block block = Block.getBlockFromItem(o.get());
            if (block instanceof AbstractSmallButton && !((AbstractSmallButton) block).isLarge()) {
                if (block instanceof WoodenButton) {
                    return "AA";
                } else if (!blockPathContains(block, "blackstone") && blockPathContains(block, "stone") || blockPathContains(block, "deepslate")) {
                    return "ABA";
                } else if (block instanceof StoneButton) {
                    return "ABB";
                } else if (block instanceof CopperButton || block instanceof StickyCopperButton || block instanceof ArrowButton || block instanceof EmeraldButton || block instanceof DiamondButton) {
                    return "AC";
                } else if (block instanceof PrismarineButton) {
                    return "AD";
                } else {
                    return "AZ";
                }
            } else if (block instanceof AbstractSmallButton && ((AbstractSmallButton) block).isLarge()) {
                if (block instanceof WoodenButton) {
                    return "BA";
                } else if (!blockPathContains(block, "blackstone") && blockPathContains(block, "stone") || blockPathContains(block, "deepslate")) {
                    return "BBA";
                } else if (block instanceof StoneButton) {
                    return "BBB";
                } else if (block instanceof CopperButton || block instanceof StickyCopperButton || block instanceof ArrowButton || block instanceof EmeraldButton || block instanceof DiamondButton) {
                    return "BC";
                } else if (block instanceof PrismarineButton) {
                    return "BD";
                } else {
                    return "BZ";
                }
            } else if (block instanceof EmergencyButton || block instanceof SafeEmergencyButton) {
                return "C";
            } else if (block instanceof AbstractSecretButton) {
                if (block instanceof BookshelfSecretButton) {
                    return "DA";
                } else if (Arrays.stream(BEFORE_PLANKS).anyMatch(s -> s.equals(Objects.requireNonNull(block.getRegistryName()).getPath()))) {
                    return "DB";
                } else if (block instanceof PlankSecretButton) {
                    return "DC";
                } else {
                    return "DZ";
                }
            } else if (block instanceof DoorbellButton || block instanceof LampButton || block instanceof LetterButton) {
                return "E";
            } else if (block instanceof LanternButton) {
                return "F";
            } else if (block instanceof ConsoleButton) {
                return "G";
            } else if (block instanceof TorchButton || block instanceof RedstoneTorchButton) {
                return "H";
            } else {
                return "ZZ";
            }
        }));
        for (RegistryObject<Item> entry : REGISTRY_FOR_TAB) {
            Item item = entry.get();
            item.fillItemGroup(this, items);
        }
    }
}
