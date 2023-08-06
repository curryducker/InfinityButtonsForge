package net.larsmans.infinitybuttons.network.packets;

import net.larsmans.infinitybuttons.network.IBClientPacketHandler;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class LetterButtonScreenPacket {
    private final BlockPos pos;

    public LetterButtonScreenPacket(BlockPos pos) {
        this.pos = pos;
    }

    public static void encode(LetterButtonScreenPacket packet, PacketBuffer buffer) {
        buffer.writeBlockPos(packet.pos);
    }

    public BlockPos getPos() {
        return pos;
    }

    public static LetterButtonScreenPacket decode(PacketBuffer buffer) {
        BlockPos pos = buffer.readBlockPos();
        return new LetterButtonScreenPacket(pos);
    }

    public static void handle(LetterButtonScreenPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> IBClientPacketHandler.handleScreenPacket(packet));
        });
        context.setPacketHandled(true);
    }
}
