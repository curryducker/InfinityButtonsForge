package net.larsmans.infinitybuttons.block.custom.letterbutton.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentUtils;


public class TextButton extends Button {
    private final FontRenderer font;
    private final ITextComponent message;
    private final ITextComponent underlinedMessage;

    public TextButton(int x, int y, int width, int height, ITextComponent title, IPressable pressedAction, FontRenderer fontRenderer) {
        super(x, y, width, height, title, pressedAction);
        this.font = fontRenderer;
        this.message = title;
        this.underlinedMessage = TextComponentUtils.func_240648_a_(title.deepCopy(), Style.EMPTY.setUnderlined(true));
    }

    @Override
    public void renderWidget(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        ITextComponent component = this.isHovered() ? this.underlinedMessage : this.message;
        drawString(matrixStack, this.font, component, this.x, this.y, 16777215 | MathHelper.ceil(this.alpha * 255.0F) << 24);
    }
}
