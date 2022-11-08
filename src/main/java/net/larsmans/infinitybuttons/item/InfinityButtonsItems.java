package net.larsmans.infinitybuttons.item;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.item.custom.SafeEmergencyButtonItem;
import net.minecraft.item.Item;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class InfinityButtonsItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, InfinityButtons.MOD_ID);

    /**
     * Torches
     */

    public static final RegistryObject<Item> TORCH_BUTTON = registerItem("torch_button",
            () -> new WallOrFloorItem(InfinityButtonsBlocks.TORCH_BUTTON.get(), InfinityButtonsBlocks.WALL_TORCH_BUTTON.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));

    public static final RegistryObject<Item> TORCH_LEVER = registerItem("torch_lever",
            () -> new WallOrFloorItem(InfinityButtonsBlocks.TORCH_LEVER.get(), InfinityButtonsBlocks.WALL_TORCH_LEVER.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));

    public static final RegistryObject<Item> SOUL_TORCH_BUTTON = registerItem("soul_torch_button",
            () -> new WallOrFloorItem(InfinityButtonsBlocks.SOUL_TORCH_BUTTON.get(), InfinityButtonsBlocks.SOUL_WALL_TORCH_BUTTON.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));

    public static final RegistryObject<Item> SOUL_TORCH_LEVER = registerItem("soul_torch_lever",
            () -> new WallOrFloorItem(InfinityButtonsBlocks.SOUL_TORCH_LEVER.get(), InfinityButtonsBlocks.SOUL_WALL_TORCH_LEVER.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));

    public static final RegistryObject<Item> REDSTONE_TORCH_BUTTON = registerItem("redstone_torch_button",
            () -> new WallOrFloorItem(InfinityButtonsBlocks.REDSTONE_TORCH_BUTTON.get(), InfinityButtonsBlocks.REDSTONE_WALL_TORCH_BUTTON.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));

    public static final RegistryObject<Item> REDSTONE_TORCH_LEVER = registerItem("redstone_torch_lever",
            () -> new WallOrFloorItem(InfinityButtonsBlocks.REDSTONE_TORCH_LEVER.get(), InfinityButtonsBlocks.REDSTONE_WALL_TORCH_LEVER.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));

    public static final RegistryObject<Item> ENDER_TORCH_BUTTON = registerCompatItem("endergetic", "ender_torch_button",
            () -> new WallOrFloorItem(InfinityButtonsBlocks.ENDER_TORCH_BUTTON.get(), InfinityButtonsBlocks.ENDER_WALL_TORCH_BUTTON.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONSCOMPAT)));

    public static final RegistryObject<Item> ENDER_TORCH_LEVER = registerCompatItem("endergetic", "ender_torch_lever",
            () -> new WallOrFloorItem(InfinityButtonsBlocks.ENDER_TORCH_LEVER.get(), InfinityButtonsBlocks.ENDER_WALL_TORCH_LEVER.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONSCOMPAT)));

    public static final RegistryObject<Item> PROPELPLANT_TORCH_BUTTON = registerCompatItem("nethers_delight", "propelplant_torch_button",
            () -> new WallOrFloorItem(InfinityButtonsBlocks.PROPELPLANT_TORCH_BUTTON.get(), InfinityButtonsBlocks.PROPELPLANT_WALL_TORCH_BUTTON.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONSCOMPAT)));

    public static final RegistryObject<Item> PROPELPLANT_TORCH_LEVER = registerCompatItem("nethers_delight", "propelplant_torch_lever",
            () -> new WallOrFloorItem(InfinityButtonsBlocks.PROPELPLANT_TORCH_LEVER.get(), InfinityButtonsBlocks.PROPELPLANT_WALL_TORCH_LEVER.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONSCOMPAT)));

    /**
     * Safe Emergency Buttons
     */

    public static final RegistryObject<Item> SAFE_EMERGENCY_BUTTON = registerItem("safe_emergency_button",
            () -> new SafeEmergencyButtonItem(InfinityButtonsBlocks.SAFE_EMERGENCY_BUTTON.get(), new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));

    /**
     * Methods
     */

    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }

    private static <T extends Item> RegistryObject<T> registerCompatItem(String modid, String name, Supplier<T> item) {
        RegistryObject<T> toReturn = null;
        if (ModList.get().isLoaded(modid)) {
            toReturn = ITEMS.register(name, item);
        }
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
