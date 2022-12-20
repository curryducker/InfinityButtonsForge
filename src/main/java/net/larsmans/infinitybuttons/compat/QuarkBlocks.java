package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.button.compat.CompatStoneButton;
import net.larsmans.infinitybuttons.block.custom.button.compat.CompatWoodenButton;
import net.larsmans.infinitybuttons.block.custom.button.compat.PrismarineCompatButton;
import net.larsmans.infinitybuttons.block.custom.largebutton.compat.PrismarineCompatLargeButton;
import net.larsmans.infinitybuttons.block.custom.largebutton.compat.StoneCompatLargeButton;
import net.larsmans.infinitybuttons.block.custom.largebutton.compat.WoodenCompatLargeButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.*;
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
import vazkii.quark.base.handler.QuarkSounds;

import java.util.function.Supplier;

public class QuarkBlocks {

    public static final RegistryObject<Block> RED_STAINED_BUTTON = registerStainedButton("red");
    public static final RegistryObject<Block> ORANGE_STAINED_BUTTON = registerStainedButton("orange");
    public static final RegistryObject<Block> YELLOW_STAINED_BUTTON = registerStainedButton("yellow");
    public static final RegistryObject<Block> LIME_STAINED_BUTTON = registerStainedButton("lime");
    public static final RegistryObject<Block> GREEN_STAINED_BUTTON = registerStainedButton("green");
    public static final RegistryObject<Block> CYAN_STAINED_BUTTON = registerStainedButton("cyan");
    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_BUTTON = registerStainedButton("light_blue");
    public static final RegistryObject<Block> BLUE_STAINED_BUTTON = registerStainedButton("blue");
    public static final RegistryObject<Block> PURPLE_STAINED_BUTTON = registerStainedButton("purple");
    public static final RegistryObject<Block> MAGENTA_STAINED_BUTTON = registerStainedButton("magenta");
    public static final RegistryObject<Block> PINK_STAINED_BUTTON = registerStainedButton("pink");
    public static final RegistryObject<Block> BROWN_STAINED_BUTTON = registerStainedButton("brown");
    public static final RegistryObject<Block> WHITE_STAINED_BUTTON = registerStainedButton("white");
    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_BUTTON = registerStainedButton("light_gray");
    public static final RegistryObject<Block> GRAY_STAINED_BUTTON = registerStainedButton("gray");
    public static final RegistryObject<Block> BLACK_STAINED_BUTTON = registerStainedButton("black");

