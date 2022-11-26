package net.larsmans.infinitybuttons.block.custom.torch.compat.bamboo;

import net.larsmans.infinitybuttons.block.custom.torch.compat.PropelWallTorchLever;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BambooWallTorchLever extends PropelWallTorchLever {
    public BambooWallTorchLever(Properties properties) {
        super(properties);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(InfinityButtonsItems.BAMBOO_TORCH_LEVER.get())));
    }
}
