package net.larsmans.infinitybuttons.block.custom.button;

import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.larsmans.infinitybuttons.particle.InfinityButtonsParticleTypes;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class DiamondButton extends AbstractSmallButton {

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
                        addParticle(3, 10, 2, 1, 3, 10, world, pos, random);
                        break;
                    case WALL:
                        switch (state.get(HORIZONTAL_FACING)) {
                            case NORTH :
                                    addParticle(3, 10, 3, 10, 13, 1, world, pos, random);
                                    break;
                            case EAST :
                                    addParticle(2, 1, 3, 10, 3, 10, world, pos, random);
                                    break;
                            case SOUTH :
                                    addParticle(3, 10, 3, 10, 2, 1, world, pos, random);
                                    break;
                            case WEST :
                                    addParticle(13, 1, 3, 10, 3, 10, world, pos, random);
                                    break;
                        }
                        break;
                    case CEILING:
                        addParticle(3, 10, 13, 1, 3, 10, world, pos, random);
                        break;
                }
            } else {
                switch (state.get(FACE)) {
                    case FLOOR:
                        switch (state.get(HORIZONTAL_FACING)) {
                            case NORTH:
                            case SOUTH:
                                addParticle(4, 8, 2, 1, 5, 6, world, pos, random);
                                break;
                            case EAST:
                            case WEST:
                                addParticle(5, 6, 2, 1, 4, 8, world, pos, random);
                                break;
                        }
                        break;
                    case WALL:
                        switch (state.get(HORIZONTAL_FACING)) {
                            case NORTH:
                                addParticle(4, 8, 5, 6, 13, 1, world, pos, random);
                                break;
                            case EAST:
                                addParticle(2, 1, 5, 6, 4, 8, world, pos, random);
                                break;
                            case SOUTH:
                                addParticle(4, 8, 5, 6, 2, 1, world, pos, random);
                                break;
                            case WEST:
                                addParticle(13, 1, 5, 6, 4, 8, world, pos, random);
                                break;
                        }
                        break;
                    case CEILING:
                        switch (state.get(HORIZONTAL_FACING)) {
                            case NORTH:
                            case SOUTH:
                                addParticle(4, 8, 13, 1, 5, 6, world, pos, random);
                                break;
                            case EAST:
                            case WEST:
                                addParticle(5, 6, 13, 1, 4, 8, world, pos, random);
                                break;
                        }
                        break;
                }
            }
        }
    }

    public void addParticle(int x1, int x2, int y1, int y2, int z1, int z2, World world, BlockPos pos, Random random) {
        world.addParticle(InfinityButtonsParticleTypes.DIAMOND_SPARKLE.get(),
                pos.getX() + (double) x1 / 16 + random.nextFloat() * (double) x2 / 16,
                pos.getY() + (double) y1 / 16 + random.nextFloat() * (double) y2 / 16,
                pos.getZ() + (double) z1 / 16 + random.nextFloat() * (double) z2 / 16,
                0, 0, 0);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        InfinityButtonsUtil.tooltip(tooltip, "diamond_button");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
