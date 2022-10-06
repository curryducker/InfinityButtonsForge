package net.larsmans.infinitybuttons.block;

import com.minecraftabnormals.endergetic.client.particles.EEParticles;
import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.custom.EmergencyButton;
import net.larsmans.infinitybuttons.block.custom.button.ArrowButton;
import net.larsmans.infinitybuttons.block.custom.button.CopperButton;
import net.larsmans.infinitybuttons.block.custom.button.EmeraldButton;
import net.larsmans.infinitybuttons.block.custom.button.StickyCopperButton;
import net.larsmans.infinitybuttons.block.custom.largebutton.*;
import net.larsmans.infinitybuttons.block.custom.secretbutton.*;
import net.larsmans.infinitybuttons.block.custom.torch.*;
import net.larsmans.infinitybuttons.item.ModItemGroup;
import net.larsmans.infinitybuttons.item.ModItems;
import net.larsmans.infinitybuttons.sounds.ModSounds;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vazkii.quark.base.handler.QuarkSounds;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InfinityButtons.MOD_ID);

    /*
    -------------
    Large Buttons
    -------------
    */

    public static final RegistryObject<Block> OAK_LARGE_BUTTON = registerBlock("oak_large_button",
            () -> new WoodenLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BIRCH_LARGE_BUTTON = registerBlock("birch_large_button",
            () -> new WoodenLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> SPRUCE_LARGE_BUTTON = registerBlock("spruce_large_button",
            () -> new WoodenLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ACACIA_LARGE_BUTTON = registerBlock("acacia_large_button",
            () -> new WoodenLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> DARK_OAK_LARGE_BUTTON = registerBlock("dark_oak_large_button",
            () -> new WoodenLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> JUNGLE_LARGE_BUTTON = registerBlock("jungle_large_button",
            () -> new WoodenLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WARPED_LARGE_BUTTON = registerBlock("warped_large_button",
            () -> new WoodenLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CRIMSON_LARGE_BUTTON = registerBlock("crimson_large_button",
            () -> new WoodenLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> STONE_LARGE_BUTTON = registerBlock("stone_large_button",
            () -> new StoneLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement()));

    public static final RegistryObject<Block> POLISHED_BLACKSTONE_LARGE_BUTTON = registerBlock("polished_blackstone_large_button",
            () -> new StoneLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement()));

    public static final RegistryObject<Block> COPPER_LARGE_BUTTON = registerBlock("copper_large_button",
            () -> new CopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> EXPOSED_COPPER_LARGE_BUTTON = registerBlock("exposed_copper_large_button",
            () -> new CopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> WEATHERED_COPPER_LARGE_BUTTON = registerBlock("weathered_copper_large_button",
            () -> new CopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> OXIDIZED_COPPER_LARGE_BUTTON = registerBlock("oxidized_copper_large_button",
            () -> new CopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_COPPER_LARGE_BUTTON = registerBlock("sticky_copper_large_button",
            () -> new StickyCopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_EXPOSED_COPPER_LARGE_BUTTON = registerBlock("sticky_exposed_copper_large_button",
            () -> new StickyCopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_WEATHERED_COPPER_LARGE_BUTTON = registerBlock("sticky_weathered_copper_large_button",
            () -> new StickyCopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_OXIDIZED_COPPER_LARGE_BUTTON = registerBlock("sticky_oxidized_copper_large_button",
            () -> new StickyCopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> EMERALD_LARGE_BUTTON = registerBlock("emerald_large_button",
            () -> new EmeraldLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> IRON_LARGE_BUTTON = registerBlock("iron_large_button",
            () -> new ArrowLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> GOLD_LARGE_BUTTON = registerBlock("gold_large_button",
            () -> new ArrowLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> WILLOW_LARGE_BUTTON = registerCompatBlock("environmental", "willow_large_button",
            () -> new WoodenLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CHERRY_LARGE_BUTTON = registerCompatBlock("environmental", "cherry_large_button",
            () -> new WoodenLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WISTERIA_LARGE_BUTTON = registerCompatBlock("environmental", "wisteria_large_button",
            () -> new WoodenLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> POISE_LARGE_BUTTON = registerCompatBlock("endergetic", "poise_large_button",
            () -> new WoodenLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    /*
    -------------
    Buttons
    -------------
    */

    public static final RegistryObject<Block> COPPER_BUTTON = registerBlock("copper_button",
            () -> new CopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> EXPOSED_COPPER_BUTTON = registerBlock("exposed_copper_button",
            () -> new CopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> WEATHERED_COPPER_BUTTON = registerBlock("weathered_copper_button",
            () -> new CopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> OXIDIZED_COPPER_BUTTON = registerBlock("oxidized_copper_button",
            () -> new CopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_COPPER_BUTTON = registerBlock("sticky_copper_button",
            () -> new StickyCopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_EXPOSED_COPPER_BUTTON = registerBlock("sticky_exposed_copper_button",
            () -> new StickyCopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_WEATHERED_COPPER_BUTTON = registerBlock("sticky_weathered_copper_button",
            () -> new StickyCopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_OXIDIZED_COPPER_BUTTON = registerBlock("sticky_oxidized_copper_button",
            () -> new StickyCopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(ModSounds.COPPER)));

    public static final RegistryObject<Block> EMERALD_BUTTON = registerBlock("emerald_button",
            () -> new EmeraldButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> IRON_BUTTON = registerBlock("iron_button",
            () -> new ArrowButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> GOLD_BUTTON = registerBlock("gold_button",
            () -> new ArrowButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    /*
    -----------------
    Emergency Buttons
    -----------------
    */

    public static final RegistryObject<Block> RED_EMERGENCY_BUTTON = registerBlock("red_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> ORANGE_EMERGENCY_BUTTON = registerBlock("orange_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> YELLOW_EMERGENCY_BUTTON = registerBlock("yellow_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> LIME_EMERGENCY_BUTTON = registerBlock("lime_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> GREEN_EMERGENCY_BUTTON = registerBlock("green_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> CYAN_EMERGENCY_BUTTON = registerBlock("cyan_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> LIGHT_BLUE_EMERGENCY_BUTTON = registerBlock("light_blue_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> BLUE_EMERGENCY_BUTTON = registerBlock("blue_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> PURPLE_EMERGENCY_BUTTON = registerBlock("purple_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> MAGENTA_EMERGENCY_BUTTON = registerBlock("magenta_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> PINK_EMERGENCY_BUTTON = registerBlock("pink_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> BROWN_EMERGENCY_BUTTON = registerBlock("brown_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> WHITE_EMERGENCY_BUTTON = registerBlock("white_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> LIGHT_GRAY_EMERGENCY_BUTTON = registerBlock("light_gray_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> GRAY_EMERGENCY_BUTTON = registerBlock("gray_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> BLACK_EMERGENCY_BUTTON = registerBlock("black_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    /*
    --------------
    Secret Buttons
    --------------
    */

    public static final RegistryObject<Block> BOOKSHELF_SECRET_BUTTON = registerBlock("bookshelf_secret_button",
            () -> new BookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> STONE_BRICK_SECRET_BUTTON = registerBlock("stone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> MOSSY_STONE_BRICK_SECRET_BUTTON = registerBlock("mossy_stone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CRACKED_STONE_BRICK_SECRET_BUTTON = registerBlock("cracked_stone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_STONE_BRICK_SECRET_BUTTON = registerBlock("chiseled_stone_brick_secret_button",
            () -> new ChiseledStoneBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> MUD_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "mud_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 2.5f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_MUD_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_mud_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 2.5f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> DEEPSLATE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "deepslate_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.5f, 6.0f).notSolid().sound(QuarkSounds.DEEPSLATE_BRICKS_TYPE).setRequiresTool()));

    public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "cracked_deepslate_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.5f, 6.0f).notSolid().sound(QuarkSounds.DEEPSLATE_BRICKS_TYPE).setRequiresTool()));

    public static final RegistryObject<Block> DEEPSLATE_TILE_SECRET_BUTTON = registerCompatBlock("quark", "deepslate_tile_secret_button",
            () -> new DeepslateTileSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.5f, 6.0f).notSolid().sound(QuarkSounds.DEEPSLATE_TILES_TYPE).setRequiresTool()));

    public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILE_SECRET_BUTTON = registerCompatBlock("quark", "cracked_deepslate_tile_secret_button",
            () -> new DeepslateTileSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.5f, 6.0f).notSolid().sound(QuarkSounds.DEEPSLATE_TILES_TYPE).setRequiresTool()));

    public static final RegistryObject<Block> END_STONE_BRICK_SECRET_BUTTON = registerBlock("end_stone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0f, 9.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> QUARTZ_BRICK_SECRET_BUTTON = registerBlock("quartz_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.QUARTZ)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.8f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_SECRET_BUTTON = registerBlock("polished_blackstone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICK_SECRET_BUTTON = registerBlock("cracked_polished_blackstone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_SECRET_BUTTON = registerBlock("chiseled_polished_blackstone_secret_button",
            () -> new ChiseledStoneBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> BRICK_SECRET_BUTTON = registerBlock("brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> NETHER_BRICK_SECRET_BUTTON = registerBlock("nether_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.NETHER_BRICK).setRequiresTool()));

    public static final RegistryObject<Block> CRACKED_NETHER_BRICK_SECRET_BUTTON = registerBlock("cracked_nether_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.NETHER_BRICK).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_NETHER_BRICK_SECRET_BUTTON = registerBlock("chiseled_nether_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.NETHER_BRICK).setRequiresTool()));

    public static final RegistryObject<Block> RED_NETHER_BRICK_SECRET_BUTTON = registerBlock("red_nether_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.NETHER_BRICK).setRequiresTool()));

    public static final RegistryObject<Block> DARK_PRISMARINE_SECRET_BUTTON = registerBlock("dark_prismarine_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> OAK_PLANK_SECRET_BUTTON = registerBlock("oak_plank_secret_button",
            () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BIRCH_PLANK_SECRET_BUTTON = registerBlock("birch_plank_secret_button",
            () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> SPRUCE_PLANK_SECRET_BUTTON = registerBlock("spruce_plank_secret_button",
            () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ACACIA_PLANK_SECRET_BUTTON = registerBlock("acacia_plank_secret_button",
            () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.ADOBE)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> DARK_OAK_PLANK_SECRET_BUTTON = registerBlock("dark_oak_plank_secret_button",
            () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> JUNGLE_PLANK_SECRET_BUTTON = registerBlock("jungle_plank_secret_button",
            () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIRT)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CRIMSON_PLANK_SECRET_BUTTON = registerBlock("crimson_plank_secret_button",
            () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.NETHER_WOOD, MaterialColor.CRIMSON_STEM)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WARPED_PLANK_SECRET_BUTTON = registerBlock("warped_plank_secret_button",
            () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.NETHER_WOOD, MaterialColor.WARPED_STEM)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD).setRequiresTool()));

    public static final RegistryObject<Block> ICE_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "ice_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ICE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.0f, 2.0f).notSolid().sound(SoundType.GLASS).setRequiresTool().slipperiness(0.99F)));

    public static final RegistryObject<Block> CHISELED_ICE_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_ice_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ICE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.0f, 2.0f).notSolid().sound(SoundType.GLASS).setRequiresTool().slipperiness(0.99F)));

    public static final RegistryObject<Block> TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ADOBE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ADOBE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "white_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_WHITE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_white_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "orange_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_ORANGE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_orange_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "magenta_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.MAGENTA_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_MAGENTA_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_magenta_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.MAGENTA_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "light_blue_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_LIGHT_BLUE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_light_blue_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "yellow_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_YELLOW_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_yellow_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> LIME_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "lime_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIME_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_LIME_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_lime_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIME_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> PINK_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "pink_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_PINK_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_pink_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "gray_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_GRAY_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_gray_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "light_gray_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_LIGHT_GRAY_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_light_gray_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "cyan_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.CYAN_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_CYAN_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_cyan_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.CYAN_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "purple_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_PURPLE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_purple_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "blue_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_BLUE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_blue_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "brown_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_BROWN_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_brown_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "green_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GREEN_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_GREEN_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_green_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GREEN_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> RED_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "red_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_RED_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_red_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "black_terracotta_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_BLACK_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_black_terracotta_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> WILLOW_PLANK_SECRET_BUTTON = registerCompatBlock("environmental", "willow_plank_secret_button",
            () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CHERRY_PLANK_SECRET_BUTTON = registerCompatBlock("environmental", "cherry_plank_secret_button",
            () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WISTERIA_PLANK_SECRET_BUTTON = registerCompatBlock("environmental", "wisteria_plank_secret_button",
            () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> POISE_PLANK_SECRET_BUTTON = registerCompatBlock("endergetic", "poise_plank_secret_button",
            () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CHISELED_END_STONE_BRICK_SECRET_BUTTON = registerCompatBlock("endergetic", "chiseled_end_stone_brick_secret_button",
            () -> new ChiseledEndStoneBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0f, 9.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_EUMUS_BRICK_SECRET_BUTTON = registerCompatBlock("endergetic", "chiseled_eumus_brick_secret_button",
            () -> new ChiseledEumusBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 30.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CRACKED_END_STONE_BRICK_SECRET_BUTTON = registerCompatBlock("endergetic", "cracked_end_stone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0f, 9.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CRACKED_EUMUS_BRICK_SECRET_BUTTON = registerCompatBlock("endergetic", "cracked_eumus_brick_secret_button",
            () -> new EumusBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 30.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> EUMUS_BRICK_SECRET_BUTTON = registerCompatBlock("endergetic", "eumus_brick_secret_button",
            () -> new EumusBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 30.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    /*
    --------------
    Torches
    --------------
    */

    public static final RegistryObject<Block> TORCH_BUTTON = registerBlock("torch_button",
            () -> new TorchButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD), ParticleTypes.FLAME));

    public static final RegistryObject<Block> TORCH_LEVER = registerBlock("torch_lever",
            () -> new TorchLever(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD), ParticleTypes.FLAME));

    public static final RegistryObject<Block> SOUL_TORCH_BUTTON = registerBlock("soul_torch_button",
            () -> new TorchButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 10;
            }).sound(SoundType.WOOD), ParticleTypes.SOUL_FIRE_FLAME));

    public static final RegistryObject<Block> SOUL_TORCH_LEVER = registerBlock("soul_torch_lever",
            () -> new TorchLever(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 10;
            }).sound(SoundType.WOOD), ParticleTypes.SOUL_FIRE_FLAME));

    public static final RegistryObject<Block> REDSTONE_TORCH_BUTTON = registerTorchBlock("redstone_torch_button",
            () -> new RedstoneTorchButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 7;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> REDSTONE_WALL_TORCH_BUTTON = registerTorchBlock("redstone_wall_torch_button",
            () -> new RedstoneWallTorchButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 7;
            }).sound(SoundType.WOOD).lootFrom(REDSTONE_TORCH_BUTTON)));

    public static final RegistryObject<Block> REDSTONE_TORCH_LEVER = registerTorchBlock("redstone_torch_lever",
            () -> new RedstoneTorchLever(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 7;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> REDSTONE_WALL_TORCH_LEVER = registerTorchBlock("redstone_wall_torch_lever",
            () -> new RedstoneWallTorchLever(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 7;
            }).sound(SoundType.WOOD).lootFrom(REDSTONE_TORCH_LEVER)));

    public static final RegistryObject<Block> ENDER_TORCH_BUTTON = registerCompatBlock("endergetic", "ender_torch_button",
            () -> new EnderTorchButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ENDER_TORCH_LEVER = registerCompatBlock("endergetic", "ender_torch_lever",
            () -> new EnderTorchLever(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    /*
    --------------
    Other Stuff
    --------------
    */

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, ModItemGroup.INFINITYBUTTONS);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<T> registerCompatBlock(String modid, String name, Supplier<T> block) {
        RegistryObject<T> toReturn = null;
        if (ModList.get().isLoaded(modid)) {
            toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn, ModItemGroup.INFINITYBUTTONSCOMPAT);
        }
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, ItemGroup group) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(group)));
    }

    private static <T extends Block>RegistryObject<T> registerTorchBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
