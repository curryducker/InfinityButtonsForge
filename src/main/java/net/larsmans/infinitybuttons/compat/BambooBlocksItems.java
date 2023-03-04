package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.fml.RegistryObject;

public class BambooBlocksItems {

    public static final RegistryObject<WallOrFloorItem> BAMBOO_TORCH_BUTTON =
            InfinityButtonsItems.registerTorch("bamboo_torch_button", BambooBlocksBlocks.BAMBOO_TORCH_BUTTON.get(), BambooBlocksBlocks.BAMBOO_WALL_TORCH_BUTTON.get());
    public static final RegistryObject<WallOrFloorItem> BAMBOO_TORCH_LEVER =
            InfinityButtonsItems.registerTorch("bamboo_torch_lever", BambooBlocksBlocks.BAMBOO_TORCH_LEVER.get(), BambooBlocksBlocks.BAMBOO_WALL_TORCH_LEVER.get());
    public static final RegistryObject<WallOrFloorItem> SOUL_BAMBOO_TORCH_BUTTON =
            InfinityButtonsItems.registerTorch("soul_bamboo_torch_button", BambooBlocksBlocks.SOUL_BAMBOO_TORCH_BUTTON.get(), BambooBlocksBlocks.SOUL_BAMBOO_WALL_TORCH_BUTTON.get());
    public static final RegistryObject<WallOrFloorItem> SOUL_BAMBOO_TORCH_LEVER =
            InfinityButtonsItems.registerTorch("soul_bamboo_torch_lever", BambooBlocksBlocks.SOUL_BAMBOO_TORCH_LEVER.get(), BambooBlocksBlocks.SOUL_BAMBOO_WALL_TORCH_LEVER.get());
    public static final RegistryObject<WallOrFloorItem> ENDER_BAMBOO_TORCH_BUTTON =
            InfinityButtonsItems.registerTorch("ender_bamboo_torch_button", BambooBlocksBlocks.ENDER_BAMBOO_TORCH_BUTTON.get(), BambooBlocksBlocks.ENDER_BAMBOO_WALL_TORCH_BUTTON.get());
    public static final RegistryObject<WallOrFloorItem> ENDER_BAMBOO_TORCH_LEVER =
            InfinityButtonsItems.registerTorch("ender_bamboo_torch_lever", BambooBlocksBlocks.ENDER_BAMBOO_TORCH_LEVER.get(), BambooBlocksBlocks.ENDER_BAMBOO_WALL_TORCH_LEVER.get());
    
    /**
     * Methods
     */

    public static void registerCompatItems() {
        InfinityButtons.LOGGER.debug("Registering Bamboo Blocks Compat Items for Infinity Buttons");
    }
}
