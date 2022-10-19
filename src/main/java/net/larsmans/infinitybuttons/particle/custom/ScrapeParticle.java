package net.larsmans.infinitybuttons.particle.custom;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScrapeParticle extends SpriteTexturedParticle {
    private final IAnimatedSprite sprites;

    protected ScrapeParticle(ClientWorld world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, IAnimatedSprite sprites) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
        this.sprites = sprites;
        this.particleScale *= 0.75F;
        this.canCollide = false;
        this.selectSpriteWithAge(sprites);
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public int getBrightnessForRender(float partialTick) {
        float f = ((float)this.age + partialTick) / (float)this.maxAge;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        int i = super.getBrightnessForRender(partialTick);
        int j = i & 255;
        int k = i >> 16 & 255;
        j += (int)(f * 15.0F * 16.0F);
        if (j > 240) {
            j = 240;
        }

        return j | k << 16;
    }

    public void tick() {
        super.tick();
        this.selectSpriteWithAge(this.sprites);
    }

    private void setParticleSpeed(double pXd, double pYd, double pZd) {
        this.motionX = pXd;
        this.motionY = pYd;
        this.motionZ = pZd;
    }

    @OnlyIn(Dist.CLIENT)
    public static class ScrapeProvider implements IParticleFactory<BasicParticleType> {
        private final double SPEED_FACTOR = 0.01D;
        private final IAnimatedSprite sprite;

        public ScrapeProvider(IAnimatedSprite sprites) {
            this.sprite = sprites;
        }

        public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            ScrapeParticle scrapeParticle = new ScrapeParticle(worldIn, x, y, z, 0.0D, 0.0D, 0.0D, this.sprite);
            if (worldIn.rand.nextBoolean()) {
                scrapeParticle.setColor(0.29F, 0.58F, 0.51F);
            } else {
                scrapeParticle.setColor(0.43F, 0.77F, 0.62F);
            }

            scrapeParticle.setParticleSpeed(xSpeed * 0.01D, ySpeed * 0.01D, zSpeed * 0.01D);
            int i = 10;
            int j = 40;
            scrapeParticle.setMaxAge(worldIn.rand.nextInt(30) + 10);
            return scrapeParticle;
        }
    }
}
