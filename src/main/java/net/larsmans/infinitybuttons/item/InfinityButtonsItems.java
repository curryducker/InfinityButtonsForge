package net.larsmans.infinitybuttons.item;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class InfinityButtonsItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, InfinityButtons.MOD_ID);

    /**
     * Torches
     */

    public static final RegistryObject<WallOrFloorItem> TORCH_BUTTON = registerTorch("torch_button", InfinityButtonsBlocks.TORCH_BUTTON.get(), InfinityButtonsBlocks.WALL_TORCH_BUTTON.get());
    public static final RegistryObject<WallOrFloorItem> TORCH_LEVER = registerTorch("torch_lever", InfinityButtonsBlocks.TORCH_LEVER.get(), InfinityButtonsBlocks.WALL_TORCH_LEVER.get());
    public static final RegistryObject<WallOrFloorItem> SOUL_TORCH_BUTTON = registerTorch("soul_torch_button", InfinityButtonsBlocks.SOUL_TORCH_BUTTON.get(), InfinityButtonsBlocks.SOUL_WALL_TORCH_BUTTON.get());
    public static final RegistryObject<WallOrFloorItem> SOUL_TORCH_LEVER = registerTorch("soul_torch_lever", InfinityButtonsBlocks.SOUL_TORCH_LEVER.get(), InfinityButtonsBlocks.SOUL_WALL_TORCH_LEVER.get());
    public static final RegistryObject<WallOrFloorItem> REDSTONE_TORCH_BUTTON = registerTorch("redstone_torch_button", InfinityButtonsBlocks.REDSTONE_TORCH_BUTTON.get(), InfinityButtonsBlocks.REDSTONE_WALL_TORCH_BUTTON.get());
    public static final RegistryObject<WallOrFloorItem> REDSTONE_TORCH_LEVER = registerTorch("redstone_torch_lever", InfinityButtonsBlocks.REDSTONE_TORCH_LEVER.get(), InfinityButtonsBlocks.REDSTONE_WALL_TORCH_LEVER.get());

    /**
     * Methods
     */

    public static RegistryObject<WallOrFloorItem> registerTorch(String name, Block standing, Block wall) {
        return registerItem(name, () -> new WallOrFloorItem(standing, wall, new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
    }

    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
