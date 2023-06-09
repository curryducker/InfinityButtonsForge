package net.larsmans.infinitybuttons.block.custom.secretbutton;

import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.Block;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class PlankSecretButton extends AbstractSecretButton {
    public PlankSecretButton(Properties properties, Block jadeBlock) {
        super(
                properties,
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 4, 3, 16, 9, 16)),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 4, 0, 13, 9, 16)),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 4, 0, 16, 9, 13)),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(3, 4, 0, 16, 9, 16)),

                Block.makeCuboidShape(0, 0, 0, 16, 16, 16),
                jadeBlock
        );
    }

    // The bottom part that never moves
    private static final VoxelShape BOTTOM = Block.makeCuboidShape(0, 0, 0, 16, 4, 16);
    // The top part that never moves
    private static final VoxelShape TOP = Block.makeCuboidShape(0, 9, 0, 16, 16, 16);

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return InfinityButtonsSounds.WOOD_SCRAPE.get();
    }
}
