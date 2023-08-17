package net.larsmans.infinitybuttons.mixin;

import net.larsmans.infinitybuttons.block.custom.LanternButton;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import static net.larsmans.infinitybuttons.InfinityButtonsUtil.checkChains;

@Mixin(ChainBlock.class)
public abstract class ChainBlockMixin extends RotatedPillarBlock implements IWaterLoggable {

    public ChainBlockMixin(Properties properties) {
        super(properties);
    }

    @Override
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return checkAround(blockState, blockAccess, pos) && side == Direction.DOWN ? 15 : 0;
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

    // Update the top chain too if this chain is updated. If this is the top chain, update the redstone power positions
    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        int distance = checkChains(worldIn, pos);
        if (distance > 0) {
            worldIn.neighborChanged(pos.up(distance), this, pos);
        } else {
            worldIn.neighborChanged(pos.up(), this, pos);
            worldIn.notifyNeighborsOfStateExcept(pos.up(), this, Direction.DOWN);
        }

        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
    }

    // Update the redstone power positions if this is the top chain
    @Override
    public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        int distance = checkChains(world, pos);
        if (distance == 0) {
            world.notifyNeighborsOfStateExcept(pos.up(), this, Direction.DOWN);
        }

        super.onReplaced(state, world, pos, newState, moved);
    }
}