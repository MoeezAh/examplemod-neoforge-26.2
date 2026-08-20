package com.example.examplemod.datagen;

import java.util.concurrent.CompletableFuture;

import com.example.examplemod.item.ModItems;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

public class ModDataMapProvider extends DataMapProvider {

    public ModDataMapProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(Provider provider) {
        builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.END_FIRE_STARTER.getId(), new FurnaceFuel(4800), false);

        builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.ONION_SEED.getId(), new Compostable(0.3F), false)
                .add(ModItems.ONION.getId(), new Compostable(0.5F), false);
    }

}
