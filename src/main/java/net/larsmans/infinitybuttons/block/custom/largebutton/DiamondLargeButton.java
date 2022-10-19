package net.larsmans.infinitybuttons.block.custom.largebutton;


import me.shedaniel.autoconfig.AutoConfig;
import net.larsmans.infinitybuttons.InfinityButtonsConfig;
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

public class DiamondLargeButton extends AbstractLargeButton {
    InfinityButtonsConfig config = AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig();

    public DiamondLargeButton(Properties properties) {
        super(false, properties);
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
        if (config.diamond_particles) {
            if (random.nextInt(3) == 0) {
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
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (config.tooltips) {
            if(Screen.hasShiftDown()) {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip.diamond_button"));
            } else {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip.hold_shift"));
            }
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
