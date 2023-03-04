package net.larsmans.infinitybuttons.block.custom.button;

import net.larsmans.infinitybuttons.block.InfinityButtonsUtil;
import net.larsmans.infinitybuttons.particle.InfinityButtonsParticleTypes;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class DiamondButton extends AbstractButton{

    private final boolean large;

    public DiamondButton(Properties properties, boolean large) {
        super(false, large, properties);
        this.large = large;
    }

    @Override
    public int getActiveDuration() {
        return 20;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return isOn ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
        if (config.diamondParticles && random.nextInt(3) == 0) {
            if (large) {
                switch (state.get(FACE)) {
                    case FLOOR:
                        world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                (double) pos.getX() + 0.1875 + (double) random.nextFloat() * 0.625,
                                (double) pos.getY() + 0.125 + (double) random.nextFloat() * 0.0625,
                                (double) pos.getZ() + 0.1875 + (double) random.nextFloat() * 0.625,
                                0, 0, 0);
                        break;
                    case WALL:
                        switch (state.get(HORIZONTAL_FACING)) {
                            case NORTH:
                                world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                        (double) pos.getX() + 0.1875 + (double) random.nextFloat() * 0.625,
                                        (double) pos.getY() + 0.1875 + (double) random.nextFloat() * 0.625,
                                        (double) pos.getZ() + 0.8125 + (double) random.nextFloat() * 0.0625,
                                        0, 0, 0);
                                break;
                            case EAST:
                                world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                        (double) pos.getX() + 0.125 + (double) random.nextFloat() * 0.0625,
                                        (double) pos.getY() + 0.1875 + (double) random.nextFloat() * 0.625,
                                        (double) pos.getZ() + 0.1875 + (double) random.nextFloat() * 0.625,
                                        0, 0, 0);
                                break;
                            case SOUTH:
                                world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                        (double) pos.getX() + 0.1875 + (double) random.nextFloat() * 0.625,
                                        (double) pos.getY() + 0.1875 + (double) random.nextFloat() * 0.625,
                                        (double) pos.getZ() + 0.125 + (double) random.nextFloat() * 0.0625,
                                        0, 0, 0);
                                break;
                            case WEST:
                                world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                        (double) pos.getX() + 0.8125 + (double) random.nextFloat() * 0.0625,
                                        (double) pos.getY() + 0.1875 + (double) random.nextFloat() * 0.625,
                                        (double) pos.getZ() + 0.1875 + (double) random.nextFloat() * 0.625,
                                        0, 0, 0);
                                break;
                        }
                        break;
                    case CEILING:
                        world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                (double) pos.getX() + 0.1875 + (double) random.nextFloat() * 0.625,
                                (double) pos.getY() + 0.8125 + (double) random.nextFloat() * 0.0625,
                                (double) pos.getZ() + 0.1875 + (double) random.nextFloat() * 0.625,
                                0, 0, 0);
                        break;
                }
            } else {
                switch (state.get(FACE)) {
                    case FLOOR:
                        switch (state.get(HORIZONTAL_FACING)) {
                            case NORTH:
                            case SOUTH:
                                world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                        (double) pos.getX() + 0.25 + (double)random.nextFloat() * 0.5,
                                        (double) pos.getY() + 0.125 + (double) random.nextFloat() * 0.0625,
                                        (double) pos.getZ() + 0.3125 + (double)random.nextFloat() * 0.375,
                                        0, 0, 0);
                                break;
                            case EAST:
                            case WEST:
                                world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                        (double) pos.getX() + 0.3125 + (double)random.nextFloat() * 0.375,
                                        (double) pos.getY() + 0.125 + (double) random.nextFloat() * 0.0625,
                                        (double) pos.getZ() + 0.25 + (double)random.nextFloat() * 0.5,
                                        0, 0, 0);
                                break;
                        }
                        break;
                    case WALL:
                        switch (state.get(HORIZONTAL_FACING)) {
                            case NORTH:
                                world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                        (double)pos.getX() + 0.25 + (double)random.nextFloat() * 0.5,
                                        (double)pos.getY() + 0.3125 + (double)random.nextFloat() * 0.375,
                                        (double)pos.getZ() + 0.8125 + (double)random.nextFloat() * 0.0625,
                                        0, 0, 0);
                                break;
                            case EAST:
                                world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                        (double)pos.getX() + 0.125 + (double)random.nextFloat() * 0.0625,
                                        (double)pos.getY() + 0.3125 + (double)random.nextFloat() * 0.375,
                                        (double)pos.getZ() + 0.25 + (double)random.nextFloat() * 0.5,
                                        0, 0, 0);
                                break;
                            case SOUTH:
                                world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                        (double)pos.getX() + 0.25 + (double)random.nextFloat() * 0.5,
                                        (double)pos.getY() + 0.3125 + (double)random.nextFloat() * 0.375,
                                        (double)pos.getZ() + 0.125 + (double)random.nextFloat() * 0.0625,
                                        0, 0, 0);
                                break;
                            case WEST:
                                world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                        (double)pos.getX() + 0.8125 + (double)random.nextFloat() * 0.0625,
                                        (double)pos.getY() + 0.3125 + (double)random.nextFloat() * 0.375,
                                        (double)pos.getZ() + 0.25 + (double)random.nextFloat() * 0.5,
                                        0, 0, 0);
                                break;
                        }
                        break;
                    case CEILING:
                        switch (state.get(HORIZONTAL_FACING)) {
                            case NORTH:
                            case SOUTH:
                                world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                        (double) pos.getX() + 0.25 + (double) random.nextFloat() * 0.5,
                                        (double) pos.getY() + 0.8125 + (double) random.nextFloat() * 0.0625,
                                        (double) pos.getZ() + 0.3125 + (double) random.nextFloat() * 0.375,
                                        0, 0, 0);
                                break;
                            case EAST:
                            case WEST:
                                world.addParticle(InfinityButtonsParticleTypes.SCRAPE.get(),
                                        (double) pos.getX() + 0.3125 + (double) random.nextFloat() * 0.375,
                                        (double) pos.getY() + 0.8125 + (double) random.nextFloat() * 0.0625,
                                        (double) pos.getZ() + 0.25 + (double) random.nextFloat() * 0.5,
                                        0, 0, 0);
                                break;
                        }
                        break;
                }
            }
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        InfinityButtonsUtil.tooltip(tooltip, "diamond_button");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
