package net.larsmans.infinitybuttons.item.custom;

import net.larsmans.infinitybuttons.advancement.InfinityButtonsTriggers;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class SafeEmergencyButtonItem extends BlockItem {
    public SafeEmergencyButtonItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
        return armorType == EquipmentSlotType.HEAD;
    }

    @Nullable
    @Override
    public EquipmentSlotType getEquipmentSlot(ItemStack stack) {
        return EquipmentSlotType.HEAD;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        super.onArmorTick(stack, world, player);
        if (player instanceof ServerPlayerEntity) {
            InfinityButtonsTriggers.SAFETY_TRIGGER.trigger((ServerPlayerEntity) player);
        }
    }
}
