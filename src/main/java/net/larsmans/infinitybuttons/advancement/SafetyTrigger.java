package net.larsmans.infinitybuttons.advancement;

import com.google.gson.JsonObject;
import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.item.custom.SafeEmergencyButtonItem;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.util.ResourceLocation;

public class SafetyTrigger extends AbstractCriterionTrigger<SafetyTrigger.TriggerInstance> {
    private static final ResourceLocation ID = new ResourceLocation(InfinityButtons.MOD_ID, "safety_button_head");

    @Override
    protected TriggerInstance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
        return new TriggerInstance(entityPredicate);
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    public void trigger(ServerPlayerEntity player) {
        this.triggerListeners(player, (instance) -> instance.matches(player));
    }

    public static class TriggerInstance extends CriterionInstance {

        public TriggerInstance(EntityPredicate.AndPredicate entityPredicate) {
            super(SafetyTrigger.ID, entityPredicate);
        }

        public boolean matches(ServerPlayerEntity player) {
            return player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() instanceof SafeEmergencyButtonItem;
        }
    }
}
