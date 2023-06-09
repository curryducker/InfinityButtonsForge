package net.larsmans.infinitybuttons.block.custom.secretbutton.compat;

import net.larsmans.infinitybuttons.block.custom.secretbutton.AbstractSecretButton;
import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BambooPlankSecretButton extends AbstractSecretButton {
    public BambooPlankSecretButton(Properties properties, Block jadeBlock) {
        super(
                properties,
                VoxelShapes.or(Block.makeCuboidShape(0, 0, 0, 9, 16, 16),
                        Block.makeCuboidShape(9, 0, 3, 13, 16, 16),
                        Block.makeCuboidShape(13, 0, 0, 16, 16, 16)),
                VoxelShapes.or(Block.makeCuboidShape(0, 0, 0, 16, 16, 9),
                        Block.makeCuboidShape(0, 0, 9, 13, 16, 13),
                        Block.makeCuboidShape(0, 0, 13, 16, 16, 16)),
                VoxelShapes.or(Block.makeCuboidShape(0, 0, 0, 3, 16, 16),
                        Block.makeCuboidShape(3, 0, 0, 7, 16, 13),
                        Block.makeCuboidShape(7, 0, 0, 16, 16, 16)),
                VoxelShapes.or(Block.makeCuboidShape(0, 0, 0, 16, 16, 3),
                        Block.makeCuboidShape(3, 0, 3, 16, 16, 7),
                        Block.makeCuboidShape(0, 0, 7, 16, 16, 16)),

                Block.makeCuboidShape(0, 0, 0, 16, 16, 16),
                jadeBlock
        );
    }

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return InfinityButtonsSounds.WOOD_SCRAPE.get();
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(this)));
    }
}
