package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.potion.ModPotions;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = ExampleMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity() instanceof Sheep sheep && event.getSource().getDirectEntity() instanceof Player player) {
            if (player.getMainHandItem().is(Items.END_ROD)) {
                player.sendSystemMessage(Component
                        .literal(player.getName().getString() + " just hit a sheep with an end rod. Where did it go?"));
                player.getMainHandItem().shrink(1);
                sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 5));
            }
        }
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        // Example of how to register a brewing recipe
        // BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTION),
        // Ingredient.of(Items.NETHER_WART), new ItemStack(Items.POTION, 1));
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Blocks.DIRT.asItem(), ModPotions.STINKY_POTION);
    }
}
