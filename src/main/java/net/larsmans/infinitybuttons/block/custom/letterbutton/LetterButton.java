package net.larsmans.infinitybuttons.block.custom.letterbutton;

import net.larsmans.infinitybuttons.block.custom.button.AbstractSmallButton;
import net.larsmans.infinitybuttons.block.custom.letterbutton.gui.LetterButtonGui;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

import java.util.Objects;

public class LetterButton extends AbstractSmallButton {

    public static final EnumProperty<LetterButtonEnum> CHARACTER = EnumProperty.create("character", LetterButtonEnum.class);

    public LetterButton(Properties properties) {
        super(true, true, properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(PRESSED, false).with(FACE, AttachFace.FLOOR).with(CHARACTER, LetterButtonEnum.NONE));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ClientPlayNetHandler connection = Minecraft.getInstance().getConnection();
        assert connection != null;
        GameType gameMode = Objects.requireNonNull(connection.getPlayerInfo(player.getGameProfile().getId())).getGameType();
        if (player.isSneaking()) {
            if (gameMode == GameType.ADVENTURE) {
                return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
            }
            if (worldIn.isRemote) {
                Minecraft.getInstance().displayGuiScreen(new LetterButtonGui(this, state, worldIn, pos));
            }
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }

    @Override
    public int getActiveDuration() {
        return 30;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean pressed) {
        return SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON;
    }

    public int getEnumId(BlockState state) {
        return state.get(CHARACTER).ordinal();
    }

    public void setState(BlockState state, World worldIn, BlockPos pos, LetterButtonEnum buttonEnum) {
        worldIn.setBlockState(pos, state.with(CHARACTER, buttonEnum), 3);
        this.updateNeighbors(state, worldIn, pos);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(CHARACTER);
    }
}
