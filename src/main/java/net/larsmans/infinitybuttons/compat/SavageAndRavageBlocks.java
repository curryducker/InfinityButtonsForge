package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.secretbutton.AbstractSecretButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.ChiseledStonepatBrickSecretButton;
import net.larsmans.infinitybuttons.item.InfinityButtonsItemGroup;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class SavageAndRavageBlocks {

    public static final RegistryObject<Block> CHISELED_GLOOMY_TILE_SECRET_BUTTON = registerBlock(
            () -> new ChiseledStonepatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool().setLightLevel(SavageAndRavageBlocks::getPressLight), ForgeRegistries.BLOCKS.getValue(new ResourceLocation("savageandravage", "chiseled_gloomy_tiles"))));

    /**
     * Methods
     */

    private static <T extends Block> RegistryObject<T> registerBlock(Supplier<T> block) {
        RegistryObject<T> toReturn = InfinityButtonsBlocks.BLOCKS.register("chiseled_gloomy_tile_secret_button", block);
        registerBlockItem(toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(RegistryObject<T> block) {
        RegistryObject<Item> register = InfinityButtonsItems.ITEMS.register("chiseled_gloomy_tile_secret_button", () -> new BlockItem(block.get(),
                new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
        InfinityButtonsUtil.REGISTRY_FOR_TAB.add(register);
    }

    public static int getPressLight(BlockState state) {
        return state.get(AbstractSecretButton.PRESSED) ? 7 : 0;
    }

    public static void registerCompatBlocks() {
        InfinityButtons.LOGGER.debug("Registering Savage and Ravage Compat Blocks for Infinity Buttons");
    }
}
