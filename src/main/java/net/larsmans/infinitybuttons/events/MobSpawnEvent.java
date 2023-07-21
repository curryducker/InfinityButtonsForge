package net.larsmans.infinitybuttons.events;

import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.larsmans.infinitybuttons.item.custom.SafeEmergencyButtonItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

import static net.larsmans.infinitybuttons.InfinityButtonsUtil.SAFETY_BUTTONS;

public class MobSpawnEvent {

    @SubscribeEvent
    public static void onMobSpawn(LivingSpawnEvent.SpecialSpawn event) {
        InfinityButtonsUtil.buildSafety();
        MobEntity entity = (MobEntity) event.getEntity();

        if (entity instanceof AbstractSkeletonEntity && !(entity instanceof WitherSkeletonEntity) || entity instanceof ZombieEntity && !(entity instanceof ZombifiedPiglinEntity || entity instanceof DrownedEntity)) {
            Random random = event.getWorld().getRandom();
            double chance = 0.001;

            if (random.nextDouble() < chance) {
                entity.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(SAFETY_BUTTONS.get(random.nextInt(SAFETY_BUTTONS.size()))));
            }
        }
    }

    @SubscribeEvent
    public static void onDeathSpecialEvent(LivingDropsEvent event) {
        LivingEntity entity = (LivingEntity) event.getEntity();
        BlockPos pos = entity.getPosition();

        if (!(entity instanceof ZombieEntity || entity instanceof SkeletonEntity)) {
            return;
        }

        ItemStack stack = entity.getItemStackFromSlot(EquipmentSlotType.HEAD);
        if (stack.getItem() instanceof SafeEmergencyButtonItem) {
            ItemEntity itemEntity1 = new ItemEntity(entity.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), stack);
            // Remove chance
            event.getDrops().removeIf(itemEntity -> itemEntity.getItem().getItem() instanceof SafeEmergencyButtonItem);
            // Drop guaranteed
            event.getDrops().add(itemEntity1);
        }
    }
}
