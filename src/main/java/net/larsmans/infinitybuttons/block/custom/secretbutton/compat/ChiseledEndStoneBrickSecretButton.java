package net.larsmans.infinitybuttons.block.custom.secretbutton.compat;

import net.larsmans.infinitybuttons.block.custom.secretbutton.AbstractSecretButton;
import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChiseledEndStoneBrickSecretButton extends AbstractSecretButton {
    public ChiseledEndStoneBrickSecretButton(Properties properties, Block jadeBlock) {
        super(
                properties,
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 4, 3, 16, 13, 16)),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 4, 0, 13, 13, 16)),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 4, 0, 16, 13, 13)),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(3, 4, 0, 16, 13, 16)),

                Block.makeCuboidShape(0, 0, 0, 16, 16, 16),
                jadeBlock
        );
    }

    // The bottom part that never moves
    private static final VoxelShape BOTTOM = Block.makeCuboidShape(0, 0, 0, 16, 4, 16);
    // The top part that never moves
    private static final VoxelShape TOP = Block.makeCuboidShape(0, 13, 0, 16, 16, 16);

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return InfinityButtonsSounds.STONE_SCRAPE.get();
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(this)));
    }
}
