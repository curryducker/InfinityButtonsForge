package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.button.compat.WoodenCompatButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.BigCompatSecretButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.ChiseledToothSecretButton;
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

public class UpgradeAquaticBlocks {

    public static final RegistryObject<Block> DRIFTWOOD_LARGE_BUTTON = registerLargeButton("driftwood");
    public static final RegistryObject<Block> RIVER_LARGE_BUTTON = registerLargeButton("river");


    public static final RegistryObject<Block> DRIFTWOOD_BOOKSHELF_SECRET_BUTTON = registerBookshelf("driftwood");
    public static final RegistryObject<Block> RIVER_BOOKSHELF_SECRET_BUTTON = registerBookshelf("river");

    public static final RegistryObject<Block> KELPY_STONE_BRICK_SECRET_BUTTON = registerBlock("kelpy_stone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("kelpy_stone_bricks")));

    public static final RegistryObject<Block> TONGUE_KELPY_STONE_BRICK_SECRET_BUTTON = registerKelpyBlock("tongue");
    public static final RegistryObject<Block> THORNY_KELPY_STONE_BRICK_SECRET_BUTTON = registerKelpyBlock("thorny");
    public static final RegistryObject<Block> OCHRE_KELPY_STONE_BRICK_SECRET_BUTTON = registerKelpyBlock("ochre");
    public static final RegistryObject<Block> POLAR_KELPY_STONE_BRICK_SECRET_BUTTON = registerKelpyBlock("polar");


    public static final RegistryObject<Block> CHISELED_TOOTH_BRICK_SECRET_BUTTON = registerBlock("chiseled_tooth_brick_secret_button",
            () -> new ChiseledToothSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0f, 9.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("chiseled_tooth_bricks")));

    public static final RegistryObject<Block> DRIFTWOOD_PLANK_SECRET_BUTTON = registerPlankButton("driftwood", MaterialColor.STONE);
    public static final RegistryObject<Block> RIVER_PLANK_SECRET_BUTTON = registerPlankButton("river", MaterialColor.BROWN);


    /**
     * Methods
     */

    private static Block byName(String block) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation("upgrade_aquatic", block));
    }

    private static RegistryObject<Block> registerBookshelf(String wood) {
        return registerBlock(wood + "_bookshelf_secret_button", () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD), byName(wood + "_bookshelf")));
    }

    private static RegistryObject<Block> registerLargeButton(String wood) {
        return registerBlock(wood + "_large_button", () -> new WoodenCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD), true));
    }

    private static RegistryObject<Block> registerPlankButton(String wood, MaterialColor materialColor) {
        return registerBlock(wood + "_plank_secret_button", () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, materialColor)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2).notSolid().sound(SoundType.WOOD), byName(wood + "_planks")));
    }

    private static RegistryObject<Block> registerKelpyBlock(String type) {
        return registerBlock(type + "_kelpy_stone_brick_secret_button", () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5f, 6.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName(type + "_kelpy_stone_bricks")));
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
        InfinityButtons.LOGGER.debug("Registering Upgrade Aquatic Compat Blocks for Infinity Buttons");
    }
}
