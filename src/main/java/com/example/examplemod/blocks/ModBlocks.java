package com.example.examplemod.blocks;

import java.util.function.Function;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.blocks.custom.MagicBlock;
import com.example.examplemod.item.ModItems;

import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ExampleMod.MOD_ID);

    public static final DeferredBlock<Block> AZURITE_BLOCK = registerBlock("azurite_block",
            properties -> new Block(properties
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> RAW_AZURITE_BLOCK = registerBlock("raw_azurite_block",
            properties -> new Block(properties
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> AZURITE_ORE = registerBlock("azurite_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 4), properties
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> AZURITE_NETHER_ORE = registerBlock("azurite_nether_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 4), properties
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_WART)));

    public static final DeferredBlock<Block> AZURITE_END_ORE = registerBlock("azurite_end_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 4), properties
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> AZURITE_DEEPSLATE_ORE = registerBlock("azurite_deepslate_ore",
            properties -> new DropExperienceBlock(UniformInt.of(3, 5), properties
                    .strength(2.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            properties -> new MagicBlock(properties
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DECORATED_POT)),
            Component.translatable("tooltip.examplemod.magic_block.tooltip"));

    public static final DeferredBlock<Block> AZURITE_STAIRS = registerBlock("azurite_stairs",
            properties -> new StairBlock(ModBlocks.AZURITE_BLOCK.get().defaultBlockState(),
                    properties.strength(3f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.AMETHYST)),
            Component.translatable("tooltip.examplemod.azurite_stairs.tooltip"));

    public static final DeferredBlock<Block> AZURITE_SLAB = registerBlock("azurite_slab",
            properties -> new SlabBlock(properties.strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)),
            Component.translatable("tooltip.examplemod.azurite_slab.tooltip"));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name,
            Function<BlockBehaviour.Properties, T> function, Component... components) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn, components);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block,
            Component... components) {
        ModItems.ITEMS.registerItem(name,
                properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()) {
                    @Override
                    public void appendHoverText(net.minecraft.world.item.ItemStack itemStack,
                            TooltipContext context,
                            net.minecraft.world.item.component.TooltipDisplay display,
                            java.util.function.Consumer<Component> builder,
                            net.minecraft.world.item.TooltipFlag tooltipFlag) {
                        for (Component component : components) {
                            builder.accept(component);
                        }
                        super.appendHoverText(itemStack, context, display, builder,
                                tooltipFlag);
                    };
                });
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name,
            Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name,
                properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
