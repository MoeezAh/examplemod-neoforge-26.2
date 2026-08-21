package com.example.examplemod.blocks;

import java.util.function.Function;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.blocks.custom.AzuriteLampBlock;
import com.example.examplemod.blocks.custom.GojiBerryBushBlock;
import com.example.examplemod.blocks.custom.MagicBlock;
import com.example.examplemod.blocks.custom.OnionCropBlock;
import com.example.examplemod.blocks.custom.PedestalBlock;
import com.example.examplemod.blocks.custom.RiceCropBlock;
import com.example.examplemod.item.ModItems;

import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
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

    public static final DeferredBlock<Block> AZURITE_PRESSURE_PLATE = registerBlock("azurite_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.IRON, properties.mapColor(MapColor.COLOR_BLUE)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(0.5f)
                    .pushReaction(PushReaction.DESTROY)),
            Component.translatable("tooltip.examplemod.azurite_pressure_plate.tooltip"));

    public static final DeferredBlock<Block> AZURITE_BUTTON = registerBlock("azurite_button",
            properties -> new ButtonBlock(BlockSetType.IRON, 20,
                    properties.noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY)),
            Component.translatable("tooltip.examplemod.azurite_button.tooltip"));

    public static final DeferredBlock<Block> AZURITE_FENCE = registerBlock("azurite_fence",
            properties -> new FenceBlock(properties.strength(2F)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> AZURITE_FENCE_GATE = registerBlock("azurite_fence_gate",
            properties -> new FenceGateBlock(WoodType.ACACIA, properties.strength(2F)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> AZURITE_WALL = registerBlock("azurite_wall",
            properties -> new WallBlock(properties.strength(2F)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> AZURITE_DOOR = registerBlock("azurite_door",
            properties -> new DoorBlock(BlockSetType.IRON, properties.strength(2F)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST).noOcclusion()));

    public static final DeferredBlock<Block> AZURITE_TRAPDOOR = registerBlock("azurite_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.IRON, properties.strength(2F)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST).noOcclusion()));

    public static final DeferredBlock<Block> AZURITE_LAMP = registerBlock("azurite_lamp",
            properties -> new AzuriteLampBlock(properties.strength(2F)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(AzuriteLampBlock.CLICKED) ? 15 : 0)));

    public static final DeferredBlock<Block> PEDESTAL_BLOCK = registerBlock("pedestal",
            properties -> new PedestalBlock(properties.strength(2F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ONION_CROP = BLOCKS.registerBlock("onion_crop",
            properties -> new OnionCropBlock(properties.randomTicks().sound(SoundType.CROP).instabreak().noCollision()
                    .pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> GOJI_BERRY_BUSH = BLOCKS.registerBlock("goji_berry_bush",
            properties -> new GojiBerryBushBlock(properties.randomTicks().sound(SoundType.SWEET_BERRY_BUSH)
                    .noCollision().pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> RICE_CROP = BLOCKS.registerBlock("rice_crop",
            properties -> new RiceCropBlock(properties.randomTicks().sound(SoundType.CROP).instabreak()
                    .noCollision().pushReaction(PushReaction.DESTROY)));

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
