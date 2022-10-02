package net.larsmans.infinitybuttons;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "infinitybuttons")
public class InfinityButtonsConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip()
    public boolean alarmSound = true;
    @ConfigEntry.Gui.Tooltip()
    public boolean tooltips = true;
}
