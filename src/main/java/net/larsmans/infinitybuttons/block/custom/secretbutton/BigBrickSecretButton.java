package net.larsmans.infinitybuttons.block.custom.secretbutton;

import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.Block;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class BigBrickSecretButton extends AbstractSecretButton {
    public BigBrickSecretButton(Properties properties, Block jadeBlock) {
        super(
                properties,
                VoxelShapes.or(BASE,
                        Block.makeCuboidShape(0, 8, 3, 16, 16, 19)
                ),
                VoxelShapes.or(BASE,
                        Block.makeCuboidShape(-3, 8, 0, 13, 16, 16)
                ),
                VoxelShapes.or(BASE,
                        Block.makeCuboidShape(0, 8, -3, 16, 16, 13)
                ),
                VoxelShapes.or(BASE,
                        Block.makeCuboidShape(3, 8, 0, 19, 16, 16)
                ),
                Block.makeCuboidShape(0, 0, 0, 16, 16, 16),
                jadeBlock
        );
    }

    // The bottom part that doesn't move
    private static final VoxelShape BASE = Block.makeCuboidShape(0, 0, 0, 16, 8, 16);

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return InfinityButtonsSounds.STONE_SCRAPE.get();
    }
}
