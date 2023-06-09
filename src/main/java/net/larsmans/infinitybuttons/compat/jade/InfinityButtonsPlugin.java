package net.larsmans.infinitybuttons.compat.jade;

import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import mcp.mobius.waila.api.WailaPlugin;
import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.block.custom.HoglinMountButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.AbstractSecretButton;
import net.larsmans.infinitybuttons.block.custom.torch.RedstoneTorchButton;
import net.larsmans.infinitybuttons.block.custom.torch.TorchButton;
import net.minecraft.util.ResourceLocation;

@WailaPlugin
public class InfinityButtonsPlugin implements IWailaPlugin {

    static final ResourceLocation CONFIG_HIDE_SECRET_BUTTONS = new ResourceLocation(InfinityButtons.MOD_ID, "hide_secret_buttons");
    static final ResourceLocation CONFIG_HIDE_TORCH_BUTTONS = new ResourceLocation(InfinityButtons.MOD_ID, "hide_torch_buttons");

    @Override
    public void register(IRegistrar iRegistrar) {
        iRegistrar.addSyncedConfig(CONFIG_HIDE_SECRET_BUTTONS, true);
        iRegistrar.addSyncedConfig(CONFIG_HIDE_TORCH_BUTTONS, true);

        iRegistrar.registerStackProvider(SecretHandler.INSTANCE, AbstractSecretButton.class);
        iRegistrar.registerComponentProvider(SecretHandler.INSTANCE, TooltipPosition.HEAD, AbstractSecretButton.class);
        iRegistrar.registerComponentProvider(SecretHandler.INSTANCE, TooltipPosition.TAIL, AbstractSecretButton.class);

        iRegistrar.registerStackProvider(SecretHandler.INSTANCE, HoglinMountButton.class);
        iRegistrar.registerComponentProvider(SecretHandler.INSTANCE, TooltipPosition.HEAD, HoglinMountButton.class);
        iRegistrar.registerComponentProvider(SecretHandler.INSTANCE, TooltipPosition.TAIL, HoglinMountButton.class);

        iRegistrar.registerStackProvider(SecretHandler.INSTANCE, TorchButton.class);
        iRegistrar.registerComponentProvider(SecretHandler.INSTANCE, TooltipPosition.HEAD, TorchButton.class);
        iRegistrar.registerComponentProvider(SecretHandler.INSTANCE, TooltipPosition.TAIL, TorchButton.class);

        iRegistrar.registerStackProvider(SecretHandler.INSTANCE, RedstoneTorchButton.class);
        iRegistrar.registerComponentProvider(SecretHandler.INSTANCE, TooltipPosition.HEAD, RedstoneTorchButton.class);
        iRegistrar.registerComponentProvider(SecretHandler.INSTANCE, TooltipPosition.TAIL, RedstoneTorchButton.class);
    }
}
