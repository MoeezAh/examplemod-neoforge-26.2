package com.example.examplemod.datagen;

import java.util.concurrent.CompletableFuture;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.blocks.ModBlocks;
import com.example.examplemod.tags.ModTags;

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
                .add(ModBlocks.AZURITE_END_ORE.getKey())
                .add(ModBlocks.MAGIC_BLOCK.getKey())
                .add(ModBlocks.AZURITE_STAIRS.getKey())
                .add(ModBlocks.AZURITE_SLAB.getKey())
                .add(ModBlocks.AZURITE_LAMP.getKey())
                .add(ModBlocks.PEDESTAL_BLOCK.getKey());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.AZURITE_DEEPSLATE_ORE.getKey());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.AZURITE_NETHER_ORE.getKey());

        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.AZURITE_END_ORE.getKey());

        tag(ModTags.Blocks.METAL_DETECTABLES)
                .addTag(Tags.Blocks.ORES);

        tag(BlockTags.STAIRS)
                .add(ModBlocks.AZURITE_STAIRS.getKey());

        tag(BlockTags.SLABS)
                .add(ModBlocks.AZURITE_SLAB.getKey());

        tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.AZURITE_PRESSURE_PLATE.getKey());

        tag(BlockTags.BUTTONS)
                .add(ModBlocks.AZURITE_BUTTON.getKey());

        tag(BlockTags.FENCES)
                .add(ModBlocks.AZURITE_FENCE.getKey());

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.AZURITE_FENCE_GATE.getKey());

        tag(BlockTags.WALLS)
                .add(ModBlocks.AZURITE_WALL.getKey());

        tag(BlockTags.DOORS)
                .add(ModBlocks.AZURITE_DOOR.getKey());

        tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.AZURITE_TRAPDOOR.getKey());

        tag(ModTags.Blocks.NEEDS_AZURITE_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.getKey())
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_AZURITE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_AZURITE_TOOL);

        tag(BlockTags.CROPS).add(ModBlocks.ONION_CROP.getKey());
        tag(BlockTags.MAINTAINS_FARMLAND).add(ModBlocks.ONION_CROP.getKey());
    }

}
