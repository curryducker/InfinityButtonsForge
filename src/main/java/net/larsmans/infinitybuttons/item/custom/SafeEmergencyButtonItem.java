package net.larsmans.infinitybuttons.item.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class SafeEmergencyButtonItem extends BlockItem {
    public SafeEmergencyButtonItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
        return armorType == EquipmentSlotType.HEAD;
    }
}
