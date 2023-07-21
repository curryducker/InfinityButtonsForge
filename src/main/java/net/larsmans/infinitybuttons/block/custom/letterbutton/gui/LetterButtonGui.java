package net.larsmans.infinitybuttons.block.custom.letterbutton.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.larsmans.infinitybuttons.block.custom.letterbutton.LetterButton;
import net.larsmans.infinitybuttons.block.custom.letterbutton.LetterButtonEnum;
import net.larsmans.infinitybuttons.network.IBPacketHandler;
import net.larsmans.infinitybuttons.network.packets.LetterButtonStatePacket;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;

public class LetterButtonGui extends Screen {

    private static final ResourceLocation LETTER_TEXTURE = new ResourceLocation("infinitybuttons", "textures/block/letter_button/characters.png");

    private static final int BUTTON_WIDTH = 24;
    private static final int BUTTON_HEIGHT = 24;
    private static final int BUTTON_MARGIN = 4;
    private static final int BUTTONS_PER_ROW = 7;
    private static final int NUM_BUTTONS = 49;

    private final LetterButton letterButton;
    private final BlockState state;
    private final World world;
    private final BlockPos pos;
    private static int selectedButton;

    public LetterButtonGui(LetterButton letterButton, BlockState state, World worldIn, BlockPos pos) {
        super(new TranslationTextComponent("block.infinitybuttons.letter_button"));
        this.letterButton = letterButton;
        this.state = state;
        this.world = worldIn;
        this.pos = pos;
    }

    @Override
    protected void init() {
        selectedButton = letterButton.getEnumId(state);
        super.init();
        int startX = (width - (BUTTONS_PER_ROW * (BUTTON_WIDTH + BUTTON_MARGIN))) / 2;
        int startY = (height - (((NUM_BUTTONS - 1) / BUTTONS_PER_ROW + 1) * (BUTTON_HEIGHT + BUTTON_MARGIN))) / 2;

        for (int i = 0; i < NUM_BUTTONS; i++) {
            int row = i / BUTTONS_PER_ROW;
            int col = i % BUTTONS_PER_ROW;
            int x = startX + col * (BUTTON_WIDTH + BUTTON_MARGIN);
            int y = startY + row * (BUTTON_HEIGHT + BUTTON_MARGIN);
            int button = i;
            int TexX = col * 20;
            int TexY = row * 20;

            addButton(new ImageLetterButton(x, y, BUTTON_WIDTH, BUTTON_HEIGHT, TexX, TexY, 0, LETTER_TEXTURE, pButton -> onClick(button), button));
        }

        int buttonWidth = font.getStringPropertyWidth(new TranslationTextComponent("gui.done"));
        int buttonHeight = font.FONT_HEIGHT;
        addButton(new TextButton((width - buttonWidth) / 2, startY + (((NUM_BUTTONS - 1) / BUTTONS_PER_ROW) + 1) * (BUTTON_HEIGHT + BUTTON_MARGIN),
                buttonWidth, buttonHeight, new TranslationTextComponent("gui.done"), pButton -> close(), font));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (pKeyCode == GLFW.GLFW_KEY_E) {
            this.close();
            return true;
        }
        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void onClose() {
        for (LetterButtonEnum buttonEnum : LetterButtonEnum.values()) {
            if (selectedButton == buttonEnum.ordinal() && world.getBlockState(pos).getBlock() instanceof LetterButton) {
                letterButton.setState(state, world, pos, buttonEnum);
                IBPacketHandler.sendToServer(new LetterButtonStatePacket(pos, buttonEnum));
            }
        }
    }

    private void close() {
        getMinecraft().displayGuiScreen(null);
        onClose();
    }

    public static int getSelectedButton() {
        return selectedButton;
    }

    protected void onClick(int button) {
        selectedButton = button;
        close();
    }
}