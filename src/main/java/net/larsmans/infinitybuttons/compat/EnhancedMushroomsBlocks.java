package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.button.compat.GlowshroomLargeButton;
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

public class EnhancedMushroomsBlocks {

    public static final RegistryObject<Block> RED_MUSHROOM_LARGE_BUTTON = registerMushroomLargeButton("red");
    public static final RegistryObject<Block> BROWN_MUSHROOM_LARGE_BUTTON = registerMushroomLargeButton("brown");

    public static final RegistryObject<Block> GLOWSHROOM_LARGE_BUTTON = registerBlock("glowshroom_large_button",
            () -> new GlowshroomLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD).setLightLevel((state) -> 14)));

    public static final RegistryObject<Block> RED_MUSHROOM_BOOKSHELF_SECRET_BUTTON = registerMushroomBookshelf("red");
    public static final RegistryObject<Block> BROWN_MUSHROOM_BOOKSHELF_SECRET_BUTTON = registerMushroomBookshelf("brown");

    public static final RegistryObject<Block> RED_MUSHROOM_PLANK_SECRET_BUTTON = registerMushroomPlankButton("red", MaterialColor.SAND);
    public static final RegistryObject<Block> BROWN_MUSHROOM_PLANK_SECRET_BUTTON = registerMushroomPlankButton("brown", MaterialColor.DIRT);

    /**
     * Methods
     */

    private static Block byName(String block) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation("enhanced_mushrooms", block));
    }

    private static RegistryObject<Block> registerMushroomBookshelf(String color) {
        return registerBlock(color + "_mushroom_bookshelf_secret_button", () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD), byName(color + "_mushroom_bookshelf")));
    }

    private static RegistryObject<Block> registerMushroomLargeButton(String color) {
        return registerBlock(color + "_mushroom_large_button", () -> new WoodenCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD), true));
    }

    private static RegistryObject<Block> registerMushroomPlankButton(String color, MaterialColor materialColor) {
        return registerBlock(color + "_mushroom_plank_secret_button", () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, materialColor)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD), byName(color + "_mushroom_planks")));
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
        InfinityButtons.LOGGER.debug("Registering Enhanced Mushrooms Compat Blocks for Infinity Buttons");
    }
}
