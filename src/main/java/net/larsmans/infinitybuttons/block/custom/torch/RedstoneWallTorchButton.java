package net.larsmans.infinitybuttons.block.custom.torch;

import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class RedstoneWallTorchButton extends RedstoneTorchButton {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public RedstoneWallTorchButton(Properties properties, Block jadeBlock) {
        super(properties, jadeBlock);
        this.setDefaultState(this.stateContainer.getBaseState().with(LIT, false).with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return WallTorchBlock.getShapeForState(state);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return Blocks.WALL_TORCH.isValidPosition(state, worldIn, pos);
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return Blocks.WALL_TORCH.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockState = Blocks.WALL_TORCH.getStateForPlacement(context);
        return blockState == null ? null : this.getDefaultState().with(FACING, blockState.get(FACING));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (!stateIn.get(LIT)) {
            return;
        }
        Direction direction = stateIn.get(FACING).getOpposite();
        double d0 = (double)pos.getX() + 0.5D + (rand.nextDouble() - 0.5D) * 0.2D + 0.27D * (double)direction.getXOffset();
        double d1 = (double)pos.getY() + 0.7D + (rand.nextDouble() - 0.5D) * 0.2D + 0.22D;
        double d2 = (double)pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D) * 0.2D + 0.27D * (double)direction.getZOffset();
        worldIn.addParticle(this.particleData, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }

    @Override
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return (blockState.get(LIT) && blockState.get(FACING) != side) ? 15 : 0;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return Blocks.WALL_TORCH.rotate(state, rot);
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return Blocks.WALL_TORCH.mirror(state, mirrorIn);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }
}
