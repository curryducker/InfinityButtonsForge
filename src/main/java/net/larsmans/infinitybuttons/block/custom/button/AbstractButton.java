package net.larsmans.infinitybuttons.block.custom.button;

import me.shedaniel.autoconfig.AutoConfig;
import net.larsmans.infinitybuttons.config.InfinityButtonsConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public abstract class AbstractButton extends HorizontalFaceBlock {
    protected static InfinityButtonsConfig config = AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig();
    public static final BooleanProperty PRESSED = BooleanProperty.create("pressed");

    protected final boolean projectile;

    protected AbstractButton(boolean projectile, Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(PRESSED, false).with(FACE, AttachFace.FLOOR));
        this.projectile = projectile;
    }

    public abstract int getActiveDuration();

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (state.get(PRESSED)) {
            return ActionResultType.CONSUME;
        } else {
            this.powerBlock(state, worldIn, pos);
            this.playSound(player, worldIn, pos, true);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        }
    }

    public void powerBlock(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(PRESSED, true), 3);
        this.updateNeighbors(state, world, pos);
        world.getPendingBlockTicks().scheduleTick(pos, this, this.getActiveDuration());
    }

    protected void playSound(@Nullable PlayerEntity playerIn, IWorld worldIn, BlockPos pos, boolean pressed) {
        worldIn.playSound(pressed ? playerIn : null, pos, this.getSoundEvent(pressed), SoundCategory.BLOCKS, 0.3F, pressed ? 0.6F : 0.5F);
    }

    protected abstract SoundEvent getSoundEvent(boolean pressed);

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!isMoving && !state.matchesBlock(newState.getBlock())) {
            if (state.get(PRESSED)) {
                this.updateNeighbors(state, worldIn, pos);
            }

            super.onReplaced(state, worldIn, pos, newState, isMoving);
        }
    }

    @Override
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(PRESSED) ? 15 : 0;
    }

    @Override
    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(PRESSED) && getFacing(blockState) == side ? 15 : 0;
    }

    @Override
    public boolean canProvidePower(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (state.get(PRESSED)) {
            if (this.projectile) {
                this.checkPressed(state, worldIn, pos);
            } else {
                worldIn.setBlockState(pos, state.with(PRESSED, false), 3);
                this.updateNeighbors(state, worldIn, pos);
                this.playSound(null, worldIn, pos, false);
            }

        }
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.isRemote && this.projectile && !state.get(PRESSED)) {
            this.checkPressed(state, worldIn, pos);
        }
    }

    private void checkPressed(BlockState state, World worldIn, BlockPos pos) {
        List<? extends Entity> list = worldIn.getEntitiesWithinAABB(AbstractArrowEntity.class, state.getShape(worldIn, pos).getBoundingBox().offset(pos));
        boolean flag = !list.isEmpty();
        boolean flag1 = state.get(PRESSED);
        if (flag != flag1) {
            worldIn.setBlockState(pos, state.with(PRESSED, flag), 3);
            this.updateNeighbors(state, worldIn, pos);
            this.playSound(null, worldIn, pos, flag);
        }

        if (flag) {
            worldIn.getPendingBlockTicks().scheduleTick(new BlockPos(pos), this, this.getActiveDuration());
        }

    }

    @Override
    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public void updateNeighbors(BlockState state, World worldIn, BlockPos pos) {
        worldIn.notifyNeighborsOfStateChange(pos, this);
        worldIn.notifyNeighborsOfStateChange(pos.offset(getFacing(state).getOpposite()), this);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, PRESSED, FACE);
    }
}
