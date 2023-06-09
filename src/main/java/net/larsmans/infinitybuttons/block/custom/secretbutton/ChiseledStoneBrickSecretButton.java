package net.larsmans.infinitybuttons.block.custom.secretbutton;

import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.Block;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class ChiseledStoneBrickSecretButton extends AbstractSecretButton {
    public ChiseledStoneBrickSecretButton(Properties properties, Block jadeBlock) {
        super(
                properties,
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(14, 3, 0, 16, 14, 16),
                        Block.makeCuboidShape(3, 3, 3, 14, 14, 16),
                        Block.makeCuboidShape(0, 3, 0, 3, 14, 16)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 3, 14, 16, 14, 16),
                        Block.makeCuboidShape(0, 3, 3, 13, 14, 14),
                        Block.makeCuboidShape(0, 3, 0, 16, 14, 3)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 3, 0, 2, 14, 16),
                        Block.makeCuboidShape(2, 3, 0, 13, 14, 13),
                        Block.makeCuboidShape(13, 3, 0, 16, 14, 16)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 3, 0, 16, 14, 2),
                        Block.makeCuboidShape(3, 3, 2, 16, 14, 13),
                        Block.makeCuboidShape(0, 3, 13, 16, 14, 16)
                ),
                Block.makeCuboidShape(0, 0, 0, 16, 16, 16),
                jadeBlock
        );
    }

    // The bottom part that never moves
    private static final VoxelShape BOTTOM = Block.makeCuboidShape(0, 0, 0, 16, 3, 16);
    // The top part that never moves
    private static final VoxelShape TOP = Block.makeCuboidShape(0, 14, 0, 16, 16, 16);

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return InfinityButtonsSounds.STONE_SCRAPE.get();
    }
}
