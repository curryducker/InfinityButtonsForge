package net.larsmans.infinitybuttons.block.custom.letterbutton.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

public class ImageLetterButton extends ImageButton {

    private final int buttonId;
    private static final int THICKNESS = 4;
    private static final int HOVER_COLOR = Color.GRAY.getRGB();
    private static final int SELECT_COLOR = Color.LIGHT_GRAY.getRGB();

    public ImageLetterButton(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, ResourceLocation pResourceLocation, IPressable pOnPress, int buttonId) {
        super(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex, pResourceLocation, pOnPress);
        this.buttonId = buttonId;
    }

    @Override
    public void renderWidget(MatrixStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        int COLOR;
        super.renderWidget(pPoseStack, pMouseX, pMouseY, pPartialTick);
        if (isHovered || isSelected()) {
            if (isHovered) {
                COLOR = HOVER_COLOR;
            } else {
                COLOR = SELECT_COLOR;
            }
            fill(pPoseStack, x - THICKNESS, y - THICKNESS, x + width + THICKNESS, y, COLOR);
            fill(pPoseStack, x - THICKNESS, y, x, y + height, COLOR);
            fill(pPoseStack, x - THICKNESS, y + height, x + width + THICKNESS, y + height + THICKNESS, COLOR);
            fill(pPoseStack, x + width, y, x + width + THICKNESS, y + height, COLOR);
        }
    }

    public boolean isSelected() {
        return LetterButtonGui.getSelectedButton() == buttonId;
    }
}
