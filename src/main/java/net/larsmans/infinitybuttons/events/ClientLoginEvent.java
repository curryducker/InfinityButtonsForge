package net.larsmans.infinitybuttons.events;

import net.larsmans.infinitybuttons.network.IBPacketHandler;
import net.larsmans.infinitybuttons.network.packets.RequestJadePacket;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientLoginEvent {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onClientPlayerLogin(ClientPlayerNetworkEvent.LoggedInEvent event) {
        IBPacketHandler.sendToServer(new RequestJadePacket(true));
    }
}
