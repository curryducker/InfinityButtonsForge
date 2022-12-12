package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.HoglinMountButton;
import net.larsmans.infinitybuttons.block.custom.torch.compat.PropelTorchButton;
import net.larsmans.infinitybuttons.block.custom.torch.compat.PropelTorchLever;
import net.larsmans.infinitybuttons.block.custom.torch.compat.PropelWallTorchButton;
import net.larsmans.infinitybuttons.block.custom.torch.compat.PropelWallTorchLever;
import net.larsmans.infinitybuttons.item.InfinityButtonsItemGroup;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class NethersDelightBlocks {

    public static AbstractBlock.Properties PROP = AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 12).sound(SoundType.WOOD);

    public static final RegistryObject<Block> HOGLIN_MOUNT_BUTTON = registerBlock(
            () -> new HoglinMountButton(AbstractBlock.Properties.from(Blocks.BROWN_WOOL).setLightLevel((state) -> 1)));

    public static final RegistryObject<Block> PROPELPLANT_TORCH_BUTTON = registerTorchBlock("propelplant_torch_button",
            () -> new PropelTorchButton(PROP));

    public static final RegistryObject<Block> PROPELPLANT_WALL_TORCH_BUTTON = registerTorchBlock("propelplant_wall_torch_button",
            () -> new PropelWallTorchButton(PROP));

    public static final RegistryObject<Block> PROPELPLANT_TORCH_LEVER = registerTorchBlock("propelplant_torch_lever",
            () -> new PropelTorchLever(PROP));

    public static final RegistryObject<Block> PROPELPLANT_WALL_TORCH_LEVER = registerTorchBlock("propelplant_wall_torch_lever",
            () -> new PropelWallTorchLever(PROP));

    /**
     * Methods
     */

    private static <T extends Block> RegistryObject<T> registerBlock(Supplier<T> block) {
        RegistryObject<T> toReturn = InfinityButtonsBlocks.BLOCKS.register("hoglin_mount_button", block);
        registerBlockItem(toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(RegistryObject<T> block) {
        InfinityButtonsItems.ITEMS.register("hoglin_mount_button", () -> new BlockItem(block.get(),
                new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
    }

    private static <T extends Block> RegistryObject<T> registerTorchBlock(String name, Supplier<T> block) {
        return InfinityButtonsBlocks.BLOCKS.register(name, block);
    }

    public static void registerCompatBlocks() {
        InfinityButtons.LOGGER.debug("Registering Nether's Delight Compat Blocks for Infinity Buttons");
    }
}
