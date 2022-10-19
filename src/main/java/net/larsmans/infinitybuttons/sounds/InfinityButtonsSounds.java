package net.larsmans.infinitybuttons.sounds;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InfinityButtonsSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, InfinityButtons.MOD_ID);

    public static RegistryObject<SoundEvent> BLOCK_COPPER_BREAK = registerSoundEvent("button.copper.break");
    public static RegistryObject<SoundEvent> BLOCK_COPPER_FALL = registerSoundEvent("button.copper.fall");
    public static RegistryObject<SoundEvent> BLOCK_COPPER_HIT = registerSoundEvent("button.copper.hit");
    public static RegistryObject<SoundEvent> BLOCK_COPPER_PLACE = registerSoundEvent("button.copper.place");
    public static RegistryObject<SoundEvent> BLOCK_COPPER_STEP = registerSoundEvent("button.copper.step");
    public static RegistryObject<SoundEvent> ALARM = registerSoundEvent("alarm");
    public static RegistryObject<SoundEvent> STONE_SCRAPE = registerSoundEvent("stone_scrape");
    public static RegistryObject<SoundEvent> WOOD_SCRAPE = registerSoundEvent("wood_scrape");
    public static RegistryObject<SoundEvent> DOORBELL = registerSoundEvent("doorbell");

    public static final ForgeSoundType COPPER = new ForgeSoundType(1f, 1f, InfinityButtonsSounds.BLOCK_COPPER_BREAK, InfinityButtonsSounds.BLOCK_COPPER_STEP, InfinityButtonsSounds.BLOCK_COPPER_PLACE, InfinityButtonsSounds.BLOCK_COPPER_HIT, InfinityButtonsSounds.BLOCK_COPPER_FALL);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(InfinityButtons.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
