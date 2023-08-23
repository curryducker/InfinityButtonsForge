package net.larsmans.infinitybuttons.block.custom.button;

import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class FallingButton extends AbstractSmallButton {

    public boolean gravel;

    public FallingButton(boolean gravel, Properties properties, boolean large) {
        super(false, large, properties);
        this.gravel = gravel;
    }

    @Override
    public int getActiveDuration() {
        return 10;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return gravel ? SoundEvents.BLOCK_GRAVEL_BREAK : SoundEvents.BLOCK_SAND_BREAK;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (state.get(PRESSED)) {
            worldIn.setBlockState(pos, state.with(PRESSED, false), 3);
            this.updateNeighbors(state, worldIn, pos);
            this.playSound(null, worldIn, pos, false);
            worldIn.destroyBlock(pos, false);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        InfinityButtonsUtil.tooltip(tooltip, "falling_button");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
