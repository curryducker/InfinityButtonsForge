package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.item.InfinityButtonsItemGroup;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.minecraft.item.Item;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class NethersDelightItems {

    public static final RegistryObject<Item> PROPELPLANT_TORCH_BUTTON = registerItem("propelplant_torch_button",
            () -> new WallOrFloorItem(NethersDelightBlocks.PROPELPLANT_TORCH_BUTTON.get(), NethersDelightBlocks.PROPELPLANT_WALL_TORCH_BUTTON.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));

    public static final RegistryObject<Item> PROPELPLANT_TORCH_LEVER = registerItem("propelplant_torch_lever",
            () -> new WallOrFloorItem(NethersDelightBlocks.PROPELPLANT_TORCH_LEVER.get(), NethersDelightBlocks.PROPELPLANT_WALL_TORCH_LEVER.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));

    /**
     * Methods
     */

    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item) {
        return InfinityButtonsItems.ITEMS.register(name, item);
    }

    public static void registerCompatItems() {
        InfinityButtons.LOGGER.debug("Registering Nether's Delight Compat Items for Infinity Buttons");
    }
}
