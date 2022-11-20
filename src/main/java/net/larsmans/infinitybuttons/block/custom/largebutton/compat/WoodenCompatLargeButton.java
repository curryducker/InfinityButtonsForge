package net.larsmans.infinitybuttons.block.custom.largebutton.compat;

import net.larsmans.infinitybuttons.block.custom.largebutton.WoodenLargeButton;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WoodenCompatLargeButton extends WoodenLargeButton {
    public WoodenCompatLargeButton(Properties properties) {
        super(properties);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(this)));
    }
}
