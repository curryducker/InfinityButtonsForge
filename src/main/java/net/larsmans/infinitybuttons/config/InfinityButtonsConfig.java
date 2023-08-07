package net.larsmans.infinitybuttons.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "infinitybuttons")
@Config.Gui.Background("infinitybuttons:textures/block/copper_button.png")
public class InfinityButtonsConfig implements ConfigData {

    public boolean muteAlarmSound = false;

    @ConfigEntry.Gui.Tooltip(count = 6)
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public AlarmEnum alarmSoundType = AlarmEnum.RANGE;

    @ConfigEntry.Gui.Tooltip()
    @ConfigEntry.BoundedDiscrete(min = 1, max = 32)
    public int alarmSoundRange = 6;

    @ConfigEntry.Gui.Tooltip()
    public boolean alarmVillagerPanic = true;

    @ConfigEntry.Gui.Tooltip()
    public boolean tooltips = true;

    @ConfigEntry.Gui.Tooltip()
    public boolean diamondParticles = true;

    @ConfigEntry.Gui.Tooltip(count = 4)
    public boolean forceJadeHiding = true;
}
