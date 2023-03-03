package net.larsmans.infinitybuttons.block.custom.emergencybutton;

import me.shedaniel.autoconfig.AutoConfig;
import net.larsmans.infinitybuttons.InfinityButtonsConfig;
import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class SafeEmergencyButton extends HorizontalFaceBlock {
    InfinityButtonsConfig config = AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig();

    public static final EnumProperty<SEBStateEnum> STATE = EnumProperty.create("state", SEBStateEnum.class);

    private static final VoxelShape STONE_DOWN = Block.makeCuboidShape(3, 0, 3, 13, 1, 13);
    private static final VoxelShape STONE_UP = Block.makeCuboidShape(3, 15, 3, 13, 16, 13);
    private static final VoxelShape STONE_NORTH = Block.makeCuboidShape(3, 3, 15, 13, 13, 16);
    private static final VoxelShape STONE_EAST = Block.makeCuboidShape(0, 3, 3, 1, 13, 13);
    private static final VoxelShape STONE_SOUTH = Block.makeCuboidShape(3, 3, 0, 13, 13, 1);
    private static final VoxelShape STONE_WEST = Block.makeCuboidShape(15, 3, 3, 16, 13, 13);

    private static final VoxelShape FLOOR_CLOSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(4, 1, 4, 12, 8, 12), STONE_DOWN);
    private static final VoxelShape FLOOR_OPEN_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 1, 5, 11, 5, 11), STONE_DOWN);
    private static final VoxelShape FLOOR_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 1, 5, 11, 3, 11), STONE_DOWN);
    private static final VoxelShape CEILING_CLOSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(4, 8, 4, 12, 15, 12), STONE_UP);
    private static final VoxelShape CEILING_OPEN_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 11, 5, 11, 15, 11), STONE_UP);
    private static final VoxelShape CEILING_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 13, 5, 11, 15, 11), STONE_UP);
    private static final VoxelShape NORTH_CLOSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(4, 4, 8, 12, 12, 15), STONE_NORTH);
    private static final VoxelShape NORTH_OPEN_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 5, 11, 11, 11, 15), STONE_NORTH);
    private static final VoxelShape NORTH_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 5, 13, 11, 11, 15), STONE_NORTH);
    private static final VoxelShape EAST_CLOSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(1, 4, 4, 8, 12, 12), STONE_EAST);
    private static final VoxelShape EAST_OPEN_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(1, 5, 5, 5, 11, 11), STONE_EAST);
    private static final VoxelShape EAST_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(1, 5, 5, 3, 11, 11), STONE_EAST);
    private static final VoxelShape SOUTH_CLOSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(4, 4, 1, 12, 12, 8), STONE_SOUTH);
    private static final VoxelShape SOUTH_OPEN_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 5, 1, 11, 11, 5), STONE_SOUTH);
    private static final VoxelShape SOUTH_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 5, 1, 11, 11, 3), STONE_SOUTH);
    private static final VoxelShape WEST_CLOSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(8, 4, 4, 15, 12, 12), STONE_WEST);
    private static final VoxelShape WEST_OPEN_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(11, 5, 5, 15, 11, 11), STONE_WEST);
    private static final VoxelShape WEST_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(13, 5, 5, 15, 11, 11), STONE_WEST);

    public SafeEmergencyButton(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(STATE, SEBStateEnum.CLOSED).with(FACE, AttachFace.FLOOR));
    }


    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STATE, HORIZONTAL_FACING, FACE);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction direction = state.get(HORIZONTAL_FACING);
        switch (state.get(FACE)) {
            case FLOOR: {
                switch (state.get(STATE)) {
                    case CLOSED: {
                        return FLOOR_CLOSED_SHAPE;
                    }
                    case OPEN: {
                        return FLOOR_OPEN_SHAPE;
                    }
                    case PRESSED: {
                        return FLOOR_PRESSED_SHAPE;
                    }
                }
                break;
            }
            case CEILING: {
                switch (state.get(STATE)) {
                    case CLOSED: {
                        return CEILING_CLOSED_SHAPE;
                    }
                    case OPEN: {
                        return CEILING_OPEN_SHAPE;
                    }
                    case PRESSED: {
                        return CEILING_PRESSED_SHAPE;
                    }
                }
                break;
            }
            case WALL: {
                switch (direction) {
                    case NORTH: {
                        switch (state.get(STATE)) {
                            case CLOSED: {
                                return NORTH_CLOSED_SHAPE;
                            }
                            case OPEN: {
                                return NORTH_OPEN_SHAPE;
                            }
                            case PRESSED: {
                                return NORTH_PRESSED_SHAPE;
                            }
                        }
                        break;
                    }
                    case EAST: {
                        switch (state.get(STATE)) {
                            case CLOSED: {
                                return EAST_CLOSED_SHAPE;
                            }
                            case OPEN: {
                                return EAST_OPEN_SHAPE;
                            }
                            case PRESSED: {
                                return EAST_PRESSED_SHAPE;
                            }
                        }
                        break;
                    }
                    case SOUTH: {
                        switch (state.get(STATE)) {
                            case CLOSED: {
                                return SOUTH_CLOSED_SHAPE;
                            }
                            case OPEN: {
                                return SOUTH_OPEN_SHAPE;
                            }
                            case PRESSED: {
                                return SOUTH_PRESSED_SHAPE;
                            }
                        }
                        break;
                    }
                    case WEST: {
                        switch (state.get(STATE)) {
                            case CLOSED: {
                                return WEST_CLOSED_SHAPE;
                            }
                            case OPEN: {
                                return WEST_OPEN_SHAPE;
                            }
                            case PRESSED: {
                                return WEST_PRESSED_SHAPE;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        return null;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        switch (state.get(STATE)) {
            case PRESSED: {
                return ActionResultType.CONSUME;
            }
            case OPEN: {
                if (player.isSneaking()) {
                    this.closeCase(state, worldIn, pos);
                    this.playToggleSound(player, worldIn, pos, false);
                } else {
                    this.powerBlock(state, worldIn, pos);
                    this.playClickSound(player, worldIn, pos, true);
                    if (config.alarmSound) {
                        worldIn.playSound(player, pos, InfinityButtonsSounds.ALARM.get(), SoundCategory.BLOCKS, 1, 1);
                    }
                }
                break;
            }
            case CLOSED: {
                if (player.isSneaking()) {
                    this.openCase(state, worldIn, pos);
                    this.playToggleSound(player, worldIn, pos, true);
                } else {
                    player.sendStatusMessage(new TranslationTextComponent("infinitybuttons.actionbar.closed_safety_button"), true);
                    return ActionResultType.CONSUME;
                }
                break;
            }
        }
        return ActionResultType.func_233537_a_(worldIn.isRemote);
    }

    public void openCase(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(STATE, SEBStateEnum.OPEN), 3);
        this.updateNeighbors(state, world, pos);
    }

    public void closeCase(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(STATE, SEBStateEnum.CLOSED), 3);
        this.updateNeighbors(state, world, pos);
    }

    public void powerBlock(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(STATE, SEBStateEnum.PRESSED), 3);
        this.updateNeighbors(state, world, pos);
        world.getPendingBlockTicks().scheduleTick(pos, this, 10);
    }

    protected void playClickSound(@Nullable PlayerEntity playerIn, IWorld worldIn, BlockPos pos, boolean pressed) {
        worldIn.playSound(pressed ? playerIn : null, pos, SoundEvents.BLOCK_BONE_BLOCK_BREAK, SoundCategory.BLOCKS, 1, pressed ? 0.6f : 0.5f);
    }

    protected void playToggleSound(@Nullable PlayerEntity playerIn, IWorld worldIn, BlockPos pos, boolean pressed) {
        worldIn.playSound(pressed ? playerIn : null, pos, pressed ? SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN : SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE, SoundCategory.BLOCKS, 1f, 1);
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean moved) {
        if (moved || state.matchesBlock(newState.getBlock())) {
            return;
        }
        if (state.get(STATE) == SEBStateEnum.PRESSED) {
            this.updateNeighbors(state, worldIn, pos);
        }
        super.onReplaced(state, worldIn, pos, newState, moved);
    }


    @Override
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(STATE) == SEBStateEnum.PRESSED ? 15 : 0;
    }

    @Override
    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        if (blockState.get(STATE) == SEBStateEnum.PRESSED && EmergencyButton.getFacing(blockState) == side) {
            return 15;
        }
        return 0;
    }

    @Override
    public boolean canProvidePower(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if(state.get(STATE) == SEBStateEnum.PRESSED) {
            worldIn.setBlockState(pos, state.with(STATE, SEBStateEnum.OPEN), 3);
            this.updateNeighbors(state, worldIn, pos);
            this.playClickSound(null, worldIn, pos, false);
        }
    }

    private void updateNeighbors(BlockState state, World worldIn, BlockPos pos) {
        worldIn.notifyNeighborsOfStateChange(pos, this);
        worldIn.notifyNeighborsOfStateChange(pos.offset(getFacing(state).getOpposite()), this);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (config.tooltips) {
            if(Screen.hasShiftDown()) {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip.safe_emergency_button"));
            } else {
                tooltip.add(new TranslationTextComponent("infinitybuttons.tooltip.hold_shift"));
            }
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
