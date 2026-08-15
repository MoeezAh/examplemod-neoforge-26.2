package com.example.examplemod.datagen;

import java.util.concurrent.CompletableFuture;

import com.example.examplemod.ExampleMod;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;

public class ModPaintingTagsProvider extends TagsProvider<PaintingVariant> {

    public ModPaintingTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider) {
        super(output, Registries.PAINTING_VARIANT, lookupProvider, ExampleMod.MOD_ID);
    }

    protected void addTags(Provider registries) {
        this.getOrCreateRawBuilder(PaintingVariantTags.PLACEABLE)
                .add(TagEntry.optionalElement(ModPaintings.SAW_THEM_KEY.identifier()))
                .add(TagEntry.optionalElement(ModPaintings.SHRIMP_KEY.identifier()))
                .add(TagEntry.optionalElement(ModPaintings.WORLD_KEY.identifier()));
    }
}
