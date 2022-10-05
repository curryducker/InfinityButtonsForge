package net.larsmans.infinitybuttons.block.custom.torch;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class RedstoneTorchLever extends RedstoneTorchButton{
    public RedstoneTorchLever(Properties properties) {
        super(properties);
        this.setDefaultState((BlockState)((BlockState)this.stateContainer.getBaseState()).with(LIT, Boolean.FALSE));
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
        worldIn.setBlockState(pos, (BlockState)state.with(LIT, Boolean.TRUE), 3);
        this.updateNeighbors(state, worldIn, pos);
    }

    public void unpowerBlock(BlockState state, World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, (BlockState)state.with(LIT, Boolean.FALSE), 3);
        this.updateNeighbors(state, worldIn, pos);
    }
}
