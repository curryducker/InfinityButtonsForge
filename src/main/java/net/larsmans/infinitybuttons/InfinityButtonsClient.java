package net.larsmans.infinitybuttons;

import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.compat.BambooBlocksBlocks;
import net.larsmans.infinitybuttons.compat.EndergeticBlocks;
import net.larsmans.infinitybuttons.compat.EnhancedMushroomsBlocks;
import net.larsmans.infinitybuttons.compat.NethersDelightBlocks;
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
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.WALL_TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.TORCH_LEVER.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.WALL_TORCH_LEVER.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.SOUL_TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.SOUL_WALL_TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.SOUL_TORCH_LEVER.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.SOUL_WALL_TORCH_LEVER.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.REDSTONE_TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.REDSTONE_WALL_TORCH_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.REDSTONE_TORCH_LEVER.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.REDSTONE_WALL_TORCH_LEVER.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.RED_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.ORANGE_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.YELLOW_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.LIME_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.GREEN_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.CYAN_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.LIGHT_BLUE_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.BLUE_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.PURPLE_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.MAGENTA_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.PINK_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.BROWN_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.WHITE_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.LIGHT_GRAY_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.GRAY_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.BLACK_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(InfinityButtonsBlocks.FANCY_SAFE_EMERGENCY_BUTTON.get(), RenderType.getCutout());
            if (ModList.get().isLoaded("endergetic")) {
                RenderTypeLookup.setRenderLayer(EndergeticBlocks.ENDER_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(EndergeticBlocks.ENDER_WALL_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(EndergeticBlocks.ENDER_TORCH_LEVER.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(EndergeticBlocks.ENDER_WALL_TORCH_LEVER.get(), RenderType.getCutout());
            }
            if (ModList.get().isLoaded("nethers_delight")) {
                RenderTypeLookup.setRenderLayer(NethersDelightBlocks.PROPELPLANT_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(NethersDelightBlocks.PROPELPLANT_WALL_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(NethersDelightBlocks.PROPELPLANT_TORCH_LEVER.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(NethersDelightBlocks.PROPELPLANT_WALL_TORCH_LEVER.get(), RenderType.getCutout());
            }
            if (ModList.get().isLoaded("bamboo_blocks")) {
                RenderTypeLookup.setRenderLayer(BambooBlocksBlocks.BAMBOO_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(BambooBlocksBlocks.BAMBOO_WALL_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(BambooBlocksBlocks.BAMBOO_TORCH_LEVER.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(BambooBlocksBlocks.BAMBOO_WALL_TORCH_LEVER.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(BambooBlocksBlocks.SOUL_BAMBOO_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(BambooBlocksBlocks.SOUL_BAMBOO_WALL_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(BambooBlocksBlocks.SOUL_BAMBOO_TORCH_LEVER.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(BambooBlocksBlocks.SOUL_BAMBOO_WALL_TORCH_LEVER.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(BambooBlocksBlocks.ENDER_BAMBOO_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(BambooBlocksBlocks.ENDER_BAMBOO_WALL_TORCH_BUTTON.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(BambooBlocksBlocks.ENDER_BAMBOO_TORCH_LEVER.get(), RenderType.getCutout());
                RenderTypeLookup.setRenderLayer(BambooBlocksBlocks.ENDER_BAMBOO_WALL_TORCH_LEVER.get(), RenderType.getCutout());
            }
            if (ModList.get().isLoaded("enhanced_mushrooms")) {
                RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_LARGE_BUTTON.get(), RenderType.getTranslucent());
            }
        });
    }
}

