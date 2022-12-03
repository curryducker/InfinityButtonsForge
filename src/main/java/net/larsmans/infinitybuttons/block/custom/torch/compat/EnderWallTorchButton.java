package net.larsmans.infinitybuttons.block.custom.torch.compat;

import com.minecraftabnormals.endergetic.client.particles.EEParticles;
import net.larsmans.infinitybuttons.block.custom.torch.WallTorchButton;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EnderWallTorchButton extends WallTorchButton {
    public EnderWallTorchButton(Properties properties) {
        super(properties, ParticleTypes.FLAME);
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        Direction direction = stateIn.get(HORIZONTAL_FACING);
        if (stateIn.get(PRESSED)) {
            double d0 = (double) pos.getX() + 0.5D;
            double d1 = (double) pos.getY() + 0.6D;
            double d2 = (double) pos.getZ() + 0.5D;
            Direction direction2 = direction.getOpposite();
            worldIn.addParticle(ParticleTypes.SMOKE,
                    d0 + 0.05D * (double) direction2.getXOffset(),
                    d1 + 0.15D,
                    d2 + 0.05D * (double) direction2.getZOffset(),
                    0.0D, 0.0D, 0.0D);
            worldIn.addParticle(EEParticles.ENDER_FLAME.get(),
                    d0 + 0.05D * (double) direction2.getXOffset(),
                    d1 + 0.15D,
                    d2 + 0.05D * (double) direction2.getZOffset(),
                    0.0D, 0.0D, 0.0D);
        } else {
            double d0 = (double) pos.getX() + 0.5D;
            double d1 = (double) pos.getY() + 0.7D;
            double d2 = (double) pos.getZ() + 0.5D;
            Direction direction1 = direction.getOpposite();
            worldIn.addParticle(ParticleTypes.SMOKE,
                    d0 + 0.27D * (double) direction1.getXOffset(),
                    d1 + 0.22D, d2 + 0.27D * (double) direction1.getZOffset(),
                    0.0D, 0.0D, 0.0D);
            worldIn.addParticle(EEParticles.ENDER_FLAME.get(),
                    d0 + 0.27D * (double) direction1.getXOffset(),
                    d1 + 0.22D, d2 + 0.27D * (double) direction1.getZOffset(),
                    0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return new ArrayList<>(Collections.singleton(new ItemStack(InfinityButtonsItems.ENDER_TORCH_BUTTON.get())));
    }
}