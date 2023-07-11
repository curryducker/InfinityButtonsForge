package net.larsmans.infinitybuttons.block;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.larsmans.infinitybuttons.block.custom.Doorbell;
import net.larsmans.infinitybuttons.block.custom.DoorbellButton;
import net.larsmans.infinitybuttons.block.custom.LampButton;
import net.larsmans.infinitybuttons.block.custom.LanternButton;
import net.larsmans.infinitybuttons.block.custom.button.*;
import net.larsmans.infinitybuttons.block.custom.consolebutton.ConsoleButton;
import net.larsmans.infinitybuttons.block.custom.consolebutton.LargeConsoleButton;
import net.larsmans.infinitybuttons.block.custom.consolebutton.SmallConsoleButton;
import net.larsmans.infinitybuttons.block.custom.emergencybutton.EmergencyButton;
import net.larsmans.infinitybuttons.block.custom.emergencybutton.SafeEmergencyButton;
import net.larsmans.infinitybuttons.block.custom.letterbutton.LetterButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.*;
import net.larsmans.infinitybuttons.block.custom.torch.*;
import net.larsmans.infinitybuttons.item.InfinityButtonsItemGroup;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.larsmans.infinitybuttons.item.custom.SafeEmergencyButtonItem;
import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class InfinityButtonsBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InfinityButtons.MOD_ID);

    /**
     * Buttons
     */

    public static final RegistryObject<Block> GRANITE_BUTTON = registerStoneButton("granite");
    public static final RegistryObject<Block> DIORITE_BUTTON = registerStoneButton("diorite");
    public static final RegistryObject<Block> ANDESITE_BUTTON = registerStoneButton("andesite");

    public static final RegistryObject<Block> COPPER_BUTTON = registerCopperButton("copper");
    public static final RegistryObject<Block> EXPOSED_COPPER_BUTTON = registerCopperButton("exposed_copper");
    public static final RegistryObject<Block> WEATHERED_COPPER_BUTTON = registerCopperButton("weathered_copper");
    public static final RegistryObject<Block> OXIDIZED_COPPER_BUTTON = registerCopperButton("oxidized_copper");

    public static final RegistryObject<Block> STICKY_COPPER_BUTTON = registerStickyCopperButton("copper");
    public static final RegistryObject<Block> STICKY_EXPOSED_COPPER_BUTTON = registerStickyCopperButton("exposed_copper");
    public static final RegistryObject<Block> STICKY_WEATHERED_COPPER_BUTTON = registerStickyCopperButton("weathered_copper");
    public static final RegistryObject<Block> STICKY_OXIDIZED_COPPER_BUTTON = registerStickyCopperButton("oxidized_copper");

    public static final RegistryObject<Block> IRON_BUTTON = registerArrowButton("iron");
    public static final RegistryObject<Block> GOLD_BUTTON = registerArrowButton("gold");

    public static final RegistryObject<Block> EMERALD_BUTTON = registerBlock("emerald_button",
            () -> new EmeraldButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL), false));

    public static final RegistryObject<Block> DIAMOND_BUTTON = registerBlock("diamond_button",
            () -> new DiamondButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL), false));

    public static final RegistryObject<Block> PRISMARINE_BUTTON = registerPrismarineButton("prismarine");
    public static final RegistryObject<Block> PRISMARINE_BRICK_BUTTON = registerPrismarineButton("prismarine_brick");
    public static final RegistryObject<Block> DARK_PRISMARINE_BUTTON = registerPrismarineButton("dark_prismarine");

    public static final RegistryObject<Block> SAND_BUTTON = registerSandButton("sand", false);
    public static final RegistryObject<Block> RED_SAND_BUTTON = registerSandButton("red_sand", false);
    public static final RegistryObject<Block> GRAVEL_BUTTON = registerSandButton("gravel", true);

    public static final RegistryObject<Block> WHITE_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("white");
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("light_gray");
    public static final RegistryObject<Block> GRAY_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("gray");
    public static final RegistryObject<Block> BLACK_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("black");
    public static final RegistryObject<Block> BROWN_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("brown");
    public static final RegistryObject<Block> RED_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("red");
    public static final RegistryObject<Block> ORANGE_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("orange");
    public static final RegistryObject<Block> YELLOW_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("yellow");
    public static final RegistryObject<Block> LIME_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("lime");
    public static final RegistryObject<Block> GREEN_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("green");
    public static final RegistryObject<Block> CYAN_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("cyan");
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("light_blue");
    public static final RegistryObject<Block> BLUE_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("blue");
    public static final RegistryObject<Block> PURPLE_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("purple");
    public static final RegistryObject<Block> MAGENTA_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("magenta");
    public static final RegistryObject<Block> PINK_CONCRETE_POWDER_BUTTON = registerConcretePowderButton("pink");

    /**
     * Large Buttons
     */

    public static final RegistryObject<Block> OAK_LARGE_BUTTON = registerWoodenLargeButton("oak");
    public static final RegistryObject<Block> SPRUCE_LARGE_BUTTON = registerWoodenLargeButton("spruce");
    public static final RegistryObject<Block> BIRCH_LARGE_BUTTON = registerWoodenLargeButton("birch");
    public static final RegistryObject<Block> JUNGLE_LARGE_BUTTON = registerWoodenLargeButton("jungle");
    public static final RegistryObject<Block> ACACIA_LARGE_BUTTON = registerWoodenLargeButton("acacia");
    public static final RegistryObject<Block> DARK_OAK_LARGE_BUTTON = registerWoodenLargeButton("dark_oak");
    public static final RegistryObject<Block> CRIMSON_LARGE_BUTTON = registerWoodenLargeButton("crimson");
    public static final RegistryObject<Block> WARPED_LARGE_BUTTON = registerWoodenLargeButton("warped");

    public static final RegistryObject<Block> STONE_LARGE_BUTTON = registerStoneLargeButton("stone");
    public static final RegistryObject<Block> GRANITE_LARGE_BUTTON = registerStoneLargeButton("granite");
    public static final RegistryObject<Block> DIORITE_LARGE_BUTTON = registerStoneLargeButton("diorite");
    public static final RegistryObject<Block> ANDESITE_LARGE_BUTTON = registerStoneLargeButton("andesite");
    public static final RegistryObject<Block> POLISHED_BLACKSTONE_LARGE_BUTTON = registerStoneLargeButton("polished_blackstone");

    public static final RegistryObject<Block> COPPER_LARGE_BUTTON = registerCopperLargeButton("copper");
    public static final RegistryObject<Block> EXPOSED_COPPER_LARGE_BUTTON = registerCopperLargeButton("exposed_copper");
    public static final RegistryObject<Block> WEATHERED_COPPER_LARGE_BUTTON = registerCopperLargeButton("weathered_copper");
    public static final RegistryObject<Block> OXIDIZED_COPPER_LARGE_BUTTON = registerCopperLargeButton("oxidized_copper");

    public static final RegistryObject<Block> STICKY_COPPER_LARGE_BUTTON = registerStickyCopperLargeButton("copper");
    public static final RegistryObject<Block> STICKY_EXPOSED_COPPER_LARGE_BUTTON = registerStickyCopperLargeButton("exposed_copper");
    public static final RegistryObject<Block> STICKY_WEATHERED_COPPER_LARGE_BUTTON = registerStickyCopperLargeButton("weathered_copper");
    public static final RegistryObject<Block> STICKY_OXIDIZED_COPPER_LARGE_BUTTON = registerStickyCopperLargeButton("oxidized_copper");

    public static final RegistryObject<Block> IRON_LARGE_BUTTON = registerArrowLargeButton("iron");
    public static final RegistryObject<Block> GOLD_LARGE_BUTTON = registerArrowLargeButton("gold");

    public static final RegistryObject<Block> EMERALD_LARGE_BUTTON = registerBlock("emerald_large_button",
            () -> new EmeraldButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL), true));

    public static final RegistryObject<Block> DIAMOND_LARGE_BUTTON = registerBlock("diamond_large_button",
            () -> new DiamondButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL), true));

    public static final RegistryObject<Block> PRISMARINE_LARGE_BUTTON = registerPrismarineLargeButton("prismarine");
    public static final RegistryObject<Block> PRISMARINE_BRICK_LARGE_BUTTON = registerPrismarineLargeButton("prismarine_brick");
    public static final RegistryObject<Block> DARK_PRISMARINE_LARGE_BUTTON = registerPrismarineLargeButton("dark_prismarine");

    public static final RegistryObject<Block> SAND_LARGE_BUTTON = registerSandLargeButton("sand", false);
    public static final RegistryObject<Block> RED_SAND_LARGE_BUTTON = registerSandLargeButton("red_sand", false);
    public static final RegistryObject<Block> GRAVEL_LARGE_BUTTON = registerSandLargeButton("gravel", true);

    public static final RegistryObject<Block> WHITE_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("white");
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("light_gray");
    public static final RegistryObject<Block> GRAY_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("gray");
    public static final RegistryObject<Block> BLACK_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("black");
    public static final RegistryObject<Block> BROWN_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("brown");
    public static final RegistryObject<Block> RED_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("red");
    public static final RegistryObject<Block> ORANGE_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("orange");
    public static final RegistryObject<Block> YELLOW_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("yellow");
    public static final RegistryObject<Block> LIME_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("lime");
    public static final RegistryObject<Block> GREEN_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("green");
    public static final RegistryObject<Block> CYAN_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("cyan");
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("light_blue");
    public static final RegistryObject<Block> BLUE_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("blue");
    public static final RegistryObject<Block> PURPLE_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("purple");
    public static final RegistryObject<Block> MAGENTA_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("magenta");
    public static final RegistryObject<Block> PINK_CONCRETE_POWDER_LARGE_BUTTON = registerConcretePowderLargeButton("pink");

    /**
     * Emergency Buttons
     */

    public static final RegistryObject<Block> WHITE_EMERGENCY_BUTTON = registerEmergencyButton("white");
    public static final RegistryObject<Block> LIGHT_GRAY_EMERGENCY_BUTTON = registerEmergencyButton("light_gray");
    public static final RegistryObject<Block> GRAY_EMERGENCY_BUTTON = registerEmergencyButton("gray");
    public static final RegistryObject<Block> BLACK_EMERGENCY_BUTTON = registerEmergencyButton("black");
    public static final RegistryObject<Block> BROWN_EMERGENCY_BUTTON = registerEmergencyButton("brown");
    public static final RegistryObject<Block> RED_EMERGENCY_BUTTON = registerEmergencyButton("red");
    public static final RegistryObject<Block> ORANGE_EMERGENCY_BUTTON = registerEmergencyButton("orange");
    public static final RegistryObject<Block> YELLOW_EMERGENCY_BUTTON = registerEmergencyButton("yellow");
    public static final RegistryObject<Block> LIME_EMERGENCY_BUTTON = registerEmergencyButton("lime");
    public static final RegistryObject<Block> GREEN_EMERGENCY_BUTTON = registerEmergencyButton("green");
    public static final RegistryObject<Block> CYAN_EMERGENCY_BUTTON = registerEmergencyButton("cyan");
    public static final RegistryObject<Block> LIGHT_BLUE_EMERGENCY_BUTTON = registerEmergencyButton("light_blue");
    public static final RegistryObject<Block> BLUE_EMERGENCY_BUTTON = registerEmergencyButton("blue");
    public static final RegistryObject<Block> PURPLE_EMERGENCY_BUTTON = registerEmergencyButton("purple");
    public static final RegistryObject<Block> MAGENTA_EMERGENCY_BUTTON = registerEmergencyButton("magenta");
    public static final RegistryObject<Block> PINK_EMERGENCY_BUTTON = registerEmergencyButton("pink");
    public static final RegistryObject<Block> FANCY_EMERGENCY_BUTTON = registerEmergencyButton("fancy");

    public static final RegistryObject<Block> WHITE_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("white");
    public static final RegistryObject<Block> LIGHT_GRAY_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("light_gray");
    public static final RegistryObject<Block> GRAY_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("gray");
    public static final RegistryObject<Block> BLACK_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("black");
    public static final RegistryObject<Block> BROWN_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("brown");
    public static final RegistryObject<Block> RED_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("red");
    public static final RegistryObject<Block> ORANGE_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("orange");
    public static final RegistryObject<Block> YELLOW_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("yellow");
    public static final RegistryObject<Block> LIME_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("lime");
    public static final RegistryObject<Block> GREEN_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("green");
    public static final RegistryObject<Block> CYAN_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("cyan");
    public static final RegistryObject<Block> LIGHT_BLUE_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("light_blue");
    public static final RegistryObject<Block> BLUE_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("blue");
    public static final RegistryObject<Block> PURPLE_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("purple");
    public static final RegistryObject<Block> MAGENTA_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("magenta");
    public static final RegistryObject<Block> PINK_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("pink");
    public static final RegistryObject<Block> FANCY_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButton("fancy");

    /**
     * Secret Buttons
     */

    public static final RegistryObject<Block> BOOKSHELF_SECRET_BUTTON = registerBlock("bookshelf_secret_button",
            () -> new BookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD), byName("bookshelf")));

    public static final RegistryObject<Block> BRICK_SECRET_BUTTON = registerBlock("brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("bricks")));

    public static final RegistryObject<Block> STONE_BRICK_SECRET_BUTTON = registerBlock("stone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("stone_bricks")));

    public static final RegistryObject<Block> MOSSY_STONE_BRICK_SECRET_BUTTON = registerBlock("mossy_stone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("mossy_stone_bricks")));

    public static final RegistryObject<Block> CRACKED_STONE_BRICK_SECRET_BUTTON = registerBlock("cracked_stone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("cracked_stone_bricks")));

    public static final RegistryObject<Block> CHISELED_STONE_BRICK_SECRET_BUTTON = registerBlock("chiseled_stone_brick_secret_button",
            () -> new ChiseledStoneBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("chiseled_stone_bricks")));

    public static final RegistryObject<Block> OAK_PLANK_SECRET_BUTTON = registerPlankSecretButton("oak", MaterialColor.WOOD);
    public static final RegistryObject<Block> SPRUCE_PLANK_SECRET_BUTTON = registerPlankSecretButton("spruce", MaterialColor.OBSIDIAN);
    public static final RegistryObject<Block> BIRCH_PLANK_SECRET_BUTTON = registerPlankSecretButton("birch", MaterialColor.SAND);
    public static final RegistryObject<Block> JUNGLE_PLANK_SECRET_BUTTON = registerPlankSecretButton("jungle", MaterialColor.DIRT);
    public static final RegistryObject<Block> ACACIA_PLANK_SECRET_BUTTON = registerPlankSecretButton("acacia", MaterialColor.ADOBE);
    public static final RegistryObject<Block> DARK_OAK_PLANK_SECRET_BUTTON = registerPlankSecretButton("dark_oak", MaterialColor.BROWN);
    public static final RegistryObject<Block> CRIMSON_PLANK_SECRET_BUTTON = registerNetherPlankSecretButton("crimson", MaterialColor.CRIMSON_STEM);
    public static final RegistryObject<Block> WARPED_PLANK_SECRET_BUTTON = registerNetherPlankSecretButton("warped", MaterialColor.WARPED_STEM);

    public static final RegistryObject<Block> END_STONE_BRICK_SECRET_BUTTON = registerBlock("end_stone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0f, 9.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("end_stone_bricks")));

    public static final RegistryObject<Block> PURPUR_BLOCK_SECRET_BUTTON = registerBlock("purpur_block_secret_button",
            () -> new TileSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.MAGENTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("purpur_block")));

    public static final RegistryObject<Block> QUARTZ_BRICK_SECRET_BUTTON = registerBlock("quartz_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.QUARTZ)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.8f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("quartz_bricks")));

    public static final RegistryObject<Block> DARK_PRISMARINE_SECRET_BUTTON = registerBlock("dark_prismarine_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIAMOND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("dark_prismarine")));

    public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICK_SECRET_BUTTON = registerBlock("polished_blackstone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("polished_blackstone_bricks")));

    public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICK_SECRET_BUTTON = registerBlock("cracked_polished_blackstone_brick_secret_button",
            () -> new BigBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("cracked_polished_blackstone_bricks")));

    public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_SECRET_BUTTON = registerBlock("chiseled_polished_blackstone_secret_button",
            () -> new ChiseledStoneBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("chiseled_polished_blackstone")));

    public static final RegistryObject<Block> NETHER_BRICK_SECRET_BUTTON = registerBlock("nether_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.NETHER_BRICK).setRequiresTool(), byName("nether_bricks")));

    public static final RegistryObject<Block> CRACKED_NETHER_BRICK_SECRET_BUTTON = registerBlock("cracked_nether_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.NETHER_BRICK).setRequiresTool(), byName("cracked_nether_bricks")));

    public static final RegistryObject<Block> CHISELED_NETHER_BRICK_SECRET_BUTTON = registerBlock("chiseled_nether_brick_secret_button",
            () -> new ChiseledNetherBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.NETHER_BRICK).setRequiresTool(), byName("chiseled_nether_bricks")));

    public static final RegistryObject<Block> RED_NETHER_BRICK_SECRET_BUTTON = registerBlock("red_nether_brick_secret_button",
            () -> new FullBlockBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.NETHER_BRICK).setRequiresTool(), byName("red_nether_bricks")));


    /**
     * Misc
     */

    public static final RegistryObject<Block> DOORBELL = registerBlock("doorbell",
            () -> new Doorbell(doorbellProperties()));

    public static final RegistryObject<Block> DOORBELL_BUTTON = registerBlock("doorbell_button",
            () -> new DoorbellButton(doorbellProperties()));

    public static final RegistryObject<Block> LAMP_BUTTON = registerBlock("lamp_button",
            () -> new LampButton(lampProperties(), false));

    public static final RegistryObject<Block> LAMP_LEVER = registerBlock("lamp_lever",
            () -> new LampButton(lampProperties(), true));

    public static final RegistryObject<Block> LETTER_BUTTON = registerBlock("letter_button",
            () -> new LetterButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).notSolid().doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> LANTERN_BUTTON = registerBlock("lantern_button",
            () -> new LanternButton(lanternProperties(15), false));

    public static final RegistryObject<Block> LANTERN_LEVER = registerBlock("lantern_lever",
            () -> new LanternButton(lanternProperties(15), true));

    public static final RegistryObject<Block> SOUL_LANTERN_BUTTON = registerBlock("soul_lantern_button",
            () -> new LanternButton(lanternProperties(10), false));

    public static final RegistryObject<Block> SOUL_LANTERN_LEVER = registerBlock("soul_lantern_lever",
            () -> new LanternButton(lanternProperties(10), true));

    /**
     * Console Buttons
     */

    public static final RegistryObject<Block> SMALL_CONSOLE_BUTTON = registerBlock("small_console_button",
            () -> new SmallConsoleButton(consoleButtonProperties(), false));
    public static final RegistryObject<Block> SMALL_CONSOLE_LEVER = registerBlock("small_console_lever",
            () -> new SmallConsoleButton(consoleButtonProperties(), true));
    public static final RegistryObject<Block> CONSOLE_BUTTON = registerBlock("console_button",
            () -> new ConsoleButton(consoleButtonProperties(), false));
    public static final RegistryObject<Block> CONSOLE_LEVER = registerBlock("console_lever",
            () -> new ConsoleButton(consoleButtonProperties(), true));
    public static final RegistryObject<Block> LARGE_CONSOLE_BUTTON = registerBlock("large_console_button",
            () -> new LargeConsoleButton(consoleButtonProperties(), false));
    public static final RegistryObject<Block> LARGE_CONSOLE_LEVER = registerBlock("large_console_lever",
            () -> new LargeConsoleButton(consoleButtonProperties(), true));
    public static final RegistryObject<Block> BIG_CONSOLE_BUTTON = registerBlock("big_console_button",
            () -> new LargeConsoleButton(consoleButtonProperties(), false));
    public static final RegistryObject<Block> BIG_CONSOLE_LEVER = registerBlock("big_console_lever",
            () -> new LargeConsoleButton(consoleButtonProperties(), true));

    /**
     * Torches
     */

    public static final RegistryObject<Block> TORCH_BUTTON = registerTorchBlock("torch_button",
            () -> new TorchButton(torchProperties(14), ParticleTypes.FLAME, byName("torch")));

    public static final RegistryObject<Block> WALL_TORCH_BUTTON = registerTorchBlock("wall_torch_button",
            () -> new WallTorchButton(torchProperties(14).lootFrom(TORCH_BUTTON), ParticleTypes.FLAME, byName("torch")));

    public static final RegistryObject<Block> TORCH_LEVER = registerTorchBlock("torch_lever",
            () -> new TorchLever(torchProperties(14), ParticleTypes.FLAME, byName("torch")));

    public static final RegistryObject<Block> WALL_TORCH_LEVER = registerTorchBlock("wall_torch_lever",
            () -> new WallTorchLever(torchProperties(14).lootFrom(TORCH_LEVER), ParticleTypes.FLAME, byName("torch")));

    public static final RegistryObject<Block> SOUL_TORCH_BUTTON = registerTorchBlock("soul_torch_button",
            () -> new TorchButton(torchProperties(10), ParticleTypes.SOUL_FIRE_FLAME, byName("soul_torch")));

    public static final RegistryObject<Block> SOUL_WALL_TORCH_BUTTON = registerTorchBlock("soul_wall_torch_button",
            () -> new WallTorchButton(torchProperties(10).lootFrom(SOUL_TORCH_BUTTON), ParticleTypes.SOUL_FIRE_FLAME, byName("soul_torch")));

    public static final RegistryObject<Block> SOUL_TORCH_LEVER = registerTorchBlock("soul_torch_lever",
            () -> new TorchLever(torchProperties(10), ParticleTypes.SOUL_FIRE_FLAME, byName("soul_torch")));

    public static final RegistryObject<Block> SOUL_WALL_TORCH_LEVER = registerTorchBlock("soul_wall_torch_lever",
            () -> new WallTorchLever(torchProperties(10).lootFrom(SOUL_TORCH_LEVER), ParticleTypes.SOUL_FIRE_FLAME, byName("soul_torch")));

    public static final RegistryObject<Block> REDSTONE_TORCH_BUTTON = registerTorchBlock("redstone_torch_button",
            () -> new RedstoneTorchButton(torchProperties(7), byName("redstone_torch")));

    public static final RegistryObject<Block> REDSTONE_WALL_TORCH_BUTTON = registerTorchBlock("redstone_wall_torch_button",
            () -> new RedstoneWallTorchButton(torchProperties(7).lootFrom(REDSTONE_TORCH_BUTTON), byName("redstone_torch")));

    public static final RegistryObject<Block> REDSTONE_TORCH_LEVER = registerTorchBlock("redstone_torch_lever",
            () -> new RedstoneTorchLever(torchProperties(7), byName("redstone_torch")));

    public static final RegistryObject<Block> REDSTONE_WALL_TORCH_LEVER = registerTorchBlock("redstone_wall_torch_lever",
            () -> new RedstoneWallTorchLever(torchProperties(7).lootFrom(REDSTONE_TORCH_LEVER), byName("redstone_torch")));

    /**
     * Methods
     */

    private static Block byName(String block) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft", block));
    }

    private static AbstractBlock.Properties doorbellProperties() {
        return AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD);
    }

    private static AbstractBlock.Properties lampProperties() {
        return AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.3f).sound(SoundType.GLASS).setLightLevel(InfinityButtonsBlocks::getPressLight);
    }

    private static AbstractBlock.Properties lanternProperties(int light) {
        return AbstractBlock.Properties.create(Material.IRON)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.5f).notSolid().sound(SoundType.LANTERN).setRequiresTool().setLightLevel((state) -> light);
    }

    private static int getPressLight(BlockState state) {
        return state.get(LampButton.PRESSED) ? 15 : 0;
    }

    public static AbstractBlock.Properties consoleButtonProperties() {
        return AbstractBlock.Properties.create(Material.IRON)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).sound(SoundType.METAL);
    }

    private static AbstractBlock.Properties torchProperties(int light) {
        return AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> light).sound(SoundType.WOOD);
    }

    private static RegistryObject<Block> registerStoneButton(String type) {
        return registerBlock(type + "_button", () -> new StoneButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE), false));
    }

    private static RegistryObject<Block> registerCopperButton(String type) {
        return registerBlock(type + "_button", () -> new CopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER), false));
    }

    private static RegistryObject<Block> registerStickyCopperButton(String type) {
        return registerBlock("sticky_" + type + "_button", () -> new StickyCopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER), false));
    }

    private static RegistryObject<Block> registerArrowButton(String type) {
        return registerBlock(type + "_button", () -> new ArrowButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL), false));
    }

    private static RegistryObject<Block> registerPrismarineButton(String type) {
        return registerBlock(type + "_button", () -> new PrismarineButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE), false));
    }

    private static RegistryObject<Block> registerSandButton(String type, boolean gravel) {
        return registerBlock(type + "_button", () -> new FallingButton(gravel, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(gravel ? SoundType.GROUND : SoundType.SAND), false));
    }

    private static RegistryObject<Block> registerConcretePowderButton(String color) {
        return registerSandButton(color + "_concrete_powder", false);
    }

    private static RegistryObject<Block> registerWoodenLargeButton(String wood) {
        return registerBlock(wood + "_large_button", () -> new WoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD), true));
    }

    private static RegistryObject<Block> registerStoneLargeButton(String type) {
        return registerBlock(type + "_large_button", () -> new StoneButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE), true));
    }

    private static RegistryObject<Block> registerCopperLargeButton(String type) {
        return registerBlock(type + "_large_button", () -> new CopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER), true));
    }

    private static RegistryObject<Block> registerStickyCopperLargeButton(String type) {
        return registerBlock("sticky_" + type + "_large_button", () -> new StickyCopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER), true));
    }

    private static RegistryObject<Block> registerArrowLargeButton(String type) {
        return registerBlock(type + "_large_button", () -> new ArrowButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL), true));
    }

    private static RegistryObject<Block> registerPrismarineLargeButton(String type) {
        return registerBlock(type + "_large_button", () -> new PrismarineButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE), true));
    }

    private static RegistryObject<Block> registerSandLargeButton(String type, boolean gravel) {
        return registerBlock(type + "_large_button", () -> new FallingButton(gravel, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(gravel ? SoundType.GROUND : SoundType.SAND), true));
    }

    private static RegistryObject<Block> registerConcretePowderLargeButton(String color) {
        return registerSandLargeButton(color + "_concrete_powder", false);
    }

    private static RegistryObject<Block> registerEmergencyButton(String color) {
        return registerBlock(color + "_emergency_button", () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));
    }

    private static RegistryObject<Block> registerSafeEmergencyButton(String color) {
        return registerSafeEmergencyButtonBlock(color + "_safe_emergency_button", () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));
    }

    private static RegistryObject<Block> registerPlankSecretButton(String wood, MaterialColor materialColor) {
        return registerBlock(wood + "_plank_secret_button", () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, materialColor)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD), byName(wood + "_planks")));
    }

    private static RegistryObject<Block> registerNetherPlankSecretButton(String wood, MaterialColor materialColor) {
        return registerBlock(wood + "_plank_secret_button", () -> new PlankSecretButton(AbstractBlock.Properties.create(Material.NETHER_WOOD, materialColor)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD), byName(wood + "_planks")));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerSafeEmergencyButtonBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerSafeEmergencyButtonItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        RegistryObject<Item> register = InfinityButtonsItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
        InfinityButtonsUtil.REGISTRY_FOR_TAB.add(register);
    }

    private static <T extends Block> void registerSafeEmergencyButtonItem(String name, RegistryObject<T> block) {
        RegistryObject<Item> register = InfinityButtonsItems.ITEMS.register(name, () -> new SafeEmergencyButtonItem(block.get(),
                new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
        InfinityButtonsUtil.REGISTRY_FOR_TAB.add(register);
    }

    private static <T extends Block> RegistryObject<T> registerTorchBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
