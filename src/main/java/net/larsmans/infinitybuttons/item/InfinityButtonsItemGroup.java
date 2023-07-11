package net.larsmans.infinitybuttons.item;

import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.RegistryObject;

public class InfinityButtonsItemGroup extends ItemGroup {

    public static final ItemGroup INFINITYBUTTONS = new InfinityButtonsItemGroup("infinityButtonsTab");

    public InfinityButtonsItemGroup(String infinityButtonsTab) {
        super(infinityButtonsTab);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(InfinityButtonsBlocks.OAK_LARGE_BUTTON.get());
    }

    @Override
    public void fill(NonNullList<ItemStack> items) {
        for(RegistryObject<Item> entry : InfinityButtonsUtil.REGISTRY_FOR_TAB) {
            Item item = entry.get();
            item.fillItemGroup(this, items);
        }
    }
}
