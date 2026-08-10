package com.example.examplemod.creativemodetab;

import java.util.function.Supplier;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.ModItems;
import com.example.examplemod.blocks.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);

    public static final Supplier<CreativeModeTab> AZURITE_ITEMS_TAB = CREATIVE_MODE_TABS.register(
            "example_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AZURITE.get()))
                    .title(Component.translatable("creativetab.examplemod.exampleitems"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS).withTabsAfter(Identifier
                            .fromNamespaceAndPath(ExampleMod.MOD_ID, "example_blocks_tab"))
                    .displayItems((itemDisplayParameter, output) -> {
                        output.accept(ModItems.AZURITE);
                        output.accept(ModItems.RAW_AZURITE);
                        output.accept(ModItems.METAL_DETECTOR);
                        output.accept(ModItems.ONION);
                        output.accept(ModItems.END_FIRE_STARTER);
                        output.accept(ModItems.AZURITE_SWORD);
                        output.accept(ModItems.AZURITE_PICKAXE);
                        output.accept(ModItems.AZURITE_AXE);
                        output.accept(ModItems.AZURITE_SHOVEL);
                        output.accept(ModItems.AZURITE_HOE);
                        output.accept(ModItems.AZURITE_SPEAR);

                        output.accept(ModItems.AZURITE_HELMET);
                        output.accept(ModItems.AZURITE_CHESTPLATE);
                        output.accept(ModItems.AZURITE_LEGGINGS);
                        output.accept(ModItems.AZURITE_BOOTS);

                    }).build());

    public static final Supplier<CreativeModeTab> AZURITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register(
            "example_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.AZURITE_BLOCK.get()))
                    .title(Component.translatable("creativetab.examplemod.exampleblocks"))
                    .displayItems((itemDisplayParameter, output) -> {
                        output.accept(ModBlocks.AZURITE_BLOCK);
                        output.accept(ModBlocks.RAW_AZURITE_BLOCK);
                        output.accept(ModBlocks.AZURITE_ORE);
                        output.accept(ModBlocks.AZURITE_DEEPSLATE_ORE);
                        output.accept(ModBlocks.AZURITE_NETHER_ORE);
                        output.accept(ModBlocks.AZURITE_END_ORE);

                        output.accept(ModBlocks.MAGIC_BLOCK);

                        output.accept(ModBlocks.AZURITE_STAIRS);
                        output.accept(ModBlocks.AZURITE_SLAB);

                        output.accept(ModBlocks.AZURITE_PRESSURE_PLATE);
                        output.accept(ModBlocks.AZURITE_BUTTON);
                        output.accept(ModBlocks.AZURITE_FENCE);
                        output.accept(ModBlocks.AZURITE_FENCE_GATE);
                        output.accept(ModBlocks.AZURITE_WALL);
                        output.accept(ModBlocks.AZURITE_DOOR);
                        output.accept(ModBlocks.AZURITE_TRAPDOOR);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);

    }
}
