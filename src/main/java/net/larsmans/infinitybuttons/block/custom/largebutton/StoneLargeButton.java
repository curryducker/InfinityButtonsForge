package net.larsmans.infinitybuttons.block.custom.largebutton;

import net.larsmans.infinitybuttons.block.custom.button.StoneButton;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class StoneLargeButton extends StoneButton {
    public StoneLargeButton(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return LargeButtonShape.outlineShape(state);
    }
}
