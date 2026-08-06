package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.food.ModFoods;
import com.example.examplemod.item.custom.MetalDetectorItem;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExampleMod.MOD_ID);

        public static final DeferredItem<Item> AZURITE = ITEMS.registerSimpleItem("azurite");
        public static final DeferredItem<Item> RAW_AZURITE = ITEMS.registerSimpleItem("raw_azurite");

        public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.registerItem("metal_detector",
                        props -> new MetalDetectorItem(props.durability(64)));

        public static final DeferredItem<Item> ONION = ITEMS.registerItem("onion",
                        properties -> new Item(properties.food(ModFoods.ONION, ModFoods.ONION_CONSUMABLE)) {
                                @Override
                                public void appendHoverText(net.minecraft.world.item.ItemStack itemStack,
                                                TooltipContext context,
                                                net.minecraft.world.item.component.TooltipDisplay display,
                                                java.util.function.Consumer<net.minecraft.network.chat.Component> builder,
                                                net.minecraft.world.item.TooltipFlag tooltipFlag) {
                                        builder.accept(Component.translatable("tooltip.examplemod.onion.tooltip"));
                                        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                                };
                        });

        public static final DeferredItem<Item> END_FIRE_STARTER = ITEMS.registerItem("end_fire_starter",
                        properties -> new Item(properties.stacksTo(32)));

        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }
}
