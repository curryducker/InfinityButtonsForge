package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.button.compat.WoodenCompatButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.CompatBookshelfSecretButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.CompatPlankSecretButton;
import net.larsmans.infinitybuttons.item.InfinityButtonsItemGroup;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
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

public class BayouBluesBlocks {

    public static final RegistryObject<Block> CYPRESS_LARGE_BUTTON = registerBlock("cypress_large_button",
            () -> new WoodenCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD), true));

    public static final RegistryObject<Block> CYPRESS_BOOKSHELF_SECRET_BUTTON = registerBlock("cypress_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD), byName("cypress_bookshelf")));

    public static final RegistryObject<Block> CYPRESS_PLANK_SECRET_BUTTON = registerBlock("cypress_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD), byName("cypress_planks")));

    /**
     * Methods
     */

    private static Block byName(String block) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation("bayou_blues", block));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = InfinityButtonsBlocks.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        InfinityButtonsItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
    }

    public static void registerCompatBlocks() {
        InfinityButtons.LOGGER.debug("Registering Bayou Blues Compat Blocks for Infinity Buttons");
    }
}
