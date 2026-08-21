package com.example.examplemod.datagen;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.sound.ModSounds;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundsProvider extends SoundDefinitionsProvider {

    public ModSoundsProvider(PackOutput output) {
        super(output, ExampleMod.MOD_ID);
    }

    @Override
    public void registerSounds() {
        add(ModSounds.VALUABLES_FOUND.get(), definition().subtitle("sounds.examplemod.valuables_found")
                .with(sound(Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "valuables_found"))));

        add(ModSounds.VALUABLES_NOT_FOUND.get(), definition().subtitle("sounds.examplemod.valuables_not_found")
                .with(sound(Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "valuables_not_found"))));
    }

}
