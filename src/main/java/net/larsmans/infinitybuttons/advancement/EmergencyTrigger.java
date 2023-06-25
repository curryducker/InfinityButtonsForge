package net.larsmans.infinitybuttons.advancement;

import com.google.gson.JsonObject;
import net.larsmans.infinitybuttons.InfinityButtons;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.util.ResourceLocation;

public class EmergencyTrigger extends AbstractCriterionTrigger<EmergencyTrigger.TriggerInstance> {
    private static final ResourceLocation ID = new ResourceLocation(InfinityButtons.MOD_ID, "emergency_button_press");

    @Override
    protected TriggerInstance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
        return new TriggerInstance(entityPredicate);
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    public void trigger(ServerPlayerEntity player) {
        this.triggerListeners(player, TriggerInstance::matches);
    }

    public static class TriggerInstance extends CriterionInstance {

        public TriggerInstance(EntityPredicate.AndPredicate entityPredicate) {
            super(EmergencyTrigger.ID, entityPredicate);
        }

        public boolean matches() {
            return true;
        }
    }
}
