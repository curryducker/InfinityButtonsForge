package net.larsmans.infinitybuttons.block.custom.torch;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class RedstoneWallTorchLever extends RedstoneWallTorchButton{
    public RedstoneWallTorchLever(Properties properties, Block jadeBlock) {
        super(properties, jadeBlock);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (state.get(LIT)) {
            this.unpowerBlock(state, worldIn, pos);
            this.playSound(player, worldIn, pos, false);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else {
            this.powerBlock(state, worldIn, pos);
            this.playSound(player, worldIn, pos, true);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        }
    }

    @Override
    public void powerBlock(BlockState state, World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, state.with(LIT, true), 3);
        this.updateNeighbors(state, worldIn, pos);
    }

    public void unpowerBlock(BlockState state, World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, state.with(LIT, false), 3);
        this.updateNeighbors(state, worldIn, pos);
    }
}
