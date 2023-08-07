package net.larsmans.infinitybuttons.network;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.network.packets.*;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class IBPacketHandler {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(InfinityButtons.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "4.0.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(LetterButtonStatePacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(LetterButtonStatePacket::decode)
                .encoder(LetterButtonStatePacket::encode)
                .consumer(LetterButtonStatePacket::handle)
                .add();

        net.messageBuilder(LetterButtonScreenPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(LetterButtonScreenPacket::decode)
                .encoder(LetterButtonScreenPacket::encode)
                .consumer(LetterButtonScreenPacket::handle)
                .add();

        net.messageBuilder(AlarmPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(AlarmPacket::decode)
                .encoder(AlarmPacket::encode)
                .consumer(AlarmPacket::handle)
                .add();

        net.messageBuilder(RequestJadePacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(RequestJadePacket::decode)
                .encoder(RequestJadePacket::encode)
                .consumer(RequestJadePacket::handle)
                .add();

        net.messageBuilder(JadePacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(JadePacket::decode)
                .encoder(JadePacket::encode)
                .consumer(JadePacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayerEntity player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    public static <MSG> void sendToAllPlayers(MSG message) {
        INSTANCE.send(PacketDistributor.ALL.noArg(), message);
    }
}
