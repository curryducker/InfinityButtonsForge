package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.button.compat.WoodenCompatButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.BambooPlankSecretButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.CompatBookshelfSecretButton;
import net.larsmans.infinitybuttons.block.custom.torch.compat.bamboo.*;
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

public class BambooBlocksBlocks {

    public static AbstractBlock.Properties PROP = AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD);
    public static AbstractBlock.Properties SOUL_PROP =AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 10).sound(SoundType.WOOD);

    public static final RegistryObject<Block> BAMBOO_LARGE_BUTTON = registerBlock("bamboo_large_button",
            () -> new WoodenCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD), true));

    public static final RegistryObject<Block> BAMBOO_BOOKSHELF_SECRET_BUTTON = registerBlock("bamboo_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BAMBOO_PLANK_SECRET_BUTTON = registerBlock("bamboo_plank_secret_button",
            () -> new BambooPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.25f, 3.5f).notSolid().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BAMBOO_TORCH_BUTTON = registerTorchBlock("bamboo_torch_button",
            () -> new BambooTorchButton(PROP));

    public static final RegistryObject<Block> BAMBOO_WALL_TORCH_BUTTON = registerTorchBlock("bamboo_wall_torch_button",
            () -> new BambooWallTorchButton(PROP));

    public static final RegistryObject<Block> BAMBOO_TORCH_LEVER = registerTorchBlock("bamboo_torch_lever",
            () -> new BambooTorchLever(PROP));

    public static final RegistryObject<Block> BAMBOO_WALL_TORCH_LEVER = registerTorchBlock("bamboo_wall_torch_lever",
            () -> new BambooWallTorchLever(PROP));

    public static final RegistryObject<Block> SOUL_BAMBOO_TORCH_BUTTON = registerTorchBlock("soul_bamboo_torch_button",
            () -> new SoulBambooTorchButton(SOUL_PROP));

    public static final RegistryObject<Block> SOUL_BAMBOO_WALL_TORCH_BUTTON = registerTorchBlock("soul_bamboo_wall_torch_button",
            () -> new SoulBambooWallTorchButton(SOUL_PROP));

    public static final RegistryObject<Block> SOUL_BAMBOO_TORCH_LEVER = registerTorchBlock("soul_bamboo_torch_lever",
            () -> new SoulBambooTorchLever(SOUL_PROP));

    public static final RegistryObject<Block> SOUL_BAMBOO_WALL_TORCH_LEVER = registerTorchBlock("soul_bamboo_wall_torch_lever",
            () -> new SoulBambooWallTorchLever(SOUL_PROP));

    public static final RegistryObject<Block> ENDER_BAMBOO_TORCH_BUTTON = registerTorchBlock("ender_bamboo_torch_button",
            () -> new EnderBambooTorchButton(PROP));

    public static final RegistryObject<Block> ENDER_BAMBOO_WALL_TORCH_BUTTON = registerTorchBlock("ender_bamboo_wall_torch_button",
            () -> new EnderBambooWallTorchButton(PROP));

    public static final RegistryObject<Block> ENDER_BAMBOO_TORCH_LEVER = registerTorchBlock("ender_bamboo_torch_lever",
            () -> new EnderBambooTorchLever(PROP));

    public static final RegistryObject<Block> ENDER_BAMBOO_WALL_TORCH_LEVER = registerTorchBlock("ender_bamboo_wall_torch_lever",
            () -> new EnderBambooWallTorchLever(PROP));

    /**
     * Methods
     */

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = InfinityButtonsBlocks.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        InfinityButtonsItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
    }

    private static <T extends Block> RegistryObject<T> registerTorchBlock(String name, Supplier<T> block) {
        return InfinityButtonsBlocks.BLOCKS.register(name, block);
    }

    public static void registerCompatBlocks() {
        InfinityButtons.LOGGER.debug("Registering Bamboo Blocks Compat Blocks for Infinity Buttons");
    }
}
