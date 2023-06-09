package net.larsmans.infinitybuttons.block.custom.torch.compat.bamboo;

import net.larsmans.infinitybuttons.block.custom.torch.compat.PropelWallTorchButton;
import net.larsmans.infinitybuttons.compat.BambooBlocksItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnderBambooWallTorchButton extends PropelWallTorchButton {
    public EnderBambooWallTorchButton(Properties properties, Block jadeBlock) {
        super(properties, jadeBlock);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(BambooBlocksItems.ENDER_BAMBOO_TORCH_BUTTON.get())));
    }
}
