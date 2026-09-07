package com.example.examplemod.villager;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.blocks.ModBlocks;
import com.example.examplemod.datagen.Villager.ModTradeSets;
import com.google.common.collect.ImmutableSet;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillager {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister
            .create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, ExampleMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister
            .create(BuiltInRegistries.VILLAGER_PROFESSION, ExampleMod.MOD_ID);

    public static final Holder<PoiType> KAUPER_POI = POI_TYPES.register("kauper_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.MAGIC_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final Holder<VillagerProfession> KAUPENGER = VILLAGER_PROFESSIONS.register("kaupenger",
            () -> new VillagerProfession(Component.literal("Kaupenger"),
                    holder -> holder.value() == KAUPER_POI.value(),
                    holder -> holder.value() == KAUPER_POI.value(),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.AMETHYST_BLOCK_CHIME,
                    Int2ObjectMap.ofEntries(
                            Int2ObjectMap.entry(1, ModTradeSets.KAUPENGER_LEVEL_1),
                            Int2ObjectMap.entry(2, ModTradeSets.KAUPENGER_LEVEL_2))));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
