package net.larsmans.infinitybuttons;

import net.larsmans.infinitybuttons.block.ModBlocks;
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
            RenderTypeLookup.setRenderLayer(ModBlocks.TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.TORCH_LEVER.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_TORCH_LEVER.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.REDSTONE_TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.REDSTONE_WALL_TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.REDSTONE_TORCH_LEVER.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.REDSTONE_WALL_TORCH_LEVER.get(), RenderType.getCutout());
            if (ModList.get().isLoaded("endergetic")) {
                RenderTypeLookup.setRenderLayer(ModBlocks.ENDER_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(ModBlocks.ENDER_TORCH_LEVER.get(), RenderType.getCutout());
            }
        });
    }
}

