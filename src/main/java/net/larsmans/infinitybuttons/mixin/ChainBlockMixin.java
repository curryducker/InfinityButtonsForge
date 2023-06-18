package net.larsmans.infinitybuttons.mixin;

import net.larsmans.infinitybuttons.block.custom.LanternButton;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChainBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ChainBlock.class)
public abstract class ChainBlockMixin extends RotatedPillarBlock implements IWaterLoggable {

    public ChainBlockMixin(Properties properties) {
        super(properties);
    }

    @Override
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return checkAround(blockState, blockAccess, pos) ? 15 : 0;
    }

    @Override
    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return checkAround(blockState, blockAccess, pos) && side == Direction.DOWN ? 15 : 0;
    }

    @Override
    public boolean canProvidePower(BlockState state) {
        return true;
    }

    public boolean checkAround(BlockState state, IBlockReader world, BlockPos pos) {
        if (state.get(AXIS) != Direction.Axis.Y || world.getBlockState(pos.up()).getBlock() instanceof ChainBlock) {
            return false;
        }
        int i = 1;
        while (world.getBlockState(pos.down(i)).getBlock() instanceof ChainBlock) {
            if (world.getBlockState(pos.down(i)).get(AXIS) != Direction.Axis.Y) return false;
            i++;
        }
        BlockState blockState = world.getBlockState(pos.down(i));
        if (!(blockState.getBlock() instanceof LanternButton)) {
            return false;
        }
        return blockState.get(LanternButton.PRESSED);
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        world.neighborChanged(pos.up(), this, pos);
        super.onBlockHarvested(world, pos, state, player);
    }
}