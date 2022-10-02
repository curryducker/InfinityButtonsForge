package net.larsmans.infinitybuttons.item;

import net.larsmans.infinitybuttons.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup INFINITYBUTTONS = new ItemGroup("infinityButtonsTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModBlocks.OAK_LARGE_BUTTON.get());
        }
    };

    public static final ItemGroup INFINITYBUTTONSCOMPAT = new ItemGroup("infinityButtonsCompatTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModBlocks.RED_EMERGENCY_BUTTON.get());
        }
    };

}
