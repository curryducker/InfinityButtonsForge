package net.larsmans.infinitybuttons.block.custom.secretbutton.compat;

import com.teamaurora.enhanced_mushrooms.common.block.IGlowshroomWood;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class GlowshroomBookshelfSecretButton extends CompatBookshelfSecretButton implements IGlowshroomWood{
    public GlowshroomBookshelfSecretButton(Properties properties) {
        super(properties);
    }

    public boolean isSideInvisible(BlockState bs1, BlockState bs2, Direction side) {
        return super.isSideInvisible(bs1, bs2, side) || bs2.getBlock() instanceof IGlowshroomWood;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        if (rand.nextInt(10) == 0) {
            worldIn.addParticle(ParticleTypes.END_ROD, (double)pos.getX() + rand.nextDouble(), (double)pos.getY() + rand.nextDouble(), (double)pos.getZ() + rand.nextDouble(), 0.0, 0.0, 0.0);
        }

    }
}
