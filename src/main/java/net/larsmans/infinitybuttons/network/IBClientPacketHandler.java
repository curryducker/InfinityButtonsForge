package net.larsmans.infinitybuttons.network;

import me.shedaniel.autoconfig.AutoConfig;
import net.larsmans.infinitybuttons.block.custom.letterbutton.LetterButton;
import net.larsmans.infinitybuttons.block.custom.letterbutton.gui.LetterButtonGui;
import net.larsmans.infinitybuttons.config.AlarmEnum;
import net.larsmans.infinitybuttons.config.InfinityButtonsConfig;
import net.larsmans.infinitybuttons.network.packets.AlarmPacket;
import net.larsmans.infinitybuttons.network.packets.JadePacket;
import net.larsmans.infinitybuttons.network.packets.LetterButtonScreenPacket;
import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class IBClientPacketHandler {

    public static void handleScreenPacket(LetterButtonScreenPacket packet) {
        BlockPos pos = packet.getPos();
        World world = Minecraft.getInstance().world;
        assert world != null;
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof LetterButton) {
            Minecraft.getInstance().displayGuiScreen(new LetterButtonGui((LetterButton) state.getBlock(), state, world, pos));
        }
    }

    public static void handleAlarmPacket(AlarmPacket packet) {
        InfinityButtonsConfig config = AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig();
        if (config.muteAlarmSound) {
            return;
        }
        BlockPos pos = packet.getPos();
        AlarmEnum alarmEnum = packet.getAlarmEnum();
        if (alarmEnum == AlarmEnum.GLOBAL) {
            playGlobalSound(Minecraft.getInstance().world, pos, InfinityButtonsSounds.ALARM.get(), SoundCategory.BLOCKS);
        } else {
            assert Minecraft.getInstance().world != null;
            Minecraft.getInstance().world.playSound(Minecraft.getInstance().player, pos, InfinityButtonsSounds.ALARM.get(), SoundCategory.BLOCKS, (float) config.alarmSoundRange, 1);
        }
    }

    public static void playGlobalSound (World level, BlockPos pos, SoundEvent soundEvent, SoundCategory soundSource) {
        ActiveRenderInfo cam = Minecraft.getInstance().gameRenderer.getActiveRenderInfo();
        Vector3d centerPos = Vector3d.copyCentered(pos);
        if (cam.isValid()) {
            float chunkDistance = (float)cam.getProjectedView().distanceTo(centerPos) / 16.0F;
            level.playSound(centerPos.getX(), centerPos.getY(), centerPos.getZ(), soundEvent, soundSource, chunkDistance * 1.3F + 20F, 1.0F, false);
        }
    }

    public static void handleJadePacket(JadePacket packet) {
        forceHidden = packet.getConfig();
    }

    private static boolean forceHidden = true;

    public static boolean getForceHidden() {
        return forceHidden;
    }
}
