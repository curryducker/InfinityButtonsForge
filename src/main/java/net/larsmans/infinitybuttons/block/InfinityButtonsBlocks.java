package net.larsmans.infinitybuttons.block;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.custom.Doorbell;
import net.larsmans.infinitybuttons.block.custom.DoorbellButton;
import net.larsmans.infinitybuttons.block.custom.HoglinMountButton;
import net.larsmans.infinitybuttons.block.custom.button.*;
import net.larsmans.infinitybuttons.block.custom.button.compat.CompatWoodenButton;
import net.larsmans.infinitybuttons.block.custom.button.compat.PrismarineCompatButton;
import net.larsmans.infinitybuttons.block.custom.emergencybutton.EmergencyButton;
import net.larsmans.infinitybuttons.block.custom.emergencybutton.SafeEmergencyButton;
import net.larsmans.infinitybuttons.block.custom.largebutton.*;
import net.larsmans.infinitybuttons.block.custom.largebutton.compat.GlowshroomLargeButton;
import net.larsmans.infinitybuttons.block.custom.largebutton.compat.PrismarineCompatLargeButton;
import net.larsmans.infinitybuttons.block.custom.largebutton.compat.WoodenCompatLargeButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.*;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.*;
import net.larsmans.infinitybuttons.block.custom.torch.*;
import net.larsmans.infinitybuttons.block.custom.torch.compat.*;
import net.larsmans.infinitybuttons.block.custom.torch.compat.bamboo.*;
import net.larsmans.infinitybuttons.item.InfinityButtonsItemGroup;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.larsmans.infinitybuttons.item.custom.SafeEmergencyButtonItem;
import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
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

