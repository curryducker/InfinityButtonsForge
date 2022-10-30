package net.larsmans.infinitybuttons;

import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class InfinityButtonsClient {
    @SubscribeEvent
    public static void onInitializeClient(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.TORCH_LEVER.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.SOUL_TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.SOUL_TORCH_LEVER.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.REDSTONE_TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.REDSTONE_WALL_TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.REDSTONE_TORCH_LEVER.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.REDSTONE_WALL_TORCH_LEVER.get(), RenderType.getCutout());
            if (ModList.get().isLoaded("endergetic")) {
                RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.ENDER_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.ENDER_TORCH_LEVER.get(), RenderType.getCutout());
            }
            if (ModList.get().isLoaded("nethers_delight")) {
                RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.PROPELPLANT_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.PROPELPLANT_TORCH_LEVER.get(), RenderType.getCutout());
            }
        });
    }
}

