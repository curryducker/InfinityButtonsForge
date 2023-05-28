package net.larsmans.infinitybuttons;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.compat.*;
import net.larsmans.infinitybuttons.config.InfinityButtonsConfig;
import net.larsmans.infinitybuttons.config.InfinityButtonsConfigMenu;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.larsmans.infinitybuttons.network.IBPacketHandler;
import net.larsmans.infinitybuttons.particle.InfinityButtonsParticleTypes;
import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(InfinityButtons.MOD_ID)
public class InfinityButtons
{
    public static final String MOD_ID = "infinitybuttons";

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public InfinityButtons() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        InfinityButtonsItems.register(eventBus);
        InfinityButtonsBlocks.register(eventBus);
        InfinityButtonsSounds.register(eventBus);
        InfinityButtonsParticleTypes.register(eventBus);

        if (ModList.get().isLoaded("nethers_delight")) {
            NethersDelightItems.registerCompatItems();
            NethersDelightBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("quark")){
            QuarkBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("environmental")){
            EnvironmentalBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("endergetic")){
            EndergeticItems.registerCompatItems();
            EndergeticBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("autumnity")){
            AutumnityBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("abundance")){
            AbundanceBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("atmospheric")){
            AtmosphericBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("bamboo_blocks")){
            BambooBlocksItems.registerCompatItems();
            BambooBlocksBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("bayou_blues")){
            BayouBluesBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("enhanced_mushrooms")){
            EnhancedMushroomsBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("upgrade_aquatic")){
            UpgradeAquaticBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("buzzier_bees")){
            BuzzierBeesBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("neapolitan")){
            NeapolitanBlocks.registerCompatBlocks();
        }
        if (ModList.get().isLoaded("savageandravage")){
            SavageAndRavageBlocks.registerCompatBlocks();
        }

        AutoConfig.register(InfinityButtonsConfig.class, Toml4jConfigSerializer::new);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> InfinityButtonsConfigMenu::registerConfigMenu);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        IBPacketHandler.register();
    }
}
