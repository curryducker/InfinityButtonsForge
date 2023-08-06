package net.larsmans.infinitybuttons.network.packets;

import net.larsmans.infinitybuttons.config.AlarmEnum;
import net.larsmans.infinitybuttons.network.IBClientPacketHandler;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class AlarmPacket {
    private final BlockPos pos;
    private final AlarmEnum alarmEnum;

    public AlarmPacket(BlockPos pos, AlarmEnum alarmEnum) {
        this.pos = pos;
        this.alarmEnum = alarmEnum;
    }

    public static void encode(AlarmPacket packet, PacketBuffer buffer) {
        buffer.writeBlockPos(packet.pos);
        buffer.writeEnumValue(packet.alarmEnum);
    }

    public BlockPos getPos() {
        return pos;
    }

    public AlarmEnum getAlarmEnum() {
        return alarmEnum;
    }

    public static AlarmPacket decode(PacketBuffer buffer) {
        BlockPos pos = buffer.readBlockPos();
        AlarmEnum alarmEnum = buffer.readEnumValue(AlarmEnum.class);
        return new AlarmPacket(pos, alarmEnum);
    }

    public static void handle(AlarmPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> IBClientPacketHandler.handleAlarmPacket(packet));
        });
        context.setPacketHandled(true);
    }
}
