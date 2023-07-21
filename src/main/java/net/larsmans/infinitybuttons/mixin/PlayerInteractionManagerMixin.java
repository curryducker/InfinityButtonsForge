package net.larsmans.infinitybuttons.mixin;

import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerInteractionManager.class)
public abstract class PlayerInteractionManagerMixin {

    @Inject(method = "func_219441_a", at = @At("HEAD"), cancellable = true)
    public void func_219441_a(ServerPlayerEntity playerIn, World worldIn, ItemStack stackIn, Hand handIn, BlockRayTraceResult blockRaytraceResultIn, CallbackInfoReturnable<ActionResultType> cir) {
        BlockState state = worldIn.getBlockState(blockRaytraceResultIn.getPos());
        Block block = state.getBlock();
        if (InfinityButtonsUtil.crouchClickOverrides(block)) {
            cir.setReturnValue(block.onBlockActivated(state, worldIn, blockRaytraceResultIn.getPos(), playerIn, handIn, blockRaytraceResultIn));
        }
    }
}