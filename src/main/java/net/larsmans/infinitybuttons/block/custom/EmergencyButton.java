package net.larsmans.infinitybuttons.block.custom;

import me.shedaniel.autoconfig.AutoConfig;
import net.larsmans.infinitybuttons.InfinityButtonsConfig;
import net.larsmans.infinitybuttons.sounds.ModSounds;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class EmergencyButton extends HorizontalFaceBlock {
    InfinityButtonsConfig config = AutoConfig.getConfigHolder(InfinityButtonsConfig.class).getConfig();

    public static final BooleanProperty PRESSED = BooleanProperty.create("pressed");
    
    private static final VoxelShape STONE_DOWN  = Block.makeCuboidShape(4, 0, 4, 12, 1, 12);
    private static final VoxelShape STONE_UP    = Block.makeCuboidShape(4, 15, 4, 12, 16, 12);
    private static final VoxelShape STONE_NORTH = Block.makeCuboidShape(4, 4, 15, 12, 12, 16);
    private static final VoxelShape STONE_EAST  = Block.makeCuboidShape(0, 4, 4, 1, 12, 12);
    private static final VoxelShape STONE_SOUTH = Block.makeCuboidShape(4, 4, 0, 12, 12, 1);
    private static final VoxelShape STONE_WEST  = Block.makeCuboidShape(15, 4, 4, 16, 12, 12);

    private static final VoxelShape FLOOR_X_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 1, 5, 11, 5, 11), STONE_DOWN).simplify();
    private static final VoxelShape FLOOR_Z_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 1, 5, 11, 5, 11), STONE_DOWN).simplify();
    private static final VoxelShape FLOOR_X_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 1, 5, 11, 3, 11), STONE_DOWN).simplify();
    private static final VoxelShape FLOOR_Z_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 1, 5, 11, 3, 11), STONE_DOWN).simplify();
    private static final VoxelShape NORTH_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 5, 11, 11, 11, 15), STONE_NORTH).simplify();
    private static final VoxelShape NORTH_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 5, 13, 11, 11, 15), STONE_NORTH).simplify();
    private static final VoxelShape EAST_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(1, 5, 5, 5, 11, 11), STONE_EAST).simplify();
    private static final VoxelShape EAST_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(1, 5, 5, 3, 11, 11), STONE_EAST).simplify();
    private static final VoxelShape SOUTH_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 5, 1, 11, 11, 5), STONE_SOUTH).simplify();
    private static final VoxelShape SOUTH_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 5, 1, 11, 11, 3), STONE_SOUTH).simplify();
    private static final VoxelShape WEST_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(11, 5, 5, 15, 11, 11), STONE_WEST).simplify();
    private static final VoxelShape WEST_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(13, 5, 5, 15, 11, 11), STONE_WEST).simplify();
    private static final VoxelShape CEILING_X_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 11, 5, 11, 15, 11), STONE_UP).simplify();
    private static final VoxelShape CEILING_Z_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 11, 5, 11, 15, 11), STONE_UP).simplify();
    private static final VoxelShape CEILING_X_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 13, 5, 11, 15, 11), STONE_UP).simplify();
    private static final VoxelShape CEILING_Z_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 13, 5, 11, 15, 11), STONE_UP).simplify();

    protected int getActiveDuration(){
        return 10;
    };

    public EmergencyButton(AbstractBlock.Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(PRESSED, Boolean.FALSE).with(FACE, AttachFace.WALL));
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction direction = state.get(HORIZONTAL_FACING);
        boolean flag = state.get(PRESSED);
        switch((AttachFace)state.get(FACE)) {
            case FLOOR:
                if (direction.getAxis() == Direction.Axis.X) {
                    return flag ? FLOOR_X_PRESSED_SHAPE : FLOOR_X_SHAPE;
                }

                return flag ? FLOOR_Z_PRESSED_SHAPE : FLOOR_Z_SHAPE;
            case WALL:
                switch(direction) {
                    case EAST:
                        return flag ? EAST_PRESSED_SHAPE : EAST_SHAPE;
                    case WEST:
                        return flag ? WEST_PRESSED_SHAPE : WEST_SHAPE;
                    case SOUTH:
                        return flag ? SOUTH_PRESSED_SHAPE : SOUTH_SHAPE;
                    case NORTH:
                    default:
                        return flag ? NORTH_PRESSED_SHAPE : NORTH_SHAPE;
                }
            case CEILING:
            default:
                if (direction.getAxis() == Direction.Axis.X) {
                    return flag ? CEILING_X_PRESSED_SHAPE : CEILING_X_SHAPE;
                } else {
                    return flag ? CEILING_Z_PRESSED_SHAPE : CEILING_Z_SHAPE;
                }
        }
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (state.get(PRESSED)) {
            return ActionResultType.CONSUME;
        } else {
            this.powerBlock(state, worldIn, pos);
            this.playSound(player, worldIn, pos, true);
            if (config.alarmSound) {
                worldIn.playSound(player, pos, ModSounds.ALARM.get(), SoundCategory.BLOCKS, 2f, 0.6f);
            }
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        }
    }

    public void powerBlock(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(PRESSED, Boolean.TRUE), 3);
        this.updateNeighbors(state, world, pos);
        world.getPendingBlockTicks().scheduleTick(pos, this, this.getActiveDuration());
    }

    protected void playSound(@Nullable PlayerEntity playerIn, IWorld worldIn, BlockPos pos, boolean hitByArrow) {
        worldIn.playSound(hitByArrow ? playerIn : null, pos, this.getSoundEvent(hitByArrow), SoundCategory.BLOCKS, 0.3F, hitByArrow ? 0.6F : 0.5F);
    }

    protected SoundEvent getSoundEvent(boolean isOn) {
        return SoundEvents.BLOCK_BONE_BLOCK_BREAK;
    }

    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!isMoving && !state.matchesBlock(newState.getBlock())) {
            if (state.get(PRESSED)) {
                this.updateNeighbors(state, worldIn, pos);
            }

            super.onReplaced(state, worldIn, pos, newState, isMoving);
        }
    }

    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(PRESSED) ? 15 : 0;
    }

    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(PRESSED) && getFacing(blockState) == side ? 15 : 0;
    }

    public boolean canProvidePower(BlockState state) {
        return true;
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (state.get(PRESSED)) {
            worldIn.setBlockState(pos, state.with(PRESSED, Boolean.FALSE), 3);
            this.updateNeighbors(state, worldIn, pos);
            this.playSound((PlayerEntity)null, worldIn, pos, false);

        }
    }

    private void updateNeighbors(BlockState state, World worldIn, BlockPos pos) {
        worldIn.notifyNeighborsOfStateChange(pos, this);
        worldIn.notifyNeighborsOfStateChange(pos.offset(getFacing(state).getOpposite()), this);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, PRESSED, FACE);
    }
}