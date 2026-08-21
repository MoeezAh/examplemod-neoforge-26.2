package com.example.examplemod.datagen;

import java.util.Set;

import com.example.examplemod.blocks.ModBlocks;
import com.example.examplemod.blocks.custom.OnionCropBlock;
import com.example.examplemod.item.ModItems;

import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.advancements.predicates.StatePropertiesPredicate.Builder;
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
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

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

        dropSelf(ModBlocks.AZURITE_LAMP.get());
        dropSelf(ModBlocks.PEDESTAL_BLOCK.get());

        add(ModBlocks.ONION_CROP.get(), createCropDrops(ModBlocks.ONION_CROP.get(), ModItems.ONION.get(),
                ModItems.ONION_SEED.get(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ONION_CROP.get()).setProperties(
                        StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE, 3))));

        add(ModBlocks.GOJI_BERRY_BUSH.get(), (block) -> (LootTable.Builder) this.applyExplosionDecay(block,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition
                                .hasBlockStateProperties(ModBlocks.GOJI_BERRY_BUSH.get())
                                .setProperties(Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3)))
                        .add(LootItem.lootTableItem(ModItems.GOJI_BERRY))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE))))
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition
                                        .hasBlockStateProperties(ModBlocks.GOJI_BERRY_BUSH.get())
                                        .setProperties(Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2)))
                                .add(LootItem.lootTableItem(ModItems.GOJI_BERRY))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount
                                        .addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE))))));
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