    public static final RegistryObject<Block> DEEPSLATE_BUTTON = registerBlock("deepslate_button",
            () -> new CompatStoneButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ELDER_PRISMARINE_BUTTON = registerBlock("elder_prismarine_button",
            () -> new PrismarineCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ELDER_PRISMARINE_BRICK_BUTTON = registerBlock("elder_prismarine_brick_button",
            () -> new PrismarineCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARK_ELDER_PRISMARINE_BUTTON = registerBlock("dark_elder_prismarine_button",
            () -> new PrismarineCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> RED_STAINED_LARGE_BUTTON = registerStainedLargeButton("red");
    public static final RegistryObject<Block> ORANGE_STAINED_LARGE_BUTTON = registerStainedLargeButton("orange");
    public static final RegistryObject<Block> YELLOW_STAINED_LARGE_BUTTON = registerStainedLargeButton("yellow");
    public static final RegistryObject<Block> LIME_STAINED_LARGE_BUTTON = registerStainedLargeButton("lime");
    public static final RegistryObject<Block> GREEN_STAINED_LARGE_BUTTON = registerStainedLargeButton("green");
    public static final RegistryObject<Block> CYAN_STAINED_LARGE_BUTTON = registerStainedLargeButton("cyan");
    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_LARGE_BUTTON = registerStainedLargeButton("light_blue");
    public static final RegistryObject<Block> BLUE_STAINED_LARGE_BUTTON = registerStainedLargeButton("blue");
    public static final RegistryObject<Block> PURPLE_STAINED_LARGE_BUTTON = registerStainedLargeButton("purple");
    public static final RegistryObject<Block> MAGENTA_STAINED_LARGE_BUTTON = registerStainedLargeButton("magenta");
    public static final RegistryObject<Block> PINK_STAINED_LARGE_BUTTON = registerStainedLargeButton("pink");
    public static final RegistryObject<Block> BROWN_STAINED_LARGE_BUTTON = registerStainedLargeButton("brown");
    public static final RegistryObject<Block> WHITE_STAINED_LARGE_BUTTON = registerStainedLargeButton("white");
    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_LARGE_BUTTON = registerStainedLargeButton("light_gray");
    public static final RegistryObject<Block> GRAY_STAINED_LARGE_BUTTON = registerStainedLargeButton("gray");
    public static final RegistryObject<Block> BLACK_STAINED_LARGE_BUTTON = registerStainedLargeButton("black");

    public static final RegistryObject<Block> DEEPSLATE_LARGE_BUTTON = registerBlock("deepslate_large_button",
            () -> new StoneCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ELDER_PRISMARINE_LARGE_BUTTON = registerBlock("elder_prismarine_large_button",
            () -> new PrismarineCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ELDER_PRISMARINE_BRICK_LARGE_BUTTON = registerBlock("elder_prismarine_brick_large_button",
            () -> new PrismarineCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARK_ELDER_PRISMARINE_LARGE_BUTTON = registerBlock("dark_elder_prismarine_large_button",
            () -> new PrismarineCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> SPRUCE_BOOKSHELF_SECRET_BUTTON = registerBookshelf("spruce");
    public static final RegistryObject<Block> BIRCH_BOOKSHELF_SECRET_BUTTON = registerBookshelf("birch");
    public static final RegistryObject<Block> JUNGLE_BOOKSHELF_SECRET_BUTTON = registerBookshelf("jungle");
    public static final RegistryObject<Block> ACACIA_BOOKSHELF_SECRET_BUTTON = registerBookshelf("acacia");
    public static final RegistryObject<Block> DARK_OAK_BOOKSHELF_SECRET_BUTTON = registerBookshelf("dark_oak");
    public static final RegistryObject<Block> CRIMSON_BOOKSHELF_SECRET_BUTTON = registerBookshelf("crimson");
    public static final RegistryObject<Block> WARPED_BOOKSHELF_SECRET_BUTTON = registerBookshelf("warped");

    public static final RegistryObject<Block> DEEPSLATE_BRICK_SECRET_BUTTON = registerBlock("deepslate_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.5f, 6.0f).notSolid().sound(QuarkSounds.DEEPSLATE_BRICKS_TYPE).setRequiresTool()));

    public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICK_SECRET_BUTTON = registerBlock("cracked_deepslate_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.5f, 6.0f).notSolid().sound(QuarkSounds.DEEPSLATE_BRICKS_TYPE).setRequiresTool()));

    public static final RegistryObject<Block> DEEPSLATE_TILE_SECRET_BUTTON = registerBlock("deepslate_tile_secret_button",
            () -> new DeepslateTileSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.5f, 6.0f).notSolid().sound(QuarkSounds.DEEPSLATE_TILES_TYPE).setRequiresTool()));

    public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILE_SECRET_BUTTON = registerBlock("cracked_deepslate_tile_secret_button",
            () -> new DeepslateTileSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.5f, 6.0f).notSolid().sound(QuarkSounds.DEEPSLATE_TILES_TYPE).setRequiresTool()));

    public static final RegistryObject<Block> PERMAFROST_BRICK_SECRET_BUTTON = registerBlock("permafrost_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 10.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> SANDY_BRICK_SECRET_BUTTON = registerBlock("sandy_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHARRED_NETHER_BRICK_SECRET_BUTTON = registerBlock("charred_nether_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> BLUE_NETHER_BRICK_SECRET_BUTTON = registerBlock("blue_nether_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> TWISTING_POLISHED_BLACKSTONE_BRICK_SECRET_BUTTON = registerBlock("twisting_polished_blackstone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> WEEPING_POLISHED_BLACKSTONE_BRICK_SECRET_BUTTON = registerBlock("weeping_polished_blackstone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> MAGMA_BRICK_SECRET_BUTTON = registerBlock("magma_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 10.0f).notSolid().sound(SoundType.STONE).setRequiresTool().setLightLevel((state) -> {
                        return 3;
                    }).setEmmisiveRendering((s, r, p) -> true)));

    public static final RegistryObject<Block> POLISHED_GRANITE_BRICK_SECRET_BUTTON = registerPolishedButton("granite", MaterialColor.DIRT);
    public static final RegistryObject<Block> POLISHED_DIORITE_BRICK_SECRET_BUTTON = registerPolishedButton("diorite", MaterialColor.QUARTZ);
    public static final RegistryObject<Block> POLISHED_ANDESITE_BRICK_SECRET_BUTTON = registerPolishedButton("andesite", MaterialColor.STONE);
    public static final RegistryObject<Block> POLISHED_MARBLE_BRICK_SECRET_BUTTON = registerPolishedButton("marble", MaterialColor.QUARTZ);
    public static final RegistryObject<Block> POLISHED_LIMESTONE_BRICK_SECRET_BUTTON = registerPolishedButton("limestone", MaterialColor.STONE);
    public static final RegistryObject<Block> POLISHED_JASPER_BRICK_SECRET_BUTTON = registerPolishedButton("jasper", MaterialColor.RED_TERRACOTTA);
    public static final RegistryObject<Block> POLISHED_SLATE_BRICK_SECRET_BUTTON = registerPolishedButton("slate", MaterialColor.ICE);
    public static final RegistryObject<Block> POLISHED_VOIDSTONE_BRICK_SECRET_BUTTON = registerPolishedButton("voidstone", MaterialColor.BLACK);

    public static final RegistryObject<Block> BIOTITE_BRICK_SECRET_BUTTON = registerBlock("biotite_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.8f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> DARK_ELDER_PRISMARINE_SECRET_BUTTON = registerBlock("dark_elder_prismarine_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ADOBE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 10f).notSolid().sound(SoundType.STONE).setRequiresTool()));


    public static final RegistryObject<Block> CHISELED_POLISHED_GRANITE_BRICK_SECRET_BUTTON = registerChiseledPolishedButton("granite", MaterialColor.DIRT);
    public static final RegistryObject<Block> CHISELED_POLISHED_DIORITE_BRICK_SECRET_BUTTON = registerChiseledPolishedButton("diorite", MaterialColor.QUARTZ);
    public static final RegistryObject<Block> CHISELED_POLISHED_ANDESITE_BRICK_SECRET_BUTTON = registerChiseledPolishedButton("andesite", MaterialColor.STONE);
    public static final RegistryObject<Block> CHISELED_POLISHED_MARBLE_BRICK_SECRET_BUTTON = registerChiseledPolishedButton("marble", MaterialColor.QUARTZ);
    public static final RegistryObject<Block> CHISELED_POLISHED_LIMESTONE_BRICK_SECRET_BUTTON = registerChiseledPolishedButton("limestone", MaterialColor.STONE);
    public static final RegistryObject<Block> CHISELED_POLISHED_JASPER_BRICK_SECRET_BUTTON = registerChiseledPolishedButton("jasper", MaterialColor.RED_TERRACOTTA);
    public static final RegistryObject<Block> CHISELED_POLISHED_SLATE_BRICK_SECRET_BUTTON = registerChiseledPolishedButton("slate", MaterialColor.ICE);
    public static final RegistryObject<Block> CHISELED_POLISHED_VOIDSTONE_BRICK_SECRET_BUTTON = registerChiseledPolishedButton("voidstone", MaterialColor.BLACK);

    public static final RegistryObject<Block> RED_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("red", MaterialColor.RED);
    public static final RegistryObject<Block> ORANGE_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("orange", MaterialColor.ADOBE);
    public static final RegistryObject<Block> YELLOW_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("yellow", MaterialColor.YELLOW);
    public static final RegistryObject<Block> LIME_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("lime", MaterialColor.LIME);
    public static final RegistryObject<Block> GREEN_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("green", MaterialColor.GREEN);
    public static final RegistryObject<Block> CYAN_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("cyan", MaterialColor.CYAN);
    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("light_blue", MaterialColor.LIGHT_BLUE);
    public static final RegistryObject<Block> BLUE_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("blue", MaterialColor.BLUE);
    public static final RegistryObject<Block> PURPLE_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("purple", MaterialColor.PURPLE);
    public static final RegistryObject<Block> MAGENTA_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("magenta", MaterialColor.MAGENTA);
    public static final RegistryObject<Block> PINK_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("pink", MaterialColor.PINK);
    public static final RegistryObject<Block> BROWN_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("brown", MaterialColor.BROWN);
    public static final RegistryObject<Block> WHITE_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("white", MaterialColor.SNOW);
    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("light_gray", MaterialColor.LIGHT_GRAY);
    public static final RegistryObject<Block> GRAY_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("gray", MaterialColor.GRAY);
    public static final RegistryObject<Block> BLACK_STAINED_PLANK_SECRET_BUTTON = registerStainedPlankButton("black", MaterialColor.BLACK);
    
    /**
     * Methods
     */

    private static RegistryObject<Block> registerStainedPlankButton(String color, MaterialColor materialColor) {
        return registerBlock(color + "_stained_plank_secret_button", () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, materialColor)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));
    }

    private static RegistryObject<Block> registerChiseledPolishedButton(String type, MaterialColor materialColor) {
        return registerBlock("chiseled_polished_" + type + "_brick_secret_button", () -> new ChiseledStonepatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, materialColor)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));
    }

    private static RegistryObject<Block> registerPolishedButton(String type, MaterialColor materialColor) {
        return registerBlock("polished_" + type + "_brick_secret_button", () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, materialColor)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));
    }

    private static RegistryObject<Block> registerBookshelf(String wood) {
        return registerBlock(wood + "_bookshelf_secret_button", () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));
    }

    private static RegistryObject<Block> registerStainedLargeButton(String color) {
        return registerBlock(color + "_stained_large_button", () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));
    }

    private static RegistryObject<Block> registerStainedButton(String color) {
        return registerBlock(color + "_stained_button", () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));
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
        InfinityButtons.LOGGER.debug("Registering Quark Compat Blocks for Infinity Buttons");
    }
}
