package net.larsmans.infinitybuttons;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;



@OnlyIn(Dist.CLIENT)
public class InfinityButtonsConfigMenu {
    public static void registerConfigMenu() {
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () -> (client, parent) -> AutoConfig.getConfigScreen(InfinityButtonsConfig.class, parent).get());
    }
}
