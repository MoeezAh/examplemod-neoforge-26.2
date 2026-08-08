package com.example.examplemod.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.blocks.ModBlocks;
import com.example.examplemod.item.ModItems;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.AbstractCookingRecipe.Factory;
import net.minecraft.world.level.ItemLike;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        public String getName() {
            return "Example Mod Recipes";
        }

        @Override
        protected RecipeProvider createRecipeProvider(Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

    }

    @Override
    protected void buildRecipes() {
        // nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.AZURITE,
        // RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_BLOCK,
        // getSimpleRecipeName(ModBlocks.AZURITE_BLOCK), ExampleMod.MOD_ID + ":" +
        // getSimpleRecipeName(ModBlocks.AZURITE_BLOCK),
        // getSimpleRecipeName(ModBlocks.AZURITE_BLOCK), ExampleMod.MOD_ID + ":" +
        // getSimpleRecipeName(ModBlocks.AZURITE_BLOCK)
        // );

        shaped(RecipeCategory.MISC, ModBlocks.AZURITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurites")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 9)
                .requires(ModBlocks.AZURITE_BLOCK)
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                // .group("azurites")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 18)
                .requires(ModBlocks.AZURITE_BLOCK)
                .requires(Items.BLAZE_POWDER)
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurites")
                .save(output, "examplemod:azurite_from_blaze_powder");

        List<ItemLike> AZURITE_SMELTABLES = List.of(ModItems.RAW_AZURITE,
                ModBlocks.AZURITE_ORE,
                ModBlocks.AZURITE_DEEPSLATE_ORE,
                ModBlocks.AZURITE_NETHER_ORE,
                ModBlocks.AZURITE_END_ORE);

        oreSmelting(AZURITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.AZURITE.get(), 0.25f,
                100, "azurite");
        oreBlasting(AZURITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.AZURITE.get(), 0.25f,
                50, "azurite");

        stairBuilder(ModBlocks.AZURITE_STAIRS.get(), Ingredient.of(ModBlocks.AZURITE_BLOCK))
                .unlockedBy(getHasName(ModBlocks.AZURITE_BLOCK.get()), has(ModBlocks.AZURITE_BLOCK))
                // .group("azurite")
                .save(output);

        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_SLAB, ModBlocks.AZURITE_BLOCK);

        buttonBuilder(ModBlocks.AZURITE_BUTTON, Ingredient.of(ModItems.AZURITE))
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                // .group("azurite")
                .save(output);

        pressurePlate(ModBlocks.AZURITE_PRESSURE_PLATE, ModItems.AZURITE);

        fenceBuilder(ModBlocks.AZURITE_FENCE, Ingredient.of(ModItems.AZURITE))
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                // .group("azurite")
                .save(output);

        fenceGateBuilder(ModBlocks.AZURITE_FENCE_GATE, Ingredient.of(ModItems.AZURITE))
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                // .group("azurite")
                .save(output);

        wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_WALL, ModBlocks.AZURITE_BLOCK);

        doorBuilder(ModBlocks.AZURITE_DOOR, Ingredient.of(ModItems.AZURITE))
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                // .group("azurite")
                .save(output);

        trapdoorBuilder(ModBlocks.AZURITE_TRAPDOOR, Ingredient.of(ModItems.AZURITE))
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                // .group("azurite")
                .save(output);

    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(Factory<T> factory, List<ItemLike> smeltables,
            RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience,
            int cookingTime, String group, String fromDesc) {
        for (ItemLike item : smeltables) {
            SimpleCookingRecipeBuilder
                    .generic(Ingredient.of(item), craftingCategory, cookingCategory, result, experience, cookingTime,
                            factory)
                    .group(group).unlockedBy(getHasName(item), this.has(item))
                    .save(this.output,
                            ExampleMod.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(item));
        }
    }

}
