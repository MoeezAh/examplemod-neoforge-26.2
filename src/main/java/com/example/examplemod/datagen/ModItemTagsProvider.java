package com.example.examplemod.datagen;

import java.util.concurrent.CompletableFuture;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.ModItems;
import com.example.examplemod.tags.ModTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.references.BlockItemIds;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider) {
        super(output, lookupProvider, ExampleMod.MOD_ID);
    }

    @Override
    protected void addTags(Provider registries) {

        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ItemIds.IRON_INGOT)
                .add(BlockItemIds.REDSTONE_DUST.item())
                .add(ItemIds.COPPER_INGOT)
                .add(ModItems.AZURITE.getKey());

        tag(ModTags.Items.AZURITE_REPAIRABLE)
                .add(ModItems.AZURITE.getKey());

        tag(ItemTags.SWORDS).add(ModItems.AZURITE_SWORD.getKey());
        tag(ItemTags.PICKAXES).add(ModItems.AZURITE_PICKAXE.getKey());
        tag(ItemTags.AXES).add(ModItems.AZURITE_AXE.getKey());
        tag(ItemTags.SHOVELS).add(ModItems.AZURITE_SHOVEL.getKey());
        tag(ItemTags.HOES).add(ModItems.AZURITE_HOE.getKey());
        tag(ItemTags.SPEARS).add(ModItems.AZURITE_SPEAR.getKey());

        tag(ItemTags.HEAD_ARMOR).add(ModItems.AZURITE_HELMET.getKey());
        tag(ItemTags.CHEST_ARMOR).add(ModItems.AZURITE_CHESTPLATE.getKey());
        tag(ItemTags.LEG_ARMOR).add(ModItems.AZURITE_LEGGINGS.getKey());
        tag(ItemTags.FOOT_ARMOR).add(ModItems.AZURITE_BOOTS.getKey());

        tag(ItemTags.BOW_ENCHANTABLE).add(ModItems.CURVED_BOW.getKey());
    }

}
