package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.largebutton.compat.WoodenCompatLargeButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.ChiseledCompatBrickSecretButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.CompatBookshelfSecretButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.CompatPlankSecretButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.FullCompatBrickSecretButton;
import net.larsmans.infinitybuttons.item.InfinityButtonsItemGroup;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class EnvironmentalBlocks {

    public static final RegistryObject<Block> WILLOW_LARGE_BUTTON = registerLargeButton("willow");
    public static final RegistryObject<Block> CHERRY_LARGE_BUTTON = registerLargeButton("cherry");
    public static final RegistryObject<Block> WISTERIA_LARGE_BUTTON = registerLargeButton("wisteria");

    public static final RegistryObject<Block> WILLOW_BOOKSHELF_SECRET_BUTTON = registerBookshelf("willow");
    public static final RegistryObject<Block> CHERRY_BOOKSHELF_SECRET_BUTTON = registerBookshelf("cherry");
    public static final RegistryObject<Block> WISTERIA_BOOKSHELF_SECRET_BUTTON = registerBookshelf("wisteria");

    public static final RegistryObject<Block> MUD_BRICK_SECRET_BUTTON = registerBlock("mud_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 2.5f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_MUD_BRICK_SECRET_BUTTON = registerBlock("chiseled_mud_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 2.5f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_BRICK_SECRET_BUTTON = registerBlock("chiseled_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> ICE_BRICK_SECRET_BUTTON = registerBlock("ice_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ICE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.0f, 2.0f).notSolid().sound(SoundType.GLASS).setRequiresTool().slipperiness(0.99F)));

    public static final RegistryObject<Block> CHISELED_ICE_BRICK_SECRET_BUTTON = registerBlock("chiseled_ice_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ICE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.0f, 2.0f).notSolid().sound(SoundType.GLASS).setRequiresTool().slipperiness(0.99F)));

    public static final RegistryObject<Block> TERRACOTTA_BRICK_SECRET_BUTTON = registerBlock("terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ADOBE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> RED_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("red", MaterialColor.RED_TERRACOTTA);
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("orange", MaterialColor.ORANGE_TERRACOTTA);
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("yellow", MaterialColor.YELLOW_TERRACOTTA);
    public static final RegistryObject<Block> LIME_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("lime", MaterialColor.LIME_TERRACOTTA);
    public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("green", MaterialColor.GREEN_TERRACOTTA);
    public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("cyan", MaterialColor.CYAN_TERRACOTTA);
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("light_blue", MaterialColor.LIGHT_BLUE_TERRACOTTA);
    public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("blue", MaterialColor.BLUE_TERRACOTTA);
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("purple", MaterialColor.PURPLE_TERRACOTTA);
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("magenta", MaterialColor.MAGENTA_TERRACOTTA);
    public static final RegistryObject<Block> PINK_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("pink", MaterialColor.PINK_TERRACOTTA);
    public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("brown", MaterialColor.BROWN_TERRACOTTA);
    public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("white", MaterialColor.WHITE_TERRACOTTA);
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("light_gray", MaterialColor.LIGHT_GRAY_TERRACOTTA);
    public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("gray", MaterialColor.GRAY_TERRACOTTA);
    public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICK_SECRET_BUTTON = registerTerracotta("black", MaterialColor.BLACK_TERRACOTTA);

    public static final RegistryObject<Block> CHISELED_TERRACOTTA_BRICK_SECRET_BUTTON = registerBlock("chiseled_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ADOBE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_RED_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("red", MaterialColor.RED_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_ORANGE_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("orange", MaterialColor.ORANGE_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_YELLOW_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("yellow", MaterialColor.YELLOW_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_LIME_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("lime", MaterialColor.LIME_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_GREEN_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("green", MaterialColor.GREEN_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_CYAN_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("cyan", MaterialColor.CYAN_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_LIGHT_BLUE_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("light_blue", MaterialColor.LIGHT_BLUE_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_BLUE_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("blue", MaterialColor.BLUE_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_PURPLE_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("purple", MaterialColor.PURPLE_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_MAGENTA_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("magenta", MaterialColor.MAGENTA_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_PINK_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("pink", MaterialColor.PINK_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_BROWN_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("brown", MaterialColor.BROWN_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_WHITE_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("white", MaterialColor.WHITE_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_LIGHT_GRAY_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("light_gray", MaterialColor.LIGHT_GRAY_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_GRAY_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("gray", MaterialColor.GRAY_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_BLACK_TERRACOTTA_BRICK_SECRET_BUTTON = registerChiseledTerracotta("black", MaterialColor.BLACK_TERRACOTTA);

    public static final RegistryObject<Block> WILLOW_PLANK_SECRET_BUTTON = registerPlankButton("willow", MaterialColor.WOOD);
    public static final RegistryObject<Block> CHERRY_PLANK_SECRET_BUTTON = registerPlankButton("cherry", MaterialColor.WOOD);
    public static final RegistryObject<Block> WISTERIA_PLANK_SECRET_BUTTON = registerPlankButton("wisteria", MaterialColor.WHITE_TERRACOTTA);

    /**
     * Methods
     */

    private static RegistryObject<Block> registerBookshelf(String wood) {
        return registerBlock(wood + "_bookshelf_secret_button", () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));
    }

    private static RegistryObject<Block> registerLargeButton(String wood) {
        return registerBlock(wood + "_large_button", () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));
    }

    private static RegistryObject<Block> registerPlankButton(String wood, MaterialColor materialColor) {
        return registerBlock(wood + "_plank_secret_button", () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, materialColor)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));
    }

    private static RegistryObject<Block> registerTerracotta(String color, MaterialColor materialColor) {
        return registerBlock(color + "_terracotta_brick_secret_button", () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, materialColor)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));
    }

    private static RegistryObject<Block> registerChiseledTerracotta(String color, MaterialColor materialColor) {
        return registerBlock("chiseled_" + color + "_terracotta_brick_secret_button", () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, materialColor)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));
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
        InfinityButtons.LOGGER.debug("Registering Environmental Compat Blocks for Infinity Buttons");
    }
}
