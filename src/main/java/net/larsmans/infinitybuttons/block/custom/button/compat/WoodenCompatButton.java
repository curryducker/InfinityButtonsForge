package net.larsmans.infinitybuttons.block.custom.button.compat;

import net.larsmans.infinitybuttons.block.custom.button.WoodenButton;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WoodenCompatButton extends WoodenButton {
    public WoodenCompatButton(Properties properties, boolean large) {
        super(properties, large);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(this)));
    }
}
