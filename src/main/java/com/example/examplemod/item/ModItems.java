package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.food.ModFoods;
import com.example.examplemod.item.custom.DataTabletItem;
import com.example.examplemod.item.custom.MetalDetectorItem;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.equipment.ArmorType;
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
                public void appendHoverText(net.minecraft.world.item.ItemStack itemStack, TooltipContext context,
                        net.minecraft.world.item.component.TooltipDisplay display,
                        java.util.function.Consumer<net.minecraft.network.chat.Component> builder,
                        net.minecraft.world.item.TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.examplemod.onion.tooltip"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                };
            });

    public static final DeferredItem<Item> END_FIRE_STARTER = ITEMS.registerItem("end_fire_starter",
            properties -> new Item(properties.stacksTo(32)));

    public static final DeferredItem<Item> AZURITE_SWORD = ITEMS.registerItem("azurite_sword",
            properties -> new Item(properties.sword(ModToolTier.AZURITE, 3, -2.4f)));

    public static final DeferredItem<Item> AZURITE_PICKAXE = ITEMS.registerItem("azurite_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolTier.AZURITE, 1, -2.8f)));

    public static final DeferredItem<Item> AZURITE_SHOVEL = ITEMS.registerItem("azurite_shovel",
            properties -> new ShovelItem(ModToolTier.AZURITE, 1.5f, -3.0f, properties));

    public static final DeferredItem<Item> AZURITE_AXE = ITEMS.registerItem("azurite_axe",
            properties -> new AxeItem(ModToolTier.AZURITE, 6f, -3.2f, properties));

    public static final DeferredItem<Item> AZURITE_HOE = ITEMS.registerItem("azurite_hoe",
            properties -> new HoeItem(ModToolTier.AZURITE, 0, -3.8f, properties));

    public static final DeferredItem<Item> AZURITE_SPEAR = ITEMS.registerItem("azurite_spear",
            properties -> new Item(
                    properties.spear(ModToolTier.AZURITE, 0.95f, 0.7f, 0.7f, 3.5f, 13f, 8.5f, 5.1f, 13.37f, 4.67f)));

    public static final DeferredItem<Item> AZURITE_HELMET = ITEMS.registerItem("azurite_helmet",
            properties -> new Item(
                    properties.humanoidArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorType.HELMET)));

    public static final DeferredItem<Item> AZURITE_CHESTPLATE = ITEMS.registerItem("azurite_chestplate",
            properties -> new Item(
                    properties.humanoidArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));

    public static final DeferredItem<Item> AZURITE_LEGGINGS = ITEMS.registerItem("azurite_leggings",
            properties -> new Item(
                    properties.humanoidArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorType.LEGGINGS)));

    public static final DeferredItem<Item> AZURITE_BOOTS = ITEMS.registerItem("azurite_boots",
            properties -> new Item(
                    properties.humanoidArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final DeferredItem<Item> AZURITE_HORSE_ARMOR = ITEMS.registerItem("azurite_horse_armor",
            properties -> new Item(properties.horseArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL)));

    public static final DeferredItem<Item> DATA_TABLET = ITEMS.registerItem("data_tablet",
            properties -> new DataTabletItem(properties.stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
