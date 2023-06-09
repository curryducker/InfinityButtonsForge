package net.larsmans.infinitybuttons.compat.jade;

import com.google.common.base.Strings;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import mcp.mobius.waila.Waila;
import mcp.mobius.waila.addons.core.HUDHandlerBlocks;
import mcp.mobius.waila.addons.core.PluginCore;
import mcp.mobius.waila.api.IComponentProvider;
import mcp.mobius.waila.api.IDataAccessor;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.ITaggableList;
import mcp.mobius.waila.utils.ModIdentification;
import net.larsmans.infinitybuttons.block.custom.HoglinMountButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.AbstractSecretButton;
import net.larsmans.infinitybuttons.block.custom.torch.RedstoneTorchButton;
import net.larsmans.infinitybuttons.block.custom.torch.TorchButton;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.Property;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.registries.ForgeRegistries;
import snownee.jade.JadePlugin;
import snownee.jade.Renderables;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SecretHandler implements IComponentProvider {

    static final SecretHandler INSTANCE = new SecretHandler();
    private static final Cache<Block, ITextComponent> CACHE = CacheBuilder.newBuilder().build();
    private static Block HOGLIN_MOUNT = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("nethers_delight", "hoglin_mount"));

    @Override
    public ItemStack getStack(IDataAccessor accessor, IPluginConfig config) {
        if (config.get(InfinityButtonsPlugin.CONFIG_HIDE_SECRET_BUTTONS) && accessor.getBlock() instanceof AbstractSecretButton) {
            return new ItemStack(((AbstractSecretButton) accessor.getBlock()).jadeBlock.asItem());
        }

        if (config.get(InfinityButtonsPlugin.CONFIG_HIDE_SECRET_BUTTONS) && accessor.getBlock() instanceof HoglinMountButton) {
            return new ItemStack(HOGLIN_MOUNT);
        }

        if (config.get(InfinityButtonsPlugin.CONFIG_HIDE_TORCH_BUTTONS) && accessor.getBlock() instanceof TorchButton) {
            return new ItemStack(((TorchButton) accessor.getBlock()).jadeBlock.asItem());
        }

        if (config.get(InfinityButtonsPlugin.CONFIG_HIDE_TORCH_BUTTONS) && accessor.getBlock() instanceof RedstoneTorchButton) {
            return new ItemStack(((RedstoneTorchButton) accessor.getBlock()).jadeBlock.asItem());
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void appendHead(List<ITextComponent> tooltip, IDataAccessor accessor, IPluginConfig config) {
        if (config.get(InfinityButtonsPlugin.CONFIG_HIDE_SECRET_BUTTONS) && accessor.getBlock() instanceof AbstractSecretButton) {
            try {
                ITextComponent name = CACHE.get(accessor.getBlock(), () -> new TranslationTextComponent(((AbstractSecretButton) accessor.getBlock()).jadeBlock.getTranslationKey()));
                ((ITaggableList<ResourceLocation, ITextComponent>)tooltip).setTag(HUDHandlerBlocks.OBJECT_NAME_TAG, new StringTextComponent(String.format(Waila.CONFIG.get().getFormatting().getBlockName(), name.getString())));
            } catch (Exception ignored) {
            }

        }

        if (config.get(InfinityButtonsPlugin.CONFIG_HIDE_SECRET_BUTTONS) && accessor.getBlock() instanceof HoglinMountButton) {
            try {
                ITextComponent name = CACHE.get(accessor.getBlock(), () -> new TranslationTextComponent((HOGLIN_MOUNT.getTranslationKey())));
                ((ITaggableList<ResourceLocation, ITextComponent>)tooltip).setTag(HUDHandlerBlocks.OBJECT_NAME_TAG, new StringTextComponent(String.format(Waila.CONFIG.get().getFormatting().getBlockName(), name.getString())));
            } catch (Exception ignored) {
            }

        }

        if (config.get(InfinityButtonsPlugin.CONFIG_HIDE_TORCH_BUTTONS) && accessor.getBlock() instanceof TorchButton) {
            try {
                ITextComponent name = CACHE.get(accessor.getBlock(), () -> new TranslationTextComponent(((TorchButton) accessor.getBlock()).jadeBlock.getTranslationKey()));
                ((ITaggableList<ResourceLocation, ITextComponent>)tooltip).setTag(HUDHandlerBlocks.OBJECT_NAME_TAG, new StringTextComponent(String.format(Waila.CONFIG.get().getFormatting().getBlockName(), name.getString())));
            } catch (Exception ignored) {
            }

        }

        if (config.get(InfinityButtonsPlugin.CONFIG_HIDE_TORCH_BUTTONS) && accessor.getBlock() instanceof RedstoneTorchButton) {
            try {
                ITextComponent name = CACHE.get(accessor.getBlock(), () -> new TranslationTextComponent(((RedstoneTorchButton) accessor.getBlock()).jadeBlock.getTranslationKey()));
                ((ITaggableList<ResourceLocation, ITextComponent>)tooltip).setTag(HUDHandlerBlocks.OBJECT_NAME_TAG, new StringTextComponent(String.format(Waila.CONFIG.get().getFormatting().getBlockName(), name.getString())));
            } catch (Exception ignored) {
            }

        }
    }

    @Override
    public void appendTail(List<ITextComponent> tooltip, IDataAccessor accessor, IPluginConfig config) {
        if (!config.get(JadePlugin.HIDE_MOD_NAME)) {
            if (config.get(InfinityButtonsPlugin.CONFIG_HIDE_SECRET_BUTTONS) && accessor.getBlock() instanceof AbstractSecretButton) {
                String modName = ModIdentification.getModName(((AbstractSecretButton) accessor.getBlock()).jadeBlock);
                if (!Strings.isNullOrEmpty(modName)) {
                    modName = String.format(Waila.CONFIG.get().getFormatting().getModName(), modName);
                    ((ITaggableList<ResourceLocation, ITextComponent>) tooltip).setTag(HUDHandlerBlocks.MOD_NAME_TAG, new StringTextComponent(modName));
                }
            }
        }

        if (!config.get(JadePlugin.HIDE_MOD_NAME)) {
            if (config.get(InfinityButtonsPlugin.CONFIG_HIDE_SECRET_BUTTONS) && accessor.getBlock() instanceof HoglinMountButton) {
                String modName = ModIdentification.getModName(HOGLIN_MOUNT);
                if (!Strings.isNullOrEmpty(modName)) {
                    modName = String.format(Waila.CONFIG.get().getFormatting().getModName(), modName);
                    ((ITaggableList<ResourceLocation, ITextComponent>) tooltip).setTag(HUDHandlerBlocks.MOD_NAME_TAG, new StringTextComponent(modName));
                }
            }
        }

        if (!config.get(JadePlugin.HIDE_MOD_NAME)) {
            if (config.get(InfinityButtonsPlugin.CONFIG_HIDE_TORCH_BUTTONS) && accessor.getBlock() instanceof TorchButton) {
                String modName = ModIdentification.getModName(((TorchButton) accessor.getBlock()).jadeBlock);
                if (!Strings.isNullOrEmpty(modName)) {
                    modName = String.format(Waila.CONFIG.get().getFormatting().getModName(), modName);
                    ((ITaggableList<ResourceLocation, ITextComponent>) tooltip).setTag(HUDHandlerBlocks.MOD_NAME_TAG, new StringTextComponent(modName));
                }
            }
        }

        if (!config.get(JadePlugin.HIDE_MOD_NAME)) {
            if (config.get(InfinityButtonsPlugin.CONFIG_HIDE_TORCH_BUTTONS) && accessor.getBlock() instanceof RedstoneTorchButton) {
                String modName = ModIdentification.getModName(((RedstoneTorchButton) accessor.getBlock()).jadeBlock);
                if (!Strings.isNullOrEmpty(modName)) {
                    modName = String.format(Waila.CONFIG.get().getFormatting().getModName(), modName);
                    ((ITaggableList<ResourceLocation, ITextComponent>) tooltip).setTag(HUDHandlerBlocks.MOD_NAME_TAG, new StringTextComponent(modName));
                }
            }
        }
    }
}
