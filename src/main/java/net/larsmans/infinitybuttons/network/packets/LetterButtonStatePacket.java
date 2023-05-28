package net.larsmans.infinitybuttons.network.packets;

import net.larsmans.infinitybuttons.block.custom.letterbutton.LetterButtonEnum;
import net.minecraft.block.BlockState;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.Objects;
import java.util.function.Supplier;

import static net.larsmans.infinitybuttons.block.custom.letterbutton.LetterButton.CHARACTER;

public class LetterButtonStatePacket {
    private final BlockPos pos;
    private final LetterButtonEnum buttonEnum;

    public LetterButtonStatePacket(BlockPos pos, LetterButtonEnum buttonEnum) {
        this.pos = pos;
        this.buttonEnum = buttonEnum;
    }

    public static void encode(LetterButtonStatePacket packet, PacketBuffer buffer) {
        buffer.writeBlockPos(packet.pos);
        buffer.writeEnumValue(packet.buttonEnum);
    }

    public static LetterButtonStatePacket decode(PacketBuffer buffer) {
        BlockPos pos = buffer.readBlockPos();
        LetterButtonEnum buttonEnum = buffer.readEnumValue(LetterButtonEnum.class);
        return new LetterButtonStatePacket(pos, buttonEnum);
    }

    public static void handle(LetterButtonStatePacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            World world = Objects.requireNonNull(context.getSender()).getServerWorld();
            BlockPos pos = packet.pos;
            BlockState state = world.getBlockState(pos);
            LetterButtonEnum buttonEnum = packet.buttonEnum;
            // Execute the code to update the block state on the server here
            // You can access the packet data using 'world', 'state', 'pos', and 'buttonEnum'
            world.setBlockState(pos, state.with(CHARACTER, buttonEnum), 3);
        });
        context.setPacketHandled(true);
    }
}
