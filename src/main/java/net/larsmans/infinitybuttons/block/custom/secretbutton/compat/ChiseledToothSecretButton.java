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

public class ChiseledToothSecretButton extends AbstractSecretButton {
    public ChiseledToothSecretButton(Properties properties) {
        super(
                properties,
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 1, 0, 1, 15, 16),
                        Block.makeCuboidShape(1, 1, 3, 15, 15, 16),
                        Block.makeCuboidShape(15, 1, 0, 16, 15, 16)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 1, 0, 16, 15, 1),
                        Block.makeCuboidShape(0, 1, 1, 13, 15, 15),
                        Block.makeCuboidShape(0, 1, 15, 16, 15, 16)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 1, 0, 1, 15, 16),
                        Block.makeCuboidShape(1, 1, 0, 15, 15, 13),
                        Block.makeCuboidShape(15, 1, 0, 16, 15, 16)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 1, 0, 16, 15, 1),
                        Block.makeCuboidShape(3, 1, 1, 16, 15, 15),
                        Block.makeCuboidShape(0, 1, 15, 16, 15, 16)
                ),
                Block.makeCuboidShape(0, 0, 0, 16, 16, 16)
        );
    }

    // The bottom part that never moves
    private static final VoxelShape BOTTOM = Block.makeCuboidShape(0, 0, 0, 16, 1, 16);
    // The top part that never moves
    private static final VoxelShape TOP = Block.makeCuboidShape(0, 15, 0, 16, 16, 16);

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return InfinityButtonsSounds.STONE_SCRAPE.get();
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(this)));
    }
}
