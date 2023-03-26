package net.larsmans.infinitybuttons;

import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.compat.BambooBlocksBlocks;
import net.larsmans.infinitybuttons.compat.EndergeticBlocks;
import net.larsmans.infinitybuttons.compat.EnhancedMushroomsBlocks;
import net.larsmans.infinitybuttons.compat.NethersDelightBlocks;
import net.minecraft.block.Block;
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
            cutout(InfinityButtonsBlocks.TORCH_BUTTON.get());
            cutout(InfinityButtonsBlocks.WALL_TORCH_BUTTON.get());
            cutout(InfinityButtonsBlocks.TORCH_LEVER.get());
            cutout(InfinityButtonsBlocks.WALL_TORCH_LEVER.get());
            cutout(InfinityButtonsBlocks.SOUL_TORCH_BUTTON.get());
            cutout(InfinityButtonsBlocks.SOUL_WALL_TORCH_BUTTON.get());
            cutout(InfinityButtonsBlocks.SOUL_TORCH_LEVER.get());
            cutout(InfinityButtonsBlocks.SOUL_WALL_TORCH_LEVER.get());
            cutout(InfinityButtonsBlocks.REDSTONE_TORCH_BUTTON.get());
            cutout(InfinityButtonsBlocks.REDSTONE_WALL_TORCH_BUTTON.get());
            cutout(InfinityButtonsBlocks.REDSTONE_TORCH_LEVER.get());
            cutout(InfinityButtonsBlocks.REDSTONE_WALL_TORCH_LEVER.get());
            cutout(InfinityButtonsBlocks.RED_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.ORANGE_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.YELLOW_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.LIME_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.GREEN_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.CYAN_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.LIGHT_BLUE_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.BLUE_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.PURPLE_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.MAGENTA_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.PINK_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.BROWN_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.WHITE_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.LIGHT_GRAY_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.GRAY_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.BLACK_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.FANCY_SAFE_EMERGENCY_BUTTON.get());
            cutout(InfinityButtonsBlocks.SMALL_CONSOLE_BUTTON.get());
            cutout(InfinityButtonsBlocks.SMALL_CONSOLE_LEVER.get());
            cutout(InfinityButtonsBlocks.CONSOLE_BUTTON.get());
            cutout(InfinityButtonsBlocks.CONSOLE_LEVER.get());
            cutout(InfinityButtonsBlocks.LARGE_CONSOLE_BUTTON.get());
            cutout(InfinityButtonsBlocks.LARGE_CONSOLE_LEVER.get());
            cutout(InfinityButtonsBlocks.BIG_CONSOLE_BUTTON.get());
            cutout(InfinityButtonsBlocks.BIG_CONSOLE_LEVER.get());
            if (ModList.get().isLoaded("endergetic")) {
                cutout(EndergeticBlocks.ENDER_TORCH_BUTTON.get());
                cutout(EndergeticBlocks.ENDER_WALL_TORCH_BUTTON.get());
                cutout(EndergeticBlocks.ENDER_TORCH_LEVER.get());
                cutout(EndergeticBlocks.ENDER_WALL_TORCH_LEVER.get());
            }
            if (ModList.get().isLoaded("nethers_delight")) {
                cutout(NethersDelightBlocks.PROPELPLANT_TORCH_BUTTON.get());
                cutout(NethersDelightBlocks.PROPELPLANT_WALL_TORCH_BUTTON.get());
                cutout(NethersDelightBlocks.PROPELPLANT_TORCH_LEVER.get());
                cutout(NethersDelightBlocks.PROPELPLANT_WALL_TORCH_LEVER.get());
            }
            if (ModList.get().isLoaded("bamboo_blocks")) {
                cutout(BambooBlocksBlocks.BAMBOO_TORCH_BUTTON.get());
                cutout(BambooBlocksBlocks.BAMBOO_WALL_TORCH_BUTTON.get());
                cutout(BambooBlocksBlocks.BAMBOO_TORCH_LEVER.get());
                cutout(BambooBlocksBlocks.BAMBOO_WALL_TORCH_LEVER.get());
                cutout(BambooBlocksBlocks.SOUL_BAMBOO_TORCH_BUTTON.get());
                cutout(BambooBlocksBlocks.SOUL_BAMBOO_WALL_TORCH_BUTTON.get());
                cutout(BambooBlocksBlocks.SOUL_BAMBOO_TORCH_LEVER.get());
                cutout(BambooBlocksBlocks.SOUL_BAMBOO_WALL_TORCH_LEVER.get());
                cutout(BambooBlocksBlocks.ENDER_BAMBOO_TORCH_BUTTON.get());
                cutout(BambooBlocksBlocks.ENDER_BAMBOO_WALL_TORCH_BUTTON.get());
                cutout(BambooBlocksBlocks.ENDER_BAMBOO_TORCH_LEVER.get());
                cutout(BambooBlocksBlocks.ENDER_BAMBOO_WALL_TORCH_LEVER.get());
            }
            if (ModList.get().isLoaded("enhanced_mushrooms")) {
                RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_LARGE_BUTTON.get(), RenderType.getTranslucent());
            }
        });
    }

    private static void cutout(Block block) {
        RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
    }
}

