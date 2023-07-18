package net.larsmans.infinitybuttons.particle;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InfinityButtonsParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, InfinityButtons.MOD_ID);

    public static RegistryObject<BasicParticleType> DIAMOND_SPARKLE = registerParticleType("diamond_sparkle", true);

    private static RegistryObject<BasicParticleType> registerParticleType(String name, boolean alwaysShow) {
        return PARTICLE_TYPES.register(name, () -> new BasicParticleType(alwaysShow));
    }

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
