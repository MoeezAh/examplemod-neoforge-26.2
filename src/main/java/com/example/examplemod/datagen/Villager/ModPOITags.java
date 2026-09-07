package com.example.examplemod.datagen.Villager;

import java.util.concurrent.CompletableFuture;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.villager.ModVillager;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.tags.TagEntry;

public class ModPOITags extends PoiTypeTagsProvider {

    public ModPOITags(PackOutput output, CompletableFuture<Provider> lookupProvider) {
        super(output, lookupProvider, ExampleMod.MOD_ID);
    }

    @Override
    protected void addTags(Provider registries) {
        getOrCreateRawBuilder(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .add(TagEntry.element(ModVillager.KAUPER_POI.unwrapKey().get().identifier()));
    }
}