public class InfinityButtonsBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InfinityButtons.MOD_ID);

    /**
     * Buttons
     */

    public static final RegistryObject<Block> ANDESITE_BUTTON = registerBlock("andesite_button",
            () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> GRANITE_BUTTON = registerBlock("granite_button",
            () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> DIORITE_BUTTON = registerBlock("diorite_button",
            () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> COPPER_BUTTON = registerBlock("copper_button",
            () -> new CopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> EXPOSED_COPPER_BUTTON = registerBlock("exposed_copper_button",
            () -> new CopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> WEATHERED_COPPER_BUTTON = registerBlock("weathered_copper_button",
            () -> new CopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> OXIDIZED_COPPER_BUTTON = registerBlock("oxidized_copper_button",
            () -> new CopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_COPPER_BUTTON = registerBlock("sticky_copper_button",
            () -> new StickyCopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_EXPOSED_COPPER_BUTTON = registerBlock("sticky_exposed_copper_button",
            () -> new StickyCopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_WEATHERED_COPPER_BUTTON = registerBlock("sticky_weathered_copper_button",
            () -> new StickyCopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_OXIDIZED_COPPER_BUTTON = registerBlock("sticky_oxidized_copper_button",
            () -> new StickyCopperButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> EMERALD_BUTTON = registerBlock("emerald_button",
            () -> new EmeraldButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> IRON_BUTTON = registerBlock("iron_button",
            () -> new ArrowButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> GOLD_BUTTON = registerBlock("gold_button",
            () -> new ArrowButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> DIAMOND_BUTTON = registerBlock("diamond_button",
            () -> new DiamondButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> PRISMARINE_BUTTON = registerBlock("prismarine_button",
            () -> new PrismarineButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_BRICK_BUTTON = registerBlock("prismarine_brick_button",
            () -> new PrismarineButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARK_PRISMARINE_BUTTON = registerBlock("dark_prismarine_button",
            () -> new PrismarineButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> SAND_BUTTON = registerBlock("sand_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> RED_SAND_BUTTON = registerBlock("red_sand_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> GRAVEL_BUTTON = registerBlock("gravel_button",
            () -> new FallingButton(true, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.GROUND)));

    public static final RegistryObject<Block> RED_CONCRETE_POWDER_BUTTON = registerBlock("red_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> ORANGE_CONCRETE_POWDER_BUTTON = registerBlock("orange_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> YELLOW_CONCRETE_POWDER_BUTTON = registerBlock("yellow_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> LIME_CONCRETE_POWDER_BUTTON = registerBlock("lime_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> GREEN_CONCRETE_POWDER_BUTTON = registerBlock("green_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> CYAN_CONCRETE_POWDER_BUTTON = registerBlock("cyan_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_POWDER_BUTTON = registerBlock("light_blue_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> BLUE_CONCRETE_POWDER_BUTTON = registerBlock("blue_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> PURPLE_CONCRETE_POWDER_BUTTON = registerBlock("purple_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> MAGENTA_CONCRETE_POWDER_BUTTON = registerBlock("magenta_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> PINK_CONCRETE_POWDER_BUTTON = registerBlock("pink_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> BROWN_CONCRETE_POWDER_BUTTON = registerBlock("brown_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> WHITE_CONCRETE_POWDER_BUTTON = registerBlock("white_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_POWDER_BUTTON = registerBlock("light_gray_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> GRAY_CONCRETE_POWDER_BUTTON = registerBlock("gray_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> BLACK_CONCRETE_POWDER_BUTTON = registerBlock("black_concrete_powder_button",
            () -> new FallingButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> ELDER_PRISMARINE_BUTTON = registerCompatBlock("quark", "elder_prismarine_button",
            () -> new PrismarineCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ELDER_PRISMARINE_BRICK_BUTTON = registerCompatBlock("quark", "elder_prismarine_brick_button",
            () -> new PrismarineCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARK_ELDER_PRISMARINE_BUTTON = registerCompatBlock("quark", "dark_elder_prismarine_button",
            () -> new PrismarineCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> RED_STAINED_BUTTON = registerCompatBlock("quark", "red_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ORANGE_STAINED_BUTTON = registerCompatBlock("quark", "orange_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> YELLOW_STAINED_BUTTON = registerCompatBlock("quark", "yellow_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> LIME_STAINED_BUTTON = registerCompatBlock("quark", "lime_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GREEN_STAINED_BUTTON = registerCompatBlock("quark", "green_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CYAN_STAINED_BUTTON = registerCompatBlock("quark", "cyan_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_BUTTON = registerCompatBlock("quark", "light_blue_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BLUE_STAINED_BUTTON = registerCompatBlock("quark", "blue_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PURPLE_STAINED_BUTTON = registerCompatBlock("quark", "purple_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> MAGENTA_STAINED_BUTTON = registerCompatBlock("quark", "magenta_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PINK_STAINED_BUTTON = registerCompatBlock("quark", "pink_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_STAINED_BUTTON = registerCompatBlock("quark", "brown_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WHITE_STAINED_BUTTON = registerCompatBlock("quark", "white_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_BUTTON = registerCompatBlock("quark", "light_gray_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GRAY_STAINED_BUTTON = registerCompatBlock("quark", "gray_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BLACK_STAINED_BUTTON = registerCompatBlock("quark", "black_stained_button",
            () -> new CompatWoodenButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    /**
     * Large Buttons
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
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_LARGE_BUTTON = registerBlock("andesite_large_button",
            () -> new StoneLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> GRANITE_LARGE_BUTTON = registerBlock("granite_large_button",
            () -> new StoneLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> DIORITE_LARGE_BUTTON = registerBlock("diorite_large_button",
            () -> new StoneLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> POLISHED_BLACKSTONE_LARGE_BUTTON = registerBlock("polished_blackstone_large_button",
            () -> new StoneLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> COPPER_LARGE_BUTTON = registerBlock("copper_large_button",
            () -> new CopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> EXPOSED_COPPER_LARGE_BUTTON = registerBlock("exposed_copper_large_button",
            () -> new CopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> WEATHERED_COPPER_LARGE_BUTTON = registerBlock("weathered_copper_large_button",
            () -> new CopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> OXIDIZED_COPPER_LARGE_BUTTON = registerBlock("oxidized_copper_large_button",
            () -> new CopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_COPPER_LARGE_BUTTON = registerBlock("sticky_copper_large_button",
            () -> new StickyCopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_EXPOSED_COPPER_LARGE_BUTTON = registerBlock("sticky_exposed_copper_large_button",
            () -> new StickyCopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_WEATHERED_COPPER_LARGE_BUTTON = registerBlock("sticky_weathered_copper_large_button",
            () -> new StickyCopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> STICKY_OXIDIZED_COPPER_LARGE_BUTTON = registerBlock("sticky_oxidized_copper_large_button",
            () -> new StickyCopperLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(InfinityButtonsSounds.COPPER)));

    public static final RegistryObject<Block> EMERALD_LARGE_BUTTON = registerBlock("emerald_large_button",
            () -> new EmeraldLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> IRON_LARGE_BUTTON = registerBlock("iron_large_button",
            () -> new ArrowLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> GOLD_LARGE_BUTTON = registerBlock("gold_large_button",
            () -> new ArrowLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> DIAMOND_LARGE_BUTTON = registerBlock("diamond_large_button",
            () -> new DiamondLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.METAL)));

    public static final RegistryObject<Block> PRISMARINE_LARGE_BUTTON = registerBlock("prismarine_large_button",
            () -> new PrismarineLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_BRICK_LARGE_BUTTON = registerBlock("prismarine_brick_large_button",
            () -> new PrismarineLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARK_PRISMARINE_LARGE_BUTTON = registerBlock("dark_prismarine_large_button",
            () -> new PrismarineLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> SAND_LARGE_BUTTON = registerBlock("sand_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> RED_SAND_LARGE_BUTTON = registerBlock("red_sand_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> GRAVEL_LARGE_BUTTON = registerBlock("gravel_large_button",
            () -> new FallingLargeButton(true, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.GROUND)));

    public static final RegistryObject<Block> RED_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("red_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> ORANGE_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("orange_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> YELLOW_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("yellow_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> LIME_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("lime_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> GREEN_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("green_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> CYAN_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("cyan_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("light_blue_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> BLUE_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("blue_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> PURPLE_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("purple_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> MAGENTA_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("magenta_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> PINK_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("pink_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> BROWN_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("brown_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> WHITE_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("white_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("light_gray_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> GRAY_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("gray_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    public static final RegistryObject<Block> BLACK_CONCRETE_POWDER_LARGE_BUTTON = registerBlock("black_concrete_powder_large_button",
            () -> new FallingLargeButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND)));

    // Compat Large Buttons

    public static final RegistryObject<Block> RED_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "red_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ORANGE_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "orange_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> YELLOW_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "yellow_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> LIME_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "lime_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GREEN_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "green_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CYAN_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "cyan_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "light_blue_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BLUE_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "blue_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PURPLE_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "purple_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> MAGENTA_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "magenta_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PINK_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "pink_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "brown_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WHITE_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "white_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "light_gray_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GRAY_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "gray_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BLACK_STAINED_LARGE_BUTTON = registerCompatBlock("quark", "black_stained_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ELDER_PRISMARINE_LARGE_BUTTON = registerCompatBlock("quark", "elder_prismarine_large_button",
            () -> new PrismarineCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ELDER_PRISMARINE_BRICK_LARGE_BUTTON = registerCompatBlock("quark", "elder_prismarine_brick_large_button",
            () -> new PrismarineCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARK_ELDER_PRISMARINE_LARGE_BUTTON = registerCompatBlock("quark", "dark_elder_prismarine_large_button",
            () -> new PrismarineCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.STONE)));

    public static final RegistryObject<Block> WILLOW_LARGE_BUTTON = registerCompatBlock("environmental", "willow_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CHERRY_LARGE_BUTTON = registerCompatBlock("environmental", "cherry_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WISTERIA_LARGE_BUTTON = registerCompatBlock("environmental", "wisteria_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> POISE_LARGE_BUTTON = registerCompatBlock("endergetic", "poise_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> MAPLE_LARGE_BUTTON = registerCompatBlock("autumnity", "maple_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> JACARANDA_LARGE_BUTTON = registerCompatBlock("abundance", "jacaranda_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> REDBUD_LARGE_BUTTON = registerCompatBlock("abundance", "redbud_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ROSEWOOD_LARGE_BUTTON = registerCompatBlock("atmospheric", "rosewood_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> MORADO_LARGE_BUTTON = registerCompatBlock("atmospheric", "morado_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> YUCCA_LARGE_BUTTON = registerCompatBlock("atmospheric", "yucca_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> KOUSA_LARGE_BUTTON = registerCompatBlock("atmospheric", "kousa_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ASPEN_LARGE_BUTTON = registerCompatBlock("atmospheric", "aspen_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GRIMWOOD_LARGE_BUTTON = registerCompatBlock("atmospheric", "grimwood_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BAMBOO_LARGE_BUTTON = registerCompatBlock("bamboo_blocks", "bamboo_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CYPRESS_LARGE_BUTTON = registerCompatBlock("bayou_blues", "cypress_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> RED_MUSHROOM_LARGE_BUTTON = registerCompatBlock("enhanced_mushrooms", "red_mushroom_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_MUSHROOM_LARGE_BUTTON = registerCompatBlock("enhanced_mushrooms", "brown_mushroom_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GLOWSHROOM_LARGE_BUTTON = registerCompatBlock("enhanced_mushrooms", "glowshroom_large_button",
            () -> new GlowshroomLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD).setLightLevel((state) -> {
                        return 14;
                    })));

    public static final RegistryObject<Block> DRIFTWOOD_LARGE_BUTTON = registerCompatBlock("upgrade_aquatic", "driftwood_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> RIVER_LARGE_BUTTON = registerCompatBlock("upgrade_aquatic", "river_large_button",
            () -> new WoodenCompatLargeButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    /**
     * Emergency Buttons
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

    public static final RegistryObject<Block> FANCY_EMERGENCY_BUTTON = registerBlock("fancy_emergency_button",
            () -> new EmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> RED_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("red_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> ORANGE_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("orange_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> YELLOW_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("yellow_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> LIME_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("lime_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> GREEN_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("green_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> CYAN_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("cyan_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> LIGHT_BLUE_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("light_blue_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> BLUE_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("blue_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> PURPLE_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("purple_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> MAGENTA_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("magenta_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> PINK_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("pink_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> BROWN_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("brown_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> WHITE_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("white_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> LIGHT_GRAY_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("light_gray_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> GRAY_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("gray_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> BLACK_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("black_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    public static final RegistryObject<Block> FANCY_SAFE_EMERGENCY_BUTTON = registerSafeEmergencyButtonBlock("fancy_safe_emergency_button",
            () -> new SafeEmergencyButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5f).notSolid().sound(SoundType.METAL)));

    /**
     * Secret Buttons
     */

    // Bookshelf

    public static final RegistryObject<Block> BOOKSHELF_SECRET_BUTTON = registerBlock("bookshelf_secret_button",
            () -> new BookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> SPRUCE_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("quark", "spruce_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BIRCH_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("quark", "birch_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> JUNGLE_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("quark", "jungle_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ACACIA_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("quark", "acacia_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> DARK_OAK_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("quark", "dark_oak_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CRIMSON_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("quark", "crimson_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WARPED_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("quark", "warped_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WILLOW_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("environmental", "willow_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CHERRY_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("environmental", "cherry_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WISTERIA_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("environmental", "wisteria_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> POISE_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("endergetic", "poise_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> MAPLE_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("autumnity", "maple_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> JACARANDA_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("abundance", "jacaranda_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> REDBUD_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("abundance", "redbud_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ROSEWOOD_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("atmospheric", "rosewood_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> MORADO_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("atmospheric", "morado_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> YUCCA_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("atmospheric", "yucca_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> KOUSA_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("atmospheric", "kousa_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ASPEN_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("atmospheric", "aspen_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GRIMWOOD_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("atmospheric", "grimwood_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BAMBOO_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("bamboo_blocks", "bamboo_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CYPRESS_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("bayou_blues", "cypress_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> RED_MUSHROOM_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("enhanced_mushrooms", "red_mushroom_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_MUSHROOM_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("enhanced_mushrooms", "brown_mushroom_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GLOWSHROOM_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("enhanced_mushrooms", "glowshroom_bookshelf_secret_button",
            () -> new GlowshroomBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD).setLightLevel((state) -> {
                        return 14;
                    })));

    public static final RegistryObject<Block> DRIFTWOOD_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("upgrade_aquatic", "driftwood_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> RIVER_BOOKSHELF_SECRET_BUTTON = registerCompatBlock("upgrade_aquatic", "river_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    // Other

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
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 2.5f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_MUD_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_mud_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 2.5f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> DEEPSLATE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "deepslate_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.5f, 6.0f).notSolid().sound(QuarkSounds.DEEPSLATE_BRICKS_TYPE).setRequiresTool()));

    public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "cracked_deepslate_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
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
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED)
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
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ICE_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "ice_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ICE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.0f, 2.0f).notSolid().sound(SoundType.GLASS).setRequiresTool().slipperiness(0.99F)));

    public static final RegistryObject<Block> CHISELED_ICE_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_ice_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ICE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.0f, 2.0f).notSolid().sound(SoundType.GLASS).setRequiresTool().slipperiness(0.99F)));

    public static final RegistryObject<Block> TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ADOBE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ADOBE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "white_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_WHITE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_white_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "orange_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_ORANGE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_orange_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "magenta_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.MAGENTA_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_MAGENTA_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_magenta_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.MAGENTA_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "light_blue_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_LIGHT_BLUE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_light_blue_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "yellow_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_YELLOW_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_yellow_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> LIME_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "lime_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIME_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_LIME_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_lime_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIME_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> PINK_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "pink_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_PINK_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_pink_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "gray_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_GRAY_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_gray_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "light_gray_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_LIGHT_GRAY_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_light_gray_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "cyan_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.CYAN_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_CYAN_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_cyan_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.CYAN_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "purple_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_PURPLE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_purple_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "blue_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_BLUE_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_blue_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "brown_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_BROWN_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_brown_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "green_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GREEN_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_GREEN_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_green_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GREEN_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> RED_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "red_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_RED_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_red_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "black_terracotta_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_BLACK_TERRACOTTA_BRICK_SECRET_BUTTON = registerCompatBlock("environmental", "chiseled_black_terracotta_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.25f, 4.2f).notSolid().setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_END_STONE_BRICK_SECRET_BUTTON = registerCompatBlock("endergetic", "chiseled_end_stone_brick_secret_button",
            () -> new ChiseledEndStoneBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0f, 9.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_EUMUS_BRICK_SECRET_BUTTON = registerCompatBlock("endergetic", "chiseled_eumus_brick_secret_button",
            () -> new ChiseledEumusBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 30.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CRACKED_END_STONE_BRICK_SECRET_BUTTON = registerCompatBlock("endergetic", "cracked_end_stone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0f, 9.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CRACKED_EUMUS_BRICK_SECRET_BUTTON = registerCompatBlock("endergetic", "cracked_eumus_brick_secret_button",
            () -> new EumusBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 30.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> EUMUS_BRICK_SECRET_BUTTON = registerCompatBlock("endergetic", "eumus_brick_secret_button",
            () -> new EumusBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 30.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> PERMAFROST_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "permafrost_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 10.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> SANDY_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "sandy_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHARRED_NETHER_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "charred_nether_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> BLUE_NETHER_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "blue_nether_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> TWISTING_POLISHED_BLACKSTONE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "twisting_polished_blackstone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> WEEPING_POLISHED_BLACKSTONE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "weeping_polished_blackstone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> MAGMA_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "magma_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 10.0f).notSolid().sound(SoundType.STONE).setRequiresTool().setLightLevel((state) -> {
                        return 3;
                    }).setEmmisiveRendering((s, r, p) -> true)));

    public static final RegistryObject<Block> POLISHED_GRANITE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "polished_granite_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIRT)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> POLISHED_DIORITE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "polished_diorite_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.QUARTZ)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> POLISHED_ANDESITE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "polished_andesite_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> POLISHED_MARBLE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "polished_marble_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.QUARTZ)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> POLISHED_LIMESTONE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "polished_limestone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> POLISHED_JASPER_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "polished_jasper_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> POLISHED_SLATE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "polished_slate_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ICE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> POLISHED_VOIDSTONE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "polished_voidstone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> BIOTITE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "biotite_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.8f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> DARK_ELDER_PRISMARINE_SECRET_BUTTON = registerCompatBlock("quark", "dark_elder_prismarine_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ADOBE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 10f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_POLISHED_ANDESITE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "chiseled_polished_andesite_brick_secret_button",
            () -> new ChiseledStonepatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_POLISHED_GRANITE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "chiseled_polished_granite_brick_secret_button",
            () -> new ChiseledStonepatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.DIRT)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_POLISHED_DIORITE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "chiseled_polished_diorite_brick_secret_button",
            () -> new ChiseledStonepatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.QUARTZ)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_POLISHED_MARBLE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "chiseled_polished_marble_brick_secret_button",
            () -> new ChiseledStonepatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.QUARTZ)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_POLISHED_LIMESTONE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "chiseled_polished_limestone_brick_secret_button",
            () -> new ChiseledStonepatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_POLISHED_JASPER_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "chiseled_polished_jasper_brick_secret_button",
            () -> new ChiseledStonepatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_POLISHED_SLATE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "chiseled_polished_slate_brick_secret_button",
            () -> new ChiseledStonepatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ICE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_POLISHED_VOIDSTONE_BRICK_SECRET_BUTTON = registerCompatBlock("quark", "chiseled_polished_voidstone_brick_secret_button",
            () -> new ChiseledStonepatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> HONEYCOMB_BRICK_SECRET_BUTTON = registerCompatBlock("buzzier_bees", "honeycomb_brick_secret_button",
            () -> new FullCompatBrickSecretButton(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.ADOBE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.CORAL).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_HONEYCOMB_BRICK_SECRET_BUTTON = registerCompatBlock("buzzier_bees", "chiseled_honeycomb_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.ADOBE)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 6.0f).notSolid().sound(SoundType.CORAL).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_CHOCOLATE_BRICK_SECRET_BUTTON = registerCompatBlock("neapolitan", "chiseled_chocolate_brick_secret_button",
            () -> new ChiseledCompatBrickSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_GLOOMY_TILE_SECRET_BUTTON = registerCompatBlock("neapolitan", "chiseled_gloomy_tile_secret_button",
            () -> new ChiseledStonepatBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_BLUE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool().setLightLevel((state) -> {
                        return getPressLight(state, 7);
                    })));

    public static final RegistryObject<Block> KELPY_STONE_BRICK_SECRET_BUTTON = registerCompatBlock("upgrade_aquatic", "kelpy_stone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> TONGUE_KELPY_STONE_BRICK_SECRET_BUTTON = registerCompatBlock("upgrade_aquatic", "tongue_kelpy_stone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> THORNY_KELPY_STONE_BRICK_SECRET_BUTTON = registerCompatBlock("upgrade_aquatic", "thorny_kelpy_stone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> OCHRE_KELPY_STONE_BRICK_SECRET_BUTTON = registerCompatBlock("upgrade_aquatic", "ochre_kelpy_stone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> POLAR_KELPY_STONE_BRICK_SECRET_BUTTON = registerCompatBlock("upgrade_aquatic", "polar_kelpy_stone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    public static final RegistryObject<Block> CHISELED_TOOTH_BRICK_SECRET_BUTTON = registerCompatBlock("upgrade_aquatic", "chiseled_tooth_brick_secret_button",
            () -> new ChiseledToothSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0f, 9.0f).notSolid().sound(SoundType.STONE).setRequiresTool()));

    // Compat Plank Secret Button

    public static final RegistryObject<Block> RED_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "red_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.RED)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ORANGE_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "orange_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.ADOBE)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> YELLOW_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "yellow_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.YELLOW)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> LIME_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "lime_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.LIME)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GREEN_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "green_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CYAN_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "cyan_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.CYAN)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "light_blue_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.LIGHT_BLUE)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BLUE_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "blue_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BLUE)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PURPLE_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "purple_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PURPLE)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> MAGENTA_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "magenta_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.MAGENTA)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PINK_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "pink_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PINK)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "brown_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WHITE_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "white_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SNOW)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "light_gray_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.LIGHT_GRAY)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GRAY_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "gray_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GRAY)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BLACK_STAINED_PLANK_SECRET_BUTTON = registerCompatBlock("quark", "black_stained_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BLACK)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WILLOW_PLANK_SECRET_BUTTON = registerCompatBlock("environmental", "willow_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CHERRY_PLANK_SECRET_BUTTON = registerCompatBlock("environmental", "cherry_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WISTERIA_PLANK_SECRET_BUTTON = registerCompatBlock("environmental", "wisteria_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> POISE_PLANK_SECRET_BUTTON = registerCompatBlock("endergetic", "poise_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> MAPLE_PLANK_SECRET_BUTTON = registerCompatBlock("autumnity", "maple_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> JACARANDA_PLANK_SECRET_BUTTON = registerCompatBlock("abundance", "jacaranda_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PURPLE)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> REDBUD_PLANK_SECRET_BUTTON = registerCompatBlock("abundance", "redbud_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PURPLE)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ROSEWOOD_PLANK_SECRET_BUTTON = registerCompatBlock("atmospheric", "rosewood_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> MORADO_PLANK_SECRET_BUTTON = registerCompatBlock("atmospheric", "morado_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> YUCCA_PLANK_SECRET_BUTTON = registerCompatBlock("atmospheric", "yucca_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> KOUSA_PLANK_SECRET_BUTTON = registerCompatBlock("atmospheric", "kousa_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ASPEN_PLANK_SECRET_BUTTON = registerCompatBlock("atmospheric", "aspen_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GRIMWOOD_PLANK_SECRET_BUTTON = registerCompatBlock("atmospheric", "grimwood_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BAMBOO_PLANK_SECRET_BUTTON = registerCompatBlock("bamboo_blocks", "bamboo_plank_secret_button",
            () -> new BambooPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.25f, 3.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CYPRESS_PLANK_SECRET_BUTTON = registerCompatBlock("bayou_blues", "cypress_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.GREEN)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> RED_MUSHROOM_PLANK_SECRET_BUTTON = registerCompatBlock("enhanced_mushrooms", "red_mushroom_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_MUSHROOM_PLANK_SECRET_BUTTON = registerCompatBlock("enhanced_mushrooms", "brown_mushroom_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIRT)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> DRIFTWOOD_PLANK_SECRET_BUTTON = registerCompatBlock("upgrade_aquatic", "driftwood_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.STONE)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> RIVER_PLANK_SECRET_BUTTON = registerCompatBlock("upgrade_aquatic", "river_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2).notSolid().sound(SoundType.WOOD)));

    /**
     * Misc
     */

    public static final RegistryObject<Block> DOORBELL = registerBlock("doorbell",
            () -> new Doorbell(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> DOORBELL_BUTTON = registerBlock("doorbell_button",
            () -> new DoorbellButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> HOGLIN_MOUNT_BUTTON = registerCompatBlock("nethers_delight", "hoglin_mount_button",
            () -> new HoglinMountButton(AbstractBlock.Properties.from(Blocks.BROWN_WOOL)
                    .setLightLevel((state) -> {
                        return 1;
                    })));

    /**
     * Torches
     */

    public static final RegistryObject<Block> TORCH_BUTTON = registerTorchBlock("torch_button",
            () -> new TorchButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD), ParticleTypes.FLAME));

    public static final RegistryObject<Block> WALL_TORCH_BUTTON = registerTorchBlock("wall_torch_button",
            () -> new WallTorchButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD).lootFrom(TORCH_BUTTON), ParticleTypes.FLAME));

    public static final RegistryObject<Block> TORCH_LEVER = registerTorchBlock("torch_lever",
            () -> new TorchLever(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD), ParticleTypes.FLAME));

    public static final RegistryObject<Block> WALL_TORCH_LEVER = registerTorchBlock("wall_torch_lever",
            () -> new WallTorchLever(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD).lootFrom(TORCH_LEVER), ParticleTypes.FLAME));

    public static final RegistryObject<Block> SOUL_TORCH_BUTTON = registerTorchBlock("soul_torch_button",
            () -> new TorchButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 10;
            }).sound(SoundType.WOOD), ParticleTypes.SOUL_FIRE_FLAME));

    public static final RegistryObject<Block> SOUL_WALL_TORCH_BUTTON = registerTorchBlock("soul_wall_torch_button",
            () -> new WallTorchButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 10;
            }).sound(SoundType.WOOD).lootFrom(SOUL_TORCH_BUTTON), ParticleTypes.SOUL_FIRE_FLAME));

    public static final RegistryObject<Block> SOUL_TORCH_LEVER = registerTorchBlock("soul_torch_lever",
            () -> new TorchLever(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 10;
            }).sound(SoundType.WOOD), ParticleTypes.SOUL_FIRE_FLAME));

    public static final RegistryObject<Block> SOUL_WALL_TORCH_LEVER = registerTorchBlock("soul_wall_torch_lever",
            () -> new WallTorchLever(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 10;
            }).sound(SoundType.WOOD).lootFrom(SOUL_TORCH_LEVER), ParticleTypes.SOUL_FIRE_FLAME));

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

    public static final RegistryObject<Block> ENDER_TORCH_BUTTON = registerCompatTorchBlock("endergetic", "ender_torch_button",
            () -> new EnderTorchButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ENDER_WALL_TORCH_BUTTON = registerCompatTorchBlock("endergetic", "ender_wall_torch_button",
            () -> new EnderWallTorchButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ENDER_TORCH_LEVER = registerCompatTorchBlock("endergetic", "ender_torch_lever",
            () -> new EnderTorchLever(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ENDER_WALL_TORCH_LEVER = registerCompatTorchBlock("endergetic", "ender_wall_torch_lever",
            () -> new EnderWallTorchLever(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PROPELPLANT_TORCH_BUTTON = registerCompatTorchBlock("nethers_delight", "propelplant_torch_button",
            () -> new PropelTorchButton(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 12;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PROPELPLANT_WALL_TORCH_BUTTON = registerCompatTorchBlock("nethers_delight", "propelplant_wall_torch_button",
            () -> new PropelWallTorchButton(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 12;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PROPELPLANT_TORCH_LEVER = registerCompatTorchBlock("nethers_delight", "propelplant_torch_lever",
            () -> new PropelTorchLever(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 12;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PROPELPLANT_WALL_TORCH_LEVER = registerCompatTorchBlock("nethers_delight", "propelplant_wall_torch_lever",
            () -> new PropelWallTorchLever(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 12;
            }).sound(SoundType.WOOD)));

    // Bamboo

    public static final RegistryObject<Block> BAMBOO_TORCH_BUTTON = registerCompatTorchBlock("bamboo_blocks", "bamboo_torch_button",
            () -> new BambooTorchButton(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BAMBOO_WALL_TORCH_BUTTON = registerCompatTorchBlock("bamboo_blocks", "bamboo_wall_torch_button",
            () -> new BambooWallTorchButton(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BAMBOO_TORCH_LEVER = registerCompatTorchBlock("bamboo_blocks", "bamboo_torch_lever",
            () -> new BambooTorchLever(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BAMBOO_WALL_TORCH_LEVER = registerCompatTorchBlock("bamboo_blocks", "bamboo_wall_torch_lever",
            () -> new BambooWallTorchLever(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> SOUL_BAMBOO_TORCH_BUTTON = registerCompatTorchBlock("bamboo_blocks", "soul_bamboo_torch_button",
            () -> new SoulBambooTorchButton(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 10;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> SOUL_BAMBOO_WALL_TORCH_BUTTON = registerCompatTorchBlock("bamboo_blocks", "soul_bamboo_wall_torch_button",
            () -> new SoulBambooWallTorchButton(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 10;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> SOUL_BAMBOO_TORCH_LEVER = registerCompatTorchBlock("bamboo_blocks", "soul_bamboo_torch_lever",
            () -> new SoulBambooTorchLever(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 10;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> SOUL_BAMBOO_WALL_TORCH_LEVER = registerCompatTorchBlock("bamboo_blocks", "soul_bamboo_wall_torch_lever",
            () -> new SoulBambooWallTorchLever(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 10;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ENDER_BAMBOO_TORCH_BUTTON = registerCompatTorchBlock("bamboo_blocks", "ender_bamboo_torch_button",
            () -> new EnderBambooTorchButton(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ENDER_BAMBOO_WALL_TORCH_BUTTON = registerCompatTorchBlock("bamboo_blocks", "ender_bamboo_wall_torch_button",
            () -> new EnderBambooWallTorchButton(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ENDER_BAMBOO_TORCH_LEVER = registerCompatTorchBlock("bamboo_blocks", "ender_bamboo_torch_lever",
            () -> new EnderBambooTorchLever(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> ENDER_BAMBOO_WALL_TORCH_LEVER = registerCompatTorchBlock("bamboo_blocks", "ender_bamboo_wall_torch_lever",
            () -> new EnderBambooWallTorchLever(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> {
                return 14;
            }).sound(SoundType.WOOD)));

    /**
     * Methods
     */

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, InfinityButtonsItemGroup.INFINITYBUTTONS);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerSafeEmergencyButtonBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerSafeEmergencyButtonItem(name, toReturn, InfinityButtonsItemGroup.INFINITYBUTTONS);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerCompatBlock(String modid, String name, Supplier<T> block) {
        RegistryObject<T> toReturn = null;
        if (ModList.get().isLoaded(modid)) {
            toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn, InfinityButtonsItemGroup.INFINITYBUTTONSCOMPAT);
        }
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, ItemGroup group) {
        InfinityButtonsItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(group)));
    }

    private static <T extends Block> void registerSafeEmergencyButtonItem(String name, RegistryObject<T> block, ItemGroup group) {
        InfinityButtonsItems.ITEMS.register(name, () -> new SafeEmergencyButtonItem(block.get(),
                new Item.Properties().group(group)));
    }

    private static <T extends Block> RegistryObject<T> registerTorchBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerCompatTorchBlock(String modid, String name, Supplier<T> block) {
        RegistryObject<T> toReturn = null;
        if (ModList.get().isLoaded(modid)) {
            toReturn = BLOCKS.register(name, block);
        }
        return toReturn;
    }

    public static int getPressLight(BlockState state, int value) {
        return state.get(AbstractSecretButton.PRESSED) ? value : 0;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
