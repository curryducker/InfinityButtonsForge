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

public class ChiseledEumusBrickSecretButton extends AbstractSecretButton {
    public ChiseledEumusBrickSecretButton(Properties properties) {
        super(
                properties,
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(15, 4, 0, 16, 13, 16),
                        Block.makeCuboidShape(8, 4, 3, 15, 13, 16),
                        Block.makeCuboidShape(0, 4, 0, 8, 13, 16)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 4, 15, 16, 13, 16),
                        Block.makeCuboidShape(0, 4, 8, 13, 13, 15),
                        Block.makeCuboidShape(0, 4, 0, 16, 13, 8)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 4, 0, 1, 13, 16),
                        Block.makeCuboidShape(1, 4, 0, 8, 13, 13),
                        Block.makeCuboidShape(8, 4, 0, 16, 13, 16)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 4, 0, 16, 13, 1),
                        Block.makeCuboidShape(3, 4, 1, 16, 13, 8),
                        Block.makeCuboidShape(0, 4, 8, 16, 13, 16)
                ),


                Block.makeCuboidShape(0, 0, 0, 16, 16, 16)
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
