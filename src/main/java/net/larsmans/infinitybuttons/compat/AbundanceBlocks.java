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
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class AbundanceBlocks {

    public static final RegistryObject<Block> JACARANDA_LARGE_BUTTON = registerLargeButton("jacaranda");
    public static final RegistryObject<Block> REDBUD_LARGE_BUTTON = registerLargeButton("redbud");

    public static final RegistryObject<Block> JACARANDA_BOOKSHELF_SECRET_BUTTON = registerBookshelf("jacaranda");
    public static final RegistryObject<Block> REDBUD_BOOKSHELF_SECRET_BUTTON = registerBookshelf("redbud");

    public static final RegistryObject<Block> JACARANDA_PLANK_SECRET_BUTTON = registerPlankButton("jacaranda", MaterialColor.PURPLE);
    public static final RegistryObject<Block> REDBUD_PLANK_SECRET_BUTTON = registerPlankButton("redbud", MaterialColor.RED);

    /**
     * Methods
     */

    private static RegistryObject<Block> registerBookshelf(String wood) {
        return registerBlock(wood + "_bookshelf_secret_button", () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));
    }

    private static RegistryObject<Block> registerLargeButton(String wood) {
        return registerBlock(wood + "_large_button", () -> new WoodenCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD), true));
    }

    private static RegistryObject<Block> registerPlankButton(String wood, MaterialColor materialColor) {
        return registerBlock(wood + "_plank_secret_button", () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, materialColor)
                .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD)));
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
        InfinityButtons.LOGGER.debug("Registering Abundance Compat Blocks for Infinity Buttons");
    }
}
