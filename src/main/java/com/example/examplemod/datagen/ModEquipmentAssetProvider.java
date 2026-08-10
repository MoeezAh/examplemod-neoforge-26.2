package com.example.examplemod.datagen;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.ModArmorMaterials;
import com.mojang.serialization.Codec;

import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class ModEquipmentAssetProvider implements DataProvider {
    private final PackOutput.PathProvider pathProvider;

    public ModEquipmentAssetProvider(PackOutput packOutput) {
        this.pathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    private static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(ModArmorMaterials.AZURITE_KEY, EquipmentClientInfo.builder()
                .addHumanoidLayers(Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "azurite"), false)
                .build());
    }

    public CompletableFuture<?> run(CachedOutput cache) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssets = new HashMap();
        bootstrap((id, asset) -> {
            if (equipmentAssets.putIfAbsent(id, asset) != null) {
                throw new IllegalStateException(
                        "Tried to register equipment asset twice for id: " + String.valueOf(id));
            }
        });
        Codec var10001 = EquipmentClientInfo.CODEC;
        PackOutput.PathProvider var10002 = this.pathProvider;
        Objects.requireNonNull(var10002);
        return DataProvider.saveAll(cache, var10001, var10002::json, equipmentAssets);
    }

    @Override
    public String getName() {
        return "ExampleMod Equipment Asset Definitions";
    }

}
