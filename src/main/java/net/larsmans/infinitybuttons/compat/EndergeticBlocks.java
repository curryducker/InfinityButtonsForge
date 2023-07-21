package net.larsmans.infinitybuttons.compat;

import net.larsmans.infinitybuttons.InfinityButtons;
import net.larsmans.infinitybuttons.InfinityButtonsUtil;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.button.compat.WoodenCompatButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.compat.*;
import net.larsmans.infinitybuttons.block.custom.torch.compat.EnderTorchButton;
import net.larsmans.infinitybuttons.block.custom.torch.compat.EnderTorchLever;
import net.larsmans.infinitybuttons.block.custom.torch.compat.EnderWallTorchButton;
import net.larsmans.infinitybuttons.block.custom.torch.compat.EnderWallTorchLever;
import net.larsmans.infinitybuttons.item.InfinityButtonsItemGroup;
import net.larsmans.infinitybuttons.item.InfinityButtonsItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class EndergeticBlocks {

    public static AbstractBlock.Properties PROP = AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD);

    public static final RegistryObject<Block> POISE_LARGE_BUTTON = registerBlock("poise_large_button",
            () -> new WoodenCompatButton(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD), true));

    public static final RegistryObject<Block> POISE_BOOKSHELF_SECRET_BUTTON = registerBlock("poise_bookshelf_secret_button",
            () -> new CompatBookshelfSecretButton(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f).notSolid().sound(SoundType.WOOD), byName("poise_bookshelf")));

    public static final RegistryObject<Block> CHISELED_END_STONE_BRICK_SECRET_BUTTON = registerBlock("chiseled_end_stone_brick_secret_button",
            () -> new ChiseledEndStoneBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0f, 9.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("chiseled_end_stone_bricks")));

    public static final RegistryObject<Block> CHISELED_EUMUS_BRICK_SECRET_BUTTON = registerBlock("chiseled_eumus_brick_secret_button",
            () -> new ChiseledEumusBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 30.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("chiseled_eumus_bricks")));

    public static final RegistryObject<Block> CRACKED_END_STONE_BRICK_SECRET_BUTTON = registerBlock("cracked_end_stone_brick_secret_button",
            () -> new BigCompatSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0f, 9.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("cracked_end_stone_bricks")));

    public static final RegistryObject<Block> CRACKED_EUMUS_BRICK_SECRET_BUTTON = registerBlock("cracked_eumus_brick_secret_button",
            () -> new EumusBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 30.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("cracked_eumus_bricks")));

    public static final RegistryObject<Block> EUMUS_BRICK_SECRET_BUTTON = registerBlock("eumus_brick_secret_button",
            () -> new EumusBrickSecretButton(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0f, 30.0f).notSolid().sound(SoundType.STONE).setRequiresTool(), byName("eumus_bricks")));

    public static final RegistryObject<Block> POISE_PLANK_SECRET_BUTTON = registerBlock("poise_plank_secret_button",
            () -> new CompatPlankSecretButton(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PURPLE_TERRACOTTA)
                    .harvestLevel(0).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f, 3.0f).notSolid().sound(SoundType.WOOD), byName("poise_planks")));

    public static final RegistryObject<Block> ENDER_TORCH_BUTTON = registerTorchBlock("ender_torch_button",
            () -> new EnderTorchButton(PROP, byName("ender_torch")));

    public static final RegistryObject<Block> ENDER_WALL_TORCH_BUTTON = registerTorchBlock("ender_wall_torch_button",
            () -> new EnderWallTorchButton(PROP, byName("ender_torch")));

    public static final RegistryObject<Block> ENDER_TORCH_LEVER = registerTorchBlock("ender_torch_lever",
            () -> new EnderTorchLever(PROP, byName("ender_torch")));

    public static final RegistryObject<Block> ENDER_WALL_TORCH_LEVER = registerTorchBlock("ender_wall_torch_lever",
            () -> new EnderWallTorchLever(PROP, byName("ender_torch")));

    /**
     * Methods
     */

    private static Block byName(String block) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation("endergetic", block));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = InfinityButtonsBlocks.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        RegistryObject<Item> register = InfinityButtonsItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(InfinityButtonsItemGroup.INFINITYBUTTONS)));
        InfinityButtonsUtil.REGISTRY_FOR_TAB.add(register);
    }

    private static <T extends Block> RegistryObject<T> registerTorchBlock(String name, Supplier<T> block) {
        return InfinityButtonsBlocks.BLOCKS.register(name, block);
    }

    public static void registerCompatBlocks() {
        InfinityButtons.LOGGER.debug("Registering Endergetic Compat Blocks for Infinity Buttons");
    }
}
