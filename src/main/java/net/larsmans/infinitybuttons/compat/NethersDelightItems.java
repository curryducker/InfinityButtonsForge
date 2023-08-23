package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.larsmans.infinitybuttons.item.InfinityButtonsItemGroup;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.minecraft.item.Item;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

import static net.larsmans.infinitybuttons.item.InfinityButtonsItems.ITEMS;

public class NethersDelightItems {

    public static final RegistryObject<Item> PROPELPLANT_TORCH_BUTTON =
            registerItem("propelplant_torch_button",
                    () -> new WallOrFloorItem(NethersDelightBlocks.PROPELPLANT_TORCH_BUTTON.get(), NethersDelightBlocks.PROPELPLANT_WALL_TORCH_BUTTON.get(),
                            new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
    public static final RegistryObject<Item> PROPELPLANT_TORCH_LEVER =
            registerItem("propelplant_torch_lever",
                    () -> new WallOrFloorItem(NethersDelightBlocks.PROPELPLANT_TORCH_LEVER.get(), NethersDelightBlocks.PROPELPLANT_WALL_TORCH_LEVER.get(),
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
        InfinityButtons.LOGGER.debug("Registering Nether's Delight Compat Items for Infinity Buttons");
    }
}
