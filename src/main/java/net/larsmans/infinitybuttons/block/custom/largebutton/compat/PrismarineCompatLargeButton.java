package net.larsmans.infinitybuttons.block.custom.largebutton.compat;

import net.larsmans.infinitybuttons.block.custom.largebutton.PrismarineLargeButton;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrismarineCompatLargeButton extends PrismarineLargeButton {
    public PrismarineCompatLargeButton(Properties properties) {
        super(properties);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(this)));
    }
}
