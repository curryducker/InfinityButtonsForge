package net.larsmans.infinitybuttons.block.custom.torch;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class TorchLever extends TorchButton{
    public TorchLever(Properties properties, IParticleData particleData) {
        super(properties, particleData);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(PRESSED, Boolean.FALSE));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (state.get(PRESSED)) {
            this.unpowerBlock(state, worldIn, pos);
            this.playSound(player, worldIn, pos, false);
        } else {
            this.powerBlock(state, worldIn, pos);
            this.playSound(player, worldIn, pos, true);
        }
        return ActionResultType.func_233537_a_(worldIn.isRemote);
    }

    @Override
    public void powerBlock(BlockState state, World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, state.with(PRESSED, Boolean.TRUE), 3);
        this.updateNeighbors(state, worldIn, pos);
    }

    public void unpowerBlock(BlockState state, World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, state.with(PRESSED, Boolean.FALSE), 3);
        this.updateNeighbors(state, worldIn, pos);
    }
}
