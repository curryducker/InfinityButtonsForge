package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class NethersDelightItems {

    public static final RegistryObject<Item> PROPELPLANT_TORCH_BUTTON =
            InfinityButtonsItems.registerTorch("propelplant_torch_button", NethersDelightBlocks.PROPELPLANT_TORCH_BUTTON, NethersDelightBlocks.PROPELPLANT_WALL_TORCH_BUTTON);
    public static final RegistryObject<Item> PROPELPLANT_TORCH_LEVER =
            InfinityButtonsItems.registerTorch("propelplant_torch_lever", NethersDelightBlocks.PROPELPLANT_TORCH_LEVER, NethersDelightBlocks.PROPELPLANT_WALL_TORCH_LEVER);

    /**
     * Methods
     */

    public static void registerCompatItems() {
        InfinityButtons.LOGGER.debug("Registering Nether's Delight Compat Items for Infinity Buttons");
    }
}
