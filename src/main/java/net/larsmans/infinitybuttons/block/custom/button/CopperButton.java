package net.larsmans.infinitybuttons.block.custom.button;

import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

public class CopperButton extends AbstractButton {
    public CopperButton(Properties properties, boolean large) {
        super(false, large, properties);
    }

    @Override
    protected void playSound(@Nullable PlayerEntity playerIn, IWorld worldIn, BlockPos pos, boolean hitByArrow) {
        worldIn.playSound(hitByArrow ? playerIn : null, pos, this.getSoundEvent(hitByArrow), SoundCategory.BLOCKS, 1F, hitByArrow ? 0.6F : 0.5F);
    }

    @Override
    public int getActiveDuration() {
        return 50;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return InfinityButtonsSounds.BLOCK_COPPER_BREAK.get();
    }
}
