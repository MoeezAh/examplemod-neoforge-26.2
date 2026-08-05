package com.example.examplemod.datagen;

import java.util.concurrent.CompletableFuture;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.blocks.ModBlocks;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider) {
        super(output, lookupProvider, ExampleMod.MOD_ID);
    }

    @Override
    protected void addTags(Provider arg0) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.AZURITE_BLOCK.getKey())
            .add(ModBlocks.RAW_AZURITE_BLOCK.getKey())
            .add(ModBlocks.AZURITE_ORE.getKey())
            .add(ModBlocks.AZURITE_DEEPSLATE_ORE.getKey())
            .add(ModBlocks.AZURITE_NETHER_ORE.getKey())
            .add(ModBlocks.AZURITE_END_ORE.getKey());

        tag(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.AZURITE_DEEPSLATE_ORE.getKey());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.AZURITE_NETHER_ORE.getKey());
        
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
            .add(ModBlocks.AZURITE_END_ORE.getKey());
    }

}
