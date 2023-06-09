package net.larsmans.infinitybuttons.block.custom.secretbutton;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IWorldReader;

public class BookshelfSecretButton extends AbstractSecretButton {
    public BookshelfSecretButton(Properties properties, Block jadeBlock) {
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
        // Credits to anne for suggesting this immensely satisfying sound
        return SoundEvents.BLOCK_BAMBOO_PLACE;
    }

    @Override
    public float getEnchantPowerBonus(BlockState state, IWorldReader world, BlockPos pos) {
        return 1;
    }
}
