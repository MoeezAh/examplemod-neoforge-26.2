package com.example.examplemod.datagen;

import java.util.Set;

import com.example.examplemod.blocks.ModBlocks;
import com.example.examplemod.item.ModItems;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.AZURITE_BLOCK.get());
        dropSelf(ModBlocks.RAW_AZURITE_BLOCK.get());

        add(ModBlocks.AZURITE_ORE.get(),
                createOreDrop(ModBlocks.AZURITE_ORE.get(), ModItems.RAW_AZURITE.get()));
        add(ModBlocks.AZURITE_DEEPSLATE_ORE.get(),
                createOreDrop(ModBlocks.AZURITE_DEEPSLATE_ORE.get(), ModItems.RAW_AZURITE.get()));

        add(ModBlocks.AZURITE_NETHER_ORE.get(), createMultipleOreDrops(
                ModBlocks.AZURITE_NETHER_ORE.get(), ModItems.RAW_AZURITE.get(), 4f, 7f));

        add(ModBlocks.AZURITE_END_ORE.get(), createMultipleOreDrops(ModBlocks.AZURITE_END_ORE.get(),
                ModItems.RAW_AZURITE.get(), 5f, 9f));

        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.AZURITE_STAIRS.get());

        add(ModBlocks.AZURITE_SLAB.get(), block -> createSlabItemTable(block));

        dropSelf(ModBlocks.AZURITE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.AZURITE_BUTTON.get());
        dropSelf(ModBlocks.AZURITE_FENCE.get());
        dropSelf(ModBlocks.AZURITE_FENCE_GATE.get());
        dropSelf(ModBlocks.AZURITE_WALL.get());
        dropSelf(ModBlocks.AZURITE_TRAPDOOR.get());
        add(ModBlocks.AZURITE_DOOR.get(), this::createDoorTable);
    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops,
            float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block,
                (LootPoolEntryContainer.Builder) this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction
                                        .setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(
                                        enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
