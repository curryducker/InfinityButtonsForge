package net.larsmans.infinitybuttons.block.custom.emergencybutton;

import net.larsmans.infinitybuttons.block.custom.button.AbstractButton;
import net.larsmans.infinitybuttons.sounds.InfinityButtonsSounds;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.play.server.SPlaySoundEffectPacket;
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

import javax.annotation.Nullable;

public class EmergencyButton extends AbstractButton {
    
    private static final VoxelShape STONE_DOWN  = Block.makeCuboidShape(4, 0, 4, 12, 1, 12);
    private static final VoxelShape STONE_UP    = Block.makeCuboidShape(4, 15, 4, 12, 16, 12);
    private static final VoxelShape STONE_NORTH = Block.makeCuboidShape(4, 4, 15, 12, 12, 16);
    private static final VoxelShape STONE_EAST  = Block.makeCuboidShape(0, 4, 4, 1, 12, 12);
    private static final VoxelShape STONE_SOUTH = Block.makeCuboidShape(4, 4, 0, 12, 12, 1);
    private static final VoxelShape STONE_WEST  = Block.makeCuboidShape(15, 4, 4, 16, 12, 12);

    private static final VoxelShape FLOOR_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 1, 5, 11, 5, 11), STONE_DOWN).simplify();
    private static final VoxelShape FLOOR_PRESSED_SHAPE = VoxelShapes.or(
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
    private static final VoxelShape CEILING_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 11, 5, 11, 15, 11), STONE_UP).simplify();
    private static final VoxelShape CEILING_PRESSED_SHAPE = VoxelShapes.or(
            Block.makeCuboidShape(5, 13, 5, 11, 15, 11), STONE_UP).simplify();

    public EmergencyButton(Properties properties) {
        super(false, properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(PRESSED, false).with(FACE, AttachFace.FLOOR));
    }

    @Override
    public int getActiveDuration() {
        return 10;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction direction = state.get(HORIZONTAL_FACING);
        boolean flag = state.get(PRESSED);
        switch(state.get(FACE)) {
            case FLOOR:
                return flag ? FLOOR_PRESSED_SHAPE : FLOOR_SHAPE;
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
                return flag ? CEILING_PRESSED_SHAPE : CEILING_SHAPE;
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (state.get(PRESSED)) {
            return ActionResultType.CONSUME;
        }
        this.powerBlock(state, worldIn, pos);
        this.playSound(player, worldIn, pos, true);
        if (config.alarmSound) {
            worldIn.playSound(player, pos, InfinityButtonsSounds.ALARM.get(), SoundCategory.BLOCKS, 1, 1);
        }
        return ActionResultType.func_233537_a_(worldIn.isRemote);
    }

    @Override
    protected void playSound(@Nullable PlayerEntity playerIn, IWorld worldIn, BlockPos pos, boolean pressed) {
        worldIn.playSound(pressed ? playerIn : null, pos, this.getSoundEvent(pressed), SoundCategory.BLOCKS, 1, pressed ? 0.6f : 0.5f);
    }

    @Override
    protected SoundEvent getSoundEvent(boolean pressed) {
        return SoundEvents.BLOCK_BONE_BLOCK_BREAK;
    }
}