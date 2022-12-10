package net.larsmans.infinitybuttons.block.custom.largebutton.compat;

import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class GlowshroomLargeButton extends WoodenCompatLargeButton{
    public GlowshroomLargeButton(Properties properties) {
        super(properties);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(10) == 0) {
            switch (state.get(FACE)) {
                case FLOOR:
                    world.addParticle(ParticleTypes.END_ROD,
                            (double) pos.getX() + 0.1875 + (double) random.nextFloat() * 0.625,
                            (double) pos.getY() + 0.125 + (double) random.nextFloat() * 0.0625,
                            (double) pos.getZ() + 0.1875 + (double) random.nextFloat() * 0.625,
                            0, 0, 0);
                    break;
                case WALL:
                    switch (state.get(HORIZONTAL_FACING)) {
                        case NORTH:
                            world.addParticle(ParticleTypes.END_ROD,
                                    (double) pos.getX() + 0.1875 + (double) random.nextFloat() * 0.625,
                                    (double) pos.getY() + 0.1875 + (double) random.nextFloat() * 0.625,
                                    (double) pos.getZ() + 0.8125 + (double) random.nextFloat() * 0.0625,
                                    0, 0, 0);
                            break;

                        case EAST:
                            world.addParticle(ParticleTypes.END_ROD,
                                    (double) pos.getX() + 0.125 + (double) random.nextFloat() * 0.0625,
                                    (double) pos.getY() + 0.1875 + (double) random.nextFloat() * 0.625,
                                    (double) pos.getZ() + 0.1875 + (double) random.nextFloat() * 0.625,
                                    0, 0, 0);
                            break;

                        case SOUTH:
                            world.addParticle(ParticleTypes.END_ROD,
                                    (double) pos.getX() + 0.1875 + (double) random.nextFloat() * 0.625,
                                    (double) pos.getY() + 0.1875 + (double) random.nextFloat() * 0.625,
                                    (double) pos.getZ() + 0.125 + (double) random.nextFloat() * 0.0625,
                                    0, 0, 0);
                            break;

                        case WEST:
                            world.addParticle(ParticleTypes.END_ROD,
                                    (double) pos.getX() + 0.8125 + (double) random.nextFloat() * 0.0625,
                                    (double) pos.getY() + 0.1875 + (double) random.nextFloat() * 0.625,
                                    (double) pos.getZ() + 0.1875 + (double) random.nextFloat() * 0.625,
                                    0, 0, 0);
                            break;
                    }
                    break;
                case CEILING:
                    world.addParticle(ParticleTypes.END_ROD,
                            (double) pos.getX() + 0.1875 + (double) random.nextFloat() * 0.625,
                            (double) pos.getY() + 0.8125 + (double) random.nextFloat() * 0.0625,
                            (double) pos.getZ() + 0.1875 + (double) random.nextFloat() * 0.625,
                            0, 0, 0);
                    break;
            }
        }
    }
}
