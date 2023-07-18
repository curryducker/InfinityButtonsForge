package net.larsmans.infinitybuttons.particle.custom;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DiamondSparkleParticle extends SpriteTexturedParticle {

    protected DiamondSparkleParticle(ClientWorld world, double x, double y, double z, IAnimatedSprite sprites) {
        super(world, x, y, z);
        this.multiplyVelocity(0.96f);
        this.particleScale *= 0.75F;
        this.canCollide = false;
        this.selectSpriteWithAge(sprites);
    }

    @Override
    public void tick() {
        super.tick();
        float fadeInAge = getMaxAge() * 0.2f;
        float fadeOutAge = getMaxAge() * 0.6f;
        if (age <= fadeInAge) {
            setAlphaF(age / fadeInAge);
        } else if (age >= fadeOutAge) {
            setAlphaF(1 - (age - fadeOutAge) / fadeOutAge);
        } else {
            setAlphaF(1);
        }
    }

    @Override
    public int getBrightnessForRender(float partialTick) {
        return 240;
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class DiamondSparkleProvider implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprite;

        public DiamondSparkleProvider(IAnimatedSprite sprites) {
            this.sprite = sprites;
        }

        @Override
        public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            DiamondSparkleParticle glowParticle = new DiamondSparkleParticle(worldIn, x, y, z, this.sprite);
            glowParticle.setMaxAge(worldIn.getRandom().nextInt(30) + 10);
            glowParticle.setAlphaF(0);
            return glowParticle;
        }
    }
}
