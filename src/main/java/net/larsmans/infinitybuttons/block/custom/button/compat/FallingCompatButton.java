package net.larsmans.infinitybuttons.block.custom.button.compat;

import net.larsmans.infinitybuttons.block.custom.button.FallingButton;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FallingCompatButton extends FallingButton {
    public FallingCompatButton(boolean gravel, Properties properties, boolean large) {
        super(gravel, properties, large);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(this)));
    }
}
