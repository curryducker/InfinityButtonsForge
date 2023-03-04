package net.larsmans.infinitybuttons.block.custom;

import net.larsmans.infinitybuttons.block.InfinityButtonsUtil;
import net.larsmans.infinitybuttons.block.custom.button.AbstractWallButton;
import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class DoorbellButton extends AbstractWallButton {

    protected static final VoxelShape NORTH_PRESSED_SHAPE =
            Block.makeCuboidShape(6, 4, 14, 10, 12, 16);

    protected static final VoxelShape EAST_PRESSED_SHAPE =
            Block.makeCuboidShape(0, 4, 6, 2, 12, 10);

    protected static final VoxelShape SOUTH_PRESSED_SHAPE =
            Block.makeCuboidShape(6, 4, 0, 10, 12, 2);

    protected static final VoxelShape WEST_PRESSED_SHAPE =
            Block.makeCuboidShape(14, 4, 6, 16, 12, 10);

    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.or(NORTH_PRESSED_SHAPE,
            Block.makeCuboidShape(7, 6, 13, 9, 10, 14));

    protected static final VoxelShape EAST_SHAPE = VoxelShapes.or(EAST_PRESSED_SHAPE,
            Block.makeCuboidShape(2, 6, 7, 3, 10, 9));

    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.or(SOUTH_PRESSED_SHAPE,
            Block.makeCuboidShape(7, 6, 2, 9, 10, 3));

    protected static final VoxelShape WEST_SHAPE = VoxelShapes.or(WEST_PRESSED_SHAPE,
            Block.makeCuboidShape(13, 6, 7, 14, 10, 9));

    public DoorbellButton(Properties properties) {
        super(properties, NORTH_SHAPE, EAST_SHAPE, SOUTH_SHAPE, WEST_SHAPE, NORTH_PRESSED_SHAPE, EAST_PRESSED_SHAPE, SOUTH_PRESSED_SHAPE, WEST_PRESSED_SHAPE);
    }

    @Override
    public int getPressDuration() {
        return 15;
    }

    @Override
    protected void playSound(@Nullable PlayerEntity playerIn, IWorld worldIn, BlockPos pos, boolean hitByArrow) {
        worldIn.playSound(hitByArrow ? playerIn : null, pos, InfinityButtonsSounds.DOORBELL.get(), SoundCategory.BLOCKS, 0.3F, 1f);
    }

    @Override
    protected SoundEvent getSoundEvent(boolean pressed) {
        return InfinityButtonsSounds.DOORBELL.get();
    }

    @Override
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        if (state.get(PRESSED)) {
            world.setBlockState(pos, state.with(PRESSED, false), 3);
            this.updateNeighbors(state, world, pos);
        }
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState facingState, IWorld world, BlockPos pos, BlockPos facingPos) {
        if (direction.getOpposite() == state.get(HORIZONTAL_FACING) && !state.isValidPosition(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return state;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        InfinityButtonsUtil.tooltip(tooltip, "doorbell_button");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
