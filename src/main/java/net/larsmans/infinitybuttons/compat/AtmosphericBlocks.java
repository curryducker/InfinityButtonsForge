package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.button.compat.FallingCompatButton;
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

public class AtmosphericBlocks {

    public static final RegistryObject<Block> ARID_SAND_BUTTON = registerSandButton("arid_sand");
    public static final RegistryObject<Block> RED_ARID_SAND_BUTTON = registerSandButton("red_arid_sand");

    public static final RegistryObject<Block> ARID_SAND_LARGE_BUTTON = registerSandLargeButton("arid_sand");
    public static final RegistryObject<Block> RED_ARID_SAND_LARGE_BUTTON = registerSandLargeButton("red_arid_sand");

    public static final RegistryObject<Block> ROSEWOOD_LARGE_BUTTON = registerLargeButton("rosewood");
    public static final RegistryObject<Block> MORADO_LARGE_BUTTON = registerLargeButton("morado");
    public static final RegistryObject<Block> YUCCA_LARGE_BUTTON = registerLargeButton("yucca");
    public static final RegistryObject<Block> KOUSA_LARGE_BUTTON = registerLargeButton("kousa");
    public static final RegistryObject<Block> ASPEN_LARGE_BUTTON = registerLargeButton("aspen");
    public static final RegistryObject<Block> GRIMWOOD_LARGE_BUTTON = registerLargeButton("grimwood");

    public static final RegistryObject<Block> ROSEWOOD_BOOKSHELF_SECRET_BUTTON = registerBookshelf("rosewood");
    public static final RegistryObject<Block> MORADO_BOOKSHELF_SECRET_BUTTON = registerBookshelf("morado");
    public static final RegistryObject<Block> YUCCA_BOOKSHELF_SECRET_BUTTON = registerBookshelf("yucca");
    public static final RegistryObject<Block> KOUSA_BOOKSHELF_SECRET_BUTTON = registerBookshelf("kousa");
    public static final RegistryObject<Block> ASPEN_BOOKSHELF_SECRET_BUTTON = registerBookshelf("aspen");
    public static final RegistryObject<Block> GRIMWOOD_BOOKSHELF_SECRET_BUTTON = registerBookshelf("grimwood");

    public static final RegistryObject<Block> ROSEWOOD_PLANK_SECRET_BUTTON = registerPlankButton("rosewood");
    public static final RegistryObject<Block> MORADO_PLANK_SECRET_BUTTON = registerPlankButton("morado");
    public static final RegistryObject<Block> YUCCA_PLANK_SECRET_BUTTON = registerPlankButton("yucca");
    public static final RegistryObject<Block> KOUSA_PLANK_SECRET_BUTTON = registerPlankButton("kousa");
    public static final RegistryObject<Block> ASPEN_PLANK_SECRET_BUTTON = registerPlankButton("aspen");
    public static final RegistryObject<Block> GRIMWOOD_PLANK_SECRET_BUTTON = registerPlankButton("grimwood");

    /**
     * Methods
     */

    private static Block byName(String block) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation("atmospheric", block));
    }

    private static RegistryObject<Block> registerSandButton(String type) {
        return registerBlock(type + "_button", () -> new FallingCompatButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND), false));
    }

    private static RegistryObject<Block> registerSandLargeButton(String type) {
        return registerBlock(type + "_large_button", () -> new FallingCompatButton(false, AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.SAND), true));
    }

    private static RegistryObject<Block> registerBookshelf(String wood) {
        return registerBlock(wood + "_bookshelf_secret_button", () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD), byName(wood + "_bookshelf")));
    }

    private static RegistryObject<Block> registerLargeButton(String wood) {
        return registerBlock(wood + "_large_button", () -> new WoodenCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD), true));
    }

    private static RegistryObject<Block> registerPlankButton(String wood) {
        return registerBlock(wood + "_plank_secret_button", () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD), byName(wood + "_planks")));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = InfinityButtonsBlocks.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        RegistryObject<Item> register = InfinityButtonsItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
        InfinityButtonsUtil.REGISTRY_FOR_TAB.add(register);
    }

    public static void registerCompatBlocks() {
        InfinityButtons.LOGGER.debug("Registering Atmospheric Compat Blocks for Infinity Buttons");
    }
}
