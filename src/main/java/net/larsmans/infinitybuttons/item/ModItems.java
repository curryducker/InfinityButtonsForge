package net.larsmans.infinitybuttons.item;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, InfinityButtons.MOD_ID);

    public static final RegistryObject<Item> REDSTONE_TORCH_BUTTON = ITEMS.register("redstone_torch_button",
            () -> new WallOrFloorItem(ModBlocks.REDSTONE_TORCH_BUTTON.get(), ModBlocks.REDSTONE_WALL_TORCH_BUTTON.get(), new Item.Properties().group(ModItemGroup.INFINITYBUTTONS)));

    public static final RegistryObject<Item> REDSTONE_TORCH_LEVER = ITEMS.register("redstone_torch_lever",
            () -> new WallOrFloorItem(ModBlocks.REDSTONE_TORCH_LEVER.get(), ModBlocks.REDSTONE_WALL_TORCH_LEVER.get(), new Item.Properties().group(ModItemGroup.INFINITYBUTTONS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
