package net.larsmans.infinitybuttons.network.packets;

import me.shedaniel.autoconfig.AutoConfig;
import net.larsmans.infinitybuttons.config.InfinityButtonsConfig;
import net.larsmans.infinitybuttons.network.IBPacketHandler;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class RequestJadePacket {
    // Minecraft didn't let me send my empty packet so here's a useless boolean
    private final boolean example;

    public RequestJadePacket(boolean example) {
        this.example = example;
    }

    public static void encode(RequestJadePacket packet, PacketBuffer buffer) {
        buffer.writeBoolean(packet.example);
    }

    public static RequestJadePacket decode(PacketBuffer buffer) {
        boolean example = buffer.readBoolean();
        return new RequestJadePacket(example);
    }

    public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> IBPacketHandler.sendToPlayer(new JadePacket(AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig().forceJadeHiding), context.getSender()));
        context.setPacketHandled(true);
    }
}
