package net.larsmans.infinitybuttons.block.custom.secretbutton;

import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.Block;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class TileSecretButton extends AbstractSecretButton{
    public TileSecretButton(Properties properties, Block jadeBlock) {
        super(
                properties,
                VoxelShapes.or(BASE,
                        Block.makeCuboidShape(0, 8, 0, 8, 16, 16),
                        Block.makeCuboidShape(8, 8, 3, 16, 16, 19)
                ),
                VoxelShapes.or(BASE,
                        Block.makeCuboidShape(0, 8, 0, 16, 16, 8),
                        Block.makeCuboidShape(-3, 8, 8, 13, 16, 16)
                ),
                VoxelShapes.or(BASE,
                        Block.makeCuboidShape(8, 8, 0, 16, 16, 16),
                        Block.makeCuboidShape(0, 8, -3, 8, 16, 13)
                ),
                VoxelShapes.or(BASE,
                        Block.makeCuboidShape(0, 8, 8, 16, 16, 16),
                        Block.makeCuboidShape(3, 8, 0, 19, 16, 8)
                ),
                Block.makeCuboidShape(0, 0, 0, 16, 16, 16),
                jadeBlock
        );
    }

    private static final VoxelShape BASE = Block.makeCuboidShape(0, 0, 0, 16, 8, 16);


    @Override
    protected SoundEvent getSoundEvent(boolean pressed) {
        return InfinityButtonsSounds.STONE_SCRAPE.get();
    }
}
