package net.larsmans.infinitybuttons.block.custom.button;

import me.shedaniel.autoconfig.AutoConfig;
import net.larsmans.infinitybuttons.InfinityButtonsConfig;
import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;
import java.util.List;

public class PrismarineButton extends AbstractButton {
    InfinityButtonsConfig config = AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig();

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public PrismarineButton(AbstractBlock.Properties properties) {
        super(true, properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(PRESSED, false).with(FACE, AttachFace.FLOOR).with(WATERLOGGED, false));
    }

    @Override
    public int getActiveDuration() {
        return 20;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        return isOn ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, PRESSED, FACE, WATERLOGGED);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        FluidState fluidState = context.getWorld().getFluidState(context.getPos());
        boolean bl = fluidState.getFluid() == Fluids.WATER;
        for (Direction direction : context.getNearestLookingDirections()) {
            BlockState blockState = direction.getAxis() == Direction.Axis.Y ? this.getDefaultState().with(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing()).with(WATERLOGGED, bl) : this.getDefaultState().with(FACE, AttachFace.WALL).with(HORIZONTAL_FACING, direction.getOpposite()).with(WATERLOGGED, bl);
            if (!blockState.isValidPosition(context.getWorld(), context.getPos())) continue;
            return blockState;
        }
        return null;
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState neighborState, IWorld world, BlockPos pos, BlockPos neighborPos) {
        if (HorizontalFaceBlock.getFacing(state).getOpposite() == direction && !state.isValidPosition(world, pos) && !state.get(WATERLOGGED)) {
            return Blocks.AIR.getDefaultState();
        }
        if (state.get(WATERLOGGED)) {
            world.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.updatePostPlacement(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStillFluidState(false);
        }
        return super.getFluidState(state);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (config.tooltips) {
            if(Screen.hasShiftDown()) {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip.prismarine_button"));
            } else {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip.hold_shift"));
            }
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
