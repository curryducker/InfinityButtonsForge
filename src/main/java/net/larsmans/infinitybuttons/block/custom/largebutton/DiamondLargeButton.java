package net.larsmans.infinitybuttons.block.custom.largebutton;


import me.shedaniel.autoconfig.AutoConfig;
import net.larsmans.infinitybuttons.InfinityButtonsConfig;
import net.larsmans.infinitybuttons.block.custom.button.DiamondButton;
import net.larsmans.infinitybuttons.particle.InfinityButtonsParticleTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class DiamondLargeButton extends DiamondButton {
    InfinityButtonsConfig config = AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig();

    public DiamondLargeButton(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return LargeButtonShape.outlineShape(state);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
        if (config.diamondParticles) {
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
}
