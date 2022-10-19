package net.larsmans.infinitybuttons.block.custom.secretbutton;

import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.Block;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class DeepslateTileSecretButton extends AbstractSecretButton {
    public DeepslateTileSecretButton(Properties properties) {
        super(
                properties,
                VoxelShapes.or(BASE,
                        Block.makeCuboidShape(13, 10, 0, 16, 16, 16),
                        Block.makeCuboidShape(0, 10, 3, 13, 16, 19)
                ),
                VoxelShapes.or(BASE,
                        Block.makeCuboidShape(0, 10, 13, 16, 16, 16),
                        Block.makeCuboidShape(-3, 10, 0, 13, 16, 13)
                ),
                VoxelShapes.or(BASE,
                        Block.makeCuboidShape(0, 10, 0, 3, 16, 16),
                        Block.makeCuboidShape(3, 10, -3, 16, 16, 13)
                ),
                VoxelShapes.or(BASE,
                        Block.makeCuboidShape(0, 10, 0, 16, 16, 3),
                        Block.makeCuboidShape(3, 10, 3, 19, 16, 16)
                ),
                Block.makeCuboidShape(0, 0, 0, 16, 16, 16)
        );
    }

    // The bottom part that never moves
    private static final VoxelShape BASE = Block.makeCuboidShape(0, 0, 0, 16, 10, 16);

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return InfinityButtonsSounds.STONE_SCRAPE.get();
    }
}
