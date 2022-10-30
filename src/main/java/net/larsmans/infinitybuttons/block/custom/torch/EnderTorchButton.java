package net.larsmans.infinitybuttons.block.custom.torch;

import com.minecraftabnormals.endergetic.client.particles.EEParticles;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class EnderTorchButton extends TorchButton{
    public EnderTorchButton(Properties properties) {
        super(properties, ParticleTypes.FLAME);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        Direction direction = stateIn.get(HORIZONTAL_FACING);
        if (stateIn.get(PRESSED)) {
            double d0 = (double) pos.getX() + 0.5D;
            double d1 = (double) pos.getY() + 0.63D;
            double d2 = (double) pos.getZ() + 0.5D;
            Direction direction2 = direction.getOpposite();
            worldIn.addParticle(ParticleTypes.SMOKE,
                    d0 + 0.23D * (double) direction2.getXOffset(),
                    d1,
                    d2 + 0.23D * (double) direction2.getZOffset(),
                    0.0D, 0.0D, 0.0D);
            worldIn.addParticle(EEParticles.ENDER_FLAME.get(),
                    d0 + 0.23D * (double) direction2.getXOffset(),
                    d1,
                    d2 + 0.23D * (double) direction2.getZOffset(),
                    0.0D, 0.0D, 0.0D);
        } else {
            double d0 = (double)pos.getX() + 0.5D;
            double d1 = (double)pos.getY() + 0.7D;
            double d2 = (double)pos.getZ() + 0.5D;
            worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            worldIn.addParticle(EEParticles.ENDER_FLAME.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
}
