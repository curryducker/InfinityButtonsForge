package net.larsmans.infinitybuttons.mixin;

import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.multiplayer.PlayerController;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.play.client.CPlayerTryUseItemOnBlockPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerController.class)
public abstract class PlayerControllerMixin {

    @Shadow @Final private ClientPlayNetHandler connection;

    @Inject(method = "func_217292_a", at = @At("HEAD"), cancellable = true)
    private void func_217292_a(ClientPlayerEntity player, ClientWorld world, Hand hand, BlockRayTraceResult p_217292_4_, CallbackInfoReturnable<ActionResultType> cir) {
        BlockState state = world.getBlockState(p_217292_4_.getPos());
        Block block = state.getBlock();
        if (InfinityButtonsUtil.crouchClickOverrides(block)) {
            this.connection.sendPacket(new CPlayerTryUseItemOnBlockPacket(hand, p_217292_4_));
            cir.setReturnValue(block.onBlockActivated(state, world, p_217292_4_.getPos(), player, hand, p_217292_4_));
        }
    }
}
