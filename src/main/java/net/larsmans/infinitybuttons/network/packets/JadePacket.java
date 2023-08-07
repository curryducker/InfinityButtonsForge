package net.larsmans.infinitybuttons.network.packets;

import net.larsmans.infinitybuttons.network.IBClientPacketHandler;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class JadePacket {
    private final boolean config;

    public JadePacket(boolean config) {
        this.config = config;
    }

    public static void encode(JadePacket packet, PacketBuffer buffer) {
        buffer.writeBoolean(packet.config);
    }

    public boolean getConfig() {
        return config;
    }

    public static JadePacket decode(PacketBuffer buffer) {
        boolean config = buffer.readBoolean();
        return new JadePacket(config);
    }

    public static void handle(JadePacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> IBClientPacketHandler.handleJadePacket(packet)));
        context.setPacketHandled(true);
    }
}
