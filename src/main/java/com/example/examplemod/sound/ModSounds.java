package com.example.examplemod.sound;

import java.util.function.Supplier;

import com.example.examplemod.ExampleMod;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister
            .create(BuiltInRegistries.SOUND_EVENT, ExampleMod.MOD_ID);

    public static final Supplier<SoundEvent> VALUABLES_FOUND = SOUND_EVENTS.register("vaulables_found", () -> SoundEvent
            .createVariableRangeEvent(Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "valuables_found")));

    public static final Supplier<SoundEvent> VALUABLES_NOT_FOUND = SOUND_EVENTS.register("vaulables_not_found",
            () -> SoundEvent
                    .createVariableRangeEvent(
                            Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "valuables_not_found")));

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
