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

public class EumusBrickSecretButton extends AbstractSecretButton {
    public EumusBrickSecretButton(Properties properties, Block jadeBlock) {
        super(
                properties,
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(10, 5, 0, 16, 12, 16),
                        Block.makeCuboidShape(0, 5, 3, 10, 12, 16)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 5, 10, 16, 12, 16),
                        Block.makeCuboidShape(0, 5, 0, 13, 12, 10)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 5, 0, 6, 12, 16),
                        Block.makeCuboidShape(6, 5, 0, 16, 12, 13)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 5, 0, 16, 12, 6),
                        Block.makeCuboidShape(3, 5, 6, 16, 12, 16)
                ),
                Block.makeCuboidShape(0, 0, 0, 16, 16, 16),
                jadeBlock
        );
    }

    // The bottom part that never moves
    private static final VoxelShape BOTTOM = Block.makeCuboidShape(0, 0, 0, 16, 5, 16);
    // The top part that never moves
    private static final VoxelShape TOP = Block.makeCuboidShape(0, 12, 0, 16, 16, 16);

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return InfinityButtonsSounds.STONE_SCRAPE.get();
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(this)));
    }
}
