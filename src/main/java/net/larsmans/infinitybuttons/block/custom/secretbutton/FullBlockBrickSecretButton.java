package net.larsmans.infinitybuttons.block.custom.secretbutton;

import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.Block;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.shapes.VoxelShape;

public class FullBlockBrickSecretButton extends AbstractSecretButton {
    public FullBlockBrickSecretButton(Properties properties, Block jadeBlock) {
        super(
                properties,
                FULL,
                FULL,
                FULL,
                FULL,
                FULL,
                jadeBlock
        );
    }

    // Full block because I am too lazy to do the whole voxelshape thing
    private static final VoxelShape FULL = Block.makeCuboidShape(0, 0, 0, 16, 16, 16);

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return InfinityButtonsSounds.STONE_SCRAPE.get();
    }
}
