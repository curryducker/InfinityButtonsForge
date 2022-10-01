package net.larsmans.infinitybuttons.block.custom.secretbutton;

import net.larsmans.infinitybuttons.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class ChiseledNetherBrickSecretButton extends AbstractSecretButton {
    public ChiseledNetherBrickSecretButton(Properties properties) {
        super(
                properties,
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(13, 3, 0, 16, 13, 16),
                        Block.makeCuboidShape(3, 3, 3, 13, 13, 16),
                        Block.makeCuboidShape(0, 3, 0, 3, 13, 16)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 3, 13, 16, 13, 16),
                        Block.makeCuboidShape(0, 3, 3, 13, 13, 13),
                        Block.makeCuboidShape(0, 3, 0, 16, 13, 3)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 3, 0, 3, 13, 16),
                        Block.makeCuboidShape(3, 3, 0, 13, 13, 13),
                        Block.makeCuboidShape(13, 3, 0, 16, 13, 16)
                ),
                VoxelShapes.or(BOTTOM, TOP,
                        Block.makeCuboidShape(0, 3, 0, 16, 13, 3),
                        Block.makeCuboidShape(3, 3, 3, 16, 13, 13),
                        Block.makeCuboidShape(0, 3, 13, 16, 13, 16)
                ),
                Block.makeCuboidShape(0, 0, 0, 16, 16, 16)
        );
    }

    // The bottom part that never moves
    private static final VoxelShape BOTTOM = Block.makeCuboidShape(0, 0, 0, 16, 3, 16);
    // The top part that never moves
    private static final VoxelShape TOP = Block.makeCuboidShape(0, 13, 0, 16, 16, 16);

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return ModSounds.STONE_SCRAPE.get();
    }
}
