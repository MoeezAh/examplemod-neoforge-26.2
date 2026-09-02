package com.example.examplemod;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.examplemod.datagen.ModAdvancements;
import com.example.examplemod.datagen.ModBlockLootTableProvider;
import com.example.examplemod.datagen.ModBlockTagsProvider;
import com.example.examplemod.datagen.ModDataMapProvider;
import com.example.examplemod.datagen.ModDataPackProvider;
import com.example.examplemod.datagen.ModEquipmentAssetProvider;
import com.example.examplemod.datagen.ModItemTagsProvider;
import com.example.examplemod.datagen.ModModelProvider;
import com.example.examplemod.datagen.ModPaintingTagsProvider;
import com.example.examplemod.datagen.ModRecipeProvider;
import com.example.examplemod.datagen.ModSoundsProvider;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = ExampleMod.MOD_ID)
public class ExampleModDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        CompletableFuture<Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new ModModelProvider(packOutput));
        generator.addProvider(true, new ModBlockTagsProvider(packOutput, lookupProvider));
        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new,
                        LootContextParamSets.BLOCK)),
                lookupProvider));
        generator.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));
        generator.addProvider(true, new ModDataMapProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModItemTagsProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModEquipmentAssetProvider(packOutput));
        generator.addProvider(true, new ModDataPackProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModPaintingTagsProvider(packOutput, lookupProvider));

        generator.addProvider(true, new ModSoundsProvider(packOutput));
        generator.addProvider(true, new ModAdvancements(packOutput, lookupProvider));
    }
}
