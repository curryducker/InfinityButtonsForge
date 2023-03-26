package net.larsmans.infinitybuttons.block.custom.button;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public abstract class AbstractLeverableButton extends AbstractButton {

    public final boolean lever;

    public AbstractLeverableButton(boolean lever, Properties properties) {
        super(false, properties);
        this.lever = lever;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (lever) {
            if (state.get(PRESSED)) {
                this.unpowerBlock(state, worldIn, pos);
                this.playSound(player, worldIn, pos, false);
            } else {
                this.powerBlock(state, worldIn, pos);
                this.playSound(player, worldIn, pos, true);
            }
        } else {
            if (state.get(PRESSED)) {
                return ActionResultType.CONSUME;
            }
            this.powerBlock(state, worldIn, pos);
            this.playSound(player, worldIn, pos, true);
        }
        return ActionResultType.func_233537_a_(worldIn.isRemote);
    }

    @Override
    public void powerBlock(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(PRESSED, Boolean.TRUE), 3);
        this.updateNeighbors(state, world, pos);
    }

    public void unpowerBlock(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(PRESSED, Boolean.FALSE), 3);
        this.updateNeighbors(state, world, pos);
    }
}
