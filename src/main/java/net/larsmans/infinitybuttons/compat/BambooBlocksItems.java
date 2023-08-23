package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.larsmans.infinitybuttons.item.InfinityButtonsItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

import static net.larsmans.infinitybuttons.item.InfinityButtonsItems.ITEMS;

public class BambooBlocksItems {

    public static final RegistryObject<Item> BAMBOO_TORCH_BUTTON =
            registerItem("bamboo_torch_button",
                    () -> new WallOrFloorItem(BambooBlocksBlocks.BAMBOO_TORCH_BUTTON.get(), BambooBlocksBlocks.BAMBOO_WALL_TORCH_BUTTON.get(),
                            new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
    public static final RegistryObject<Item> BAMBOO_TORCH_LEVER =
            registerItem("bamboo_torch_lever",
                    () -> new WallOrFloorItem(BambooBlocksBlocks.BAMBOO_TORCH_LEVER.get(), BambooBlocksBlocks.BAMBOO_WALL_TORCH_LEVER.get(),
                            new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
    public static final RegistryObject<Item> SOUL_BAMBOO_TORCH_BUTTON =
            registerItem("soul_bamboo_torch_button",
                    () -> new WallOrFloorItem(BambooBlocksBlocks.SOUL_BAMBOO_TORCH_BUTTON.get(), BambooBlocksBlocks.SOUL_BAMBOO_WALL_TORCH_BUTTON.get(),
                            new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
    public static final RegistryObject<Item> SOUL_BAMBOO_TORCH_LEVER =
            registerItem("soul_bamboo_torch_lever",
                    () -> new WallOrFloorItem(BambooBlocksBlocks.SOUL_BAMBOO_TORCH_LEVER.get(), BambooBlocksBlocks.SOUL_BAMBOO_WALL_TORCH_LEVER.get(),
                            new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
    public static final RegistryObject<Item> ENDER_BAMBOO_TORCH_BUTTON =
            registerItem("ender_bamboo_torch_button",
                    () -> new WallOrFloorItem(BambooBlocksBlocks.ENDER_BAMBOO_TORCH_BUTTON.get(), BambooBlocksBlocks.ENDER_BAMBOO_WALL_TORCH_BUTTON.get(),
                            new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
    public static final RegistryObject<Item> ENDER_BAMBOO_TORCH_LEVER =
            registerItem("ender_bamboo_torch_lever",
                    () -> new WallOrFloorItem(BambooBlocksBlocks.ENDER_BAMBOO_TORCH_LEVER.get(), BambooBlocksBlocks.ENDER_BAMBOO_WALL_TORCH_LEVER.get(),
                            new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
    
    /**
     * Methods
     */

    private static <T extends Item> RegistryObject<Item> registerItem(String name, Supplier<T> item) {
        RegistryObject<Item> register = ITEMS.register(name, item);
        InfinityButtonsUtil.REGISTRY_FOR_TAB.add(register);
        return register;
    }

    public static void registerCompatItems() {
        InfinityButtons.LOGGER.debug("Registering Bamboo Blocks Compat Items for Infinity Buttons");
    }
}
