package net.larsmans.infinitybuttons.block.custom.secretbutton;

import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.Block;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class EumusBrickSecretButton extends AbstractSecretButton {
    public EumusBrickSecretButton(Properties properties) {
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
                Block.makeCuboidShape(0, 0, 0, 16, 16, 16)
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
}
