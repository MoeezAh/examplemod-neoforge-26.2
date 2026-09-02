package com.example.examplemod.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.blocks.ModBlocks;
import com.example.examplemod.item.ModItems;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.advancements.triggers.ItemUsedOnLocationTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

public class ModAdvancements extends AdvancementProvider {

    public ModAdvancements(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries, List.of(new ExampleModAdvancements()));
    }

    public static class ExampleModAdvancements implements AdvancementSubProvider {

        @Override
        public void generate(Provider provider, Consumer<AdvancementHolder> arg1) {
            RegistryLookup<Item> items = provider.lookupOrThrow(Registries.ITEM);

            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(ModItems.AZURITE,
                            Component.translatable("advancements.examplemod.root.title"),
                            Component.translatable("advancements.examplemod.root.description"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                            AdvancementType.TASK,
                            false,
                            false,
                            false)
                    .addCriterion("has_azurite",
                            InventoryChangeTrigger.TriggerInstance
                                    .hasItems(ItemPredicate.Builder.item().of(items, ModItems.AZURITE)))
                    .save(arg1, Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "examplemod/root"));

            AdvancementHolder plant_seed = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.RICE_SHOOT,
                            Component.translatable("advancements.examplemod.plant_custom.title"),
                            Component.translatable("advancements.examplemod.plant_custom.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false)
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .addCriterion("berries",
                            ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(ModBlocks.GOJI_BERRY_BUSH.get()))
                    .addCriterion("rice",
                            ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(ModBlocks.RICE_CROP.get()))
                    .addCriterion("onion",
                            ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(ModBlocks.ONION_CROP.get()))
                    .save(arg1, "examplemod/plant_custom");

            AdvancementHolder metalDetector = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.METAL_DETECTOR,
                            Component.translatable("advancements.examplemod.metal_detector.title"),
                            Component.translatable("advancements.examplemod.metal_detector.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false)
                    .addCriterion("metal_detector",
                            ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                                    LocationPredicate.Builder.location().setCanSeeSky(true),
                                    ItemPredicate.Builder.item().of(items, ModItems.METAL_DETECTOR)))
                    .save(arg1, Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "examplemod/metal_detector"));
        }

    }
}
