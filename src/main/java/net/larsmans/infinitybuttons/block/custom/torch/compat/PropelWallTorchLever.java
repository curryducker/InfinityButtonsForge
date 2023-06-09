package net.larsmans.infinitybuttons.block.custom.torch.compat;

import net.larsmans.infinitybuttons.block.custom.torch.WallTorchLever;
import net.larsmans.infinitybuttons.compat.NethersDelightItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PropelWallTorchLever extends WallTorchLever {
    public PropelWallTorchLever(Properties properties, Block jadeBlock) {
        super(properties, ParticleTypes.FLAME, jadeBlock);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(NethersDelightItems.PROPELPLANT_TORCH_LEVER.get())));
    }
}
