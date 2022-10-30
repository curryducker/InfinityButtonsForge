package net.larsmans.infinitybuttons.block.custom.torch;

import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class PropelWallTorchLever extends WallTorchLever {
    public PropelWallTorchLever(Properties properties) {
        super(properties, ParticleTypes.FLAME);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
    }
}
