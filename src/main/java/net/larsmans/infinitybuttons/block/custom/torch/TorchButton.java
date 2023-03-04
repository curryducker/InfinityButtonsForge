package net.larsmans.infinitybuttons.block.custom.torch;

import net.larsmans.infinitybuttons.block.custom.button.AbstractHorizontalButton;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class TorchButton extends AbstractHorizontalButton {
    protected static final VoxelShape BOUNDING_SHAPE = Block.makeCuboidShape(6.0, 0.0, 6.0, 10.0, 10.0, 10.0);
    protected final IParticleData particle;

    public TorchButton(Properties properties, IParticleData particle) {
        super(properties, BOUNDING_SHAPE, BOUNDING_SHAPE, BOUNDING_SHAPE, BOUNDING_SHAPE, BOUNDING_SHAPE, BOUNDING_SHAPE, BOUNDING_SHAPE, BOUNDING_SHAPE);
        this.particle = particle;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BOUNDING_SHAPE;
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState facingState, IWorld world, BlockPos pos, BlockPos facingPos) {
        return (direction == Direction.DOWN && !this.isValidPosition(state, world, pos)) ? Blocks.AIR.getDefaultState() : state;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        return hasEnoughSolidSide(world, pos.down(), Direction.UP);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        Direction direction = stateIn.get(HORIZONTAL_FACING);
        if (stateIn.get(PRESSED)) {
            double d0 = (double) pos.getX() + 0.5D;
            double d1 = (double) pos.getY() + 0.63D;
            double d2 = (double) pos.getZ() + 0.5D;
            Direction direction2 = direction.getOpposite();
            worldIn.addParticle(ParticleTypes.SMOKE,
                    d0 + 0.23D * (double) direction2.getXOffset(),
                    d1,
                    d2 + 0.23D * (double) direction2.getZOffset(),
                    0.0D, 0.0D, 0.0D);
            worldIn.addParticle(this.particle,
                    d0 + 0.23D * (double) direction2.getXOffset(),
                    d1,
                    d2 + 0.23D * (double) direction2.getZOffset(),
                    0.0D, 0.0D, 0.0D);
        } else {
            super.animateTick(stateIn, worldIn, pos, rand);
        }
    }

    @Override
    public int getPressDuration() {
        return 50;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean pressed) {
        return SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON;
    }

    @Override
    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return (blockState.get(PRESSED) && Direction.DOWN.getOpposite() == side) ? 15 : 0;
    }

    @Override
    public void updateNeighbors(BlockState state, World worldIn, BlockPos pos) {
        worldIn.notifyNeighborsOfStateChange(pos, this);
        worldIn.notifyNeighborsOfStateChange(pos.offset(Direction.DOWN), this);
    }
}
