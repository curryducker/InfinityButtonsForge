package net.larsmans.infinitybuttons.event;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.particle.InfinityButtonsParticleTypes;
import net.larsmans.infinitybuttons.particle.custom.ScrapeParticle;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InfinityButtons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class InfinityButtonsEventBusEvents {
    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event ) {
        Minecraft.getInstance().particles.registerFactory(InfinityButtonsParticleTypes.SCRAPE.get(), ScrapeParticle.ScrapeProvider::new);
    }
}
