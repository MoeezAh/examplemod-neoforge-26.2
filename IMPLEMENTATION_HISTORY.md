# Mod Feature Implementation Guide

This document is a reusable cookbook for the features implemented in this NeoForge 26.2 mod. It is organized by feature, not by commit. Related work is grouped together so each section explains what to add, where to add it, and which supporting resources are required.

## Feature Index

- [Project and registry foundation](#project-and-registry-foundation)
- [Normal item](#normal-item)
- [Food item](#food-item)
- [Furnace fuel](#furnace-fuel)
- [Tooltips](#tooltips)
- [Resource blocks and ores](#resource-blocks-and-ores)
- [Building and redstone blocks](#building-and-redstone-blocks)
- [Interactive blocks](#interactive-blocks)
- [Stateful light block](#stateful-light-block)
- [Custom-shaped block](#custom-shaped-block)
- [Metal detector or scanning tool](#metal-detector-or-scanning-tool)
- [Data-driven tags](#data-driven-tags)
- [Tools and tool material](#tools-and-tool-material)
- [Armor and horse armor](#armor-and-horse-armor)
- [Persistent item state](#persistent-item-state)
- [Curved bow](#curved-bow)
- [Crops](#crops)
- [Berry bush](#berry-bush)
- [Composting](#composting)
- [Custom sounds](#custom-sounds)
- [Music disc](#music-disc)
- [Paintings](#paintings)
- [Custom statistic](#custom-statistic)
- [Mob effect](#mob-effect)
- [Potion and brewing recipe](#potion-and-brewing-recipe)
- [Custom damage type](#custom-damage-type)
- [Recipes, loot, models, and language](#recipes-loot-models-and-language)
- [Validation workflow](#validation-workflow)

## Project and Registry Foundation

Before adding content, create or use the shared mod structure:

- Define one `MOD_ID` in the main `@Mod` class.
- Create `DeferredRegister.Items`, `DeferredRegister.Blocks`, and specialized registers as needed.
- Register every register on the mod event bus in the main mod constructor.
- Register datagen providers from the `GatherDataEvent` handler.
- Keep runtime behavior in feature classes and construction/registration in registry classes.
- Include `src/generated/resources` in the resource set.

```java
public static final DeferredRegister.Items ITEMS =
        DeferredRegister.createItems(ExampleMod.MOD_ID);

public static final DeferredRegister.Blocks BLOCKS =
        DeferredRegister.createBlocks(ExampleMod.MOD_ID);

public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
    BLOCKS.register(eventBus);
}
```

## Normal Item

In `ModItems`, register the item and configure its properties:

```java
public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerItem(
        "example_item", properties -> new Item(properties));
```

Then add it to a creative tab, generate a flat item model, add a PNG under `assets/examplemod/textures/item`, and add `item.examplemod.example_item` to `en_us.json`. Add tags, recipes, data maps, or a custom item class if the item needs special behavior. Use `properties.stacksTo(1)` for a single-stack item and `properties.durability(value)` for a durable item.

## Food Item

Define food values and consumption behavior in `ModFoods`:

```java
public static final FoodProperties EXAMPLE_FOOD = new FoodProperties.Builder()
        .nutrition(2)
        .saturationModifier(0.3f)
        .build();

public static final Consumable EXAMPLE_CONSUMABLE = Consumables.defaultFood()
        .consumeSeconds(2.1f)
        .onConsume(new ApplyStatusEffectsConsumeEffect(
                new MobEffectInstance(MobEffects.NAUSEA, 400), 0.10f))
        .build();
```

Attach both to the item registration:

```java
ITEMS.registerItem("example_food",
        properties -> new Item(properties.food(EXAMPLE_FOOD, EXAMPLE_CONSUMABLE)));
```

Add the model, texture, translation, creative-tab entry, and tooltip if needed. The Onion uses nutrition 2, saturation 0.3, 2.1-second consumption, and a 10% chance of Nausea for 400 ticks. Goji Berries use the same food-registration pattern with their own food values.

## Furnace Fuel

Register the item normally and add a NeoForge data-map entry in `ModDataMapProvider`:

```java
builder(NeoForgeDataMaps.FURNACE_FUELS)
        .add(ModItems.END_FIRE_STARTER.getId(), new FurnaceFuel(4800), false);
```

Register the provider from `ExampleModDataGen`, generate the data, and add the item's model, texture, translation, and creative-tab entry. The End Fire Starter burns for 4,800 ticks and stacks to 32.

## Tooltips

Override `appendHoverText` and use translation keys instead of hard-coded player-facing text:

```java
@Override
public void appendHoverText(ItemStack stack, TooltipContext context,
        TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
    tooltip.accept(Component.translatable("tooltip.examplemod.example_item"));
    super.appendHoverText(stack, context, display, tooltip, flag);
}
```

For Shift-sensitive help, check `Minecraft.getInstance().hasShiftDown()` in the tooltip path and provide separate translation keys. For block items, let the block-item registration helper accept optional tooltip components and call the superclass afterward.

## Resource Blocks and Ores

Register storage blocks with `Block` and ores with `DropExperienceBlock`:

```java
public static final DeferredBlock<Block> EXAMPLE_ORE = registerBlock(
        "example_ore",
        properties -> new DropExperienceBlock(UniformInt.of(2, 4), properties
                .strength(2f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)));
```

For a complete ore feature:

1. Register the block and dropped item.
2. Configure strength, sound, experience, and correct-tool behavior.
3. Add mining and tool tags.
4. Generate blockstates, cube models, and item models.
5. Generate ore loot with `createOreDrop`, Fortune, and Silk Touch behavior.
6. Add smelting and blasting recipes when the ore is processed.
7. Add textures, translations, creative-tab entries, and recipe advancements.

The Azurite system applies this pattern to normal, deepslate, Nether, and End ore variants, with different experience ranges.

## Building and Redstone Blocks

Use the matching vanilla block classes for related block families:

```java
new StairBlock(ModBlocks.AZURITE_BLOCK.get().defaultBlockState(), properties)
new SlabBlock(properties)
new PressurePlateBlock(BlockSetType.IRON, properties)
new ButtonBlock(BlockSetType.IRON, 20, properties)
new FenceBlock(properties)
new FenceGateBlock(WoodType.ACACIA, properties)
new WallBlock(properties)
new DoorBlock(BlockSetType.IRON, properties)
new TrapDoorBlock(BlockSetType.IRON, properties)
```

For each block, add a registry entry and block item, model/blockstate generation, recipe and recipe advancement, loot behavior, correct-tool tags, texture, language key, and creative-tab entry. Use `createSlabItemTable` for slabs and `createDoorTable` for doors. The Azurite project uses this sequence for stairs, slabs, pressure plates, buttons, fences, fence gates, walls, doors, and trapdoors.

## Interactive Blocks

Create a custom class extending `Block` when a block needs behavior. Use:

- `useWithoutItem` for right-click interactions.
- `stepOn` for entities walking onto it.
- Placement/update methods for neighbor-dependent behavior.

Keep mutations server-side and emit sounds, particles, and game events with the interaction. The Magic Block uses right-click behavior for particles and sound, applies Glowing to players standing on it, and converts tagged item entities into diamonds.

## Stateful Light Block

For a block with an on/off state:

1. Define a `BooleanProperty`, such as `CLICKED`.
2. Add it in `createBlockStateDefinition`.
3. Set its default value.
4. Toggle it in `useWithoutItem`.
5. Configure light with `.lightLevel(state -> state.getValue(CLICKED) ? 15 : 0)`.
6. Generate separate on/off models and a boolean blockstate using `MultiVariantGenerator`.
7. Add self-drop loot, tool tags, textures, translations, and a creative-tab entry.

The Azurite Lamp follows this property, state, runtime toggle, and model-variant pattern.

## Custom-Shaped Block

Create a class extending `Block`, define a `VoxelShape`, and return it from `getShape`:

```java
private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);

@Override
public VoxelShape getShape(BlockState state, BlockGetter level,
        BlockPos pos, CollisionContext context) {
    return SHAPE;
}
```

Register the block with its strength and tool requirement, use a custom model provider path, add self-drop loot and tool tags, then add the Blockbench model, texture, language entry, and creative-tab entry. The Pedestal uses this approach.

## Metal Detector or Scanning Tool

Extend `Item`, give it durability, and override `useOn(UseOnContext)`:

1. Read the clicked position, level, player, and held stack.
2. Run the scan on the server side.
3. Iterate through blocks below the clicked position.
4. Query a block tag instead of hard-coding every target.
5. Report success or failure to the player.
6. Play a sound and spawn particles for feedback.
7. Update related state, such as a Data Tablet or statistic.
8. Damage the item after use.

The Metal Detector scans downward for the first detectable block, reports its name and coordinates, stores the result in a tablet when available, awards the custom statistic, and plays separate success/failure sounds.

## Data-Driven Tags

Define namespaced tags in `ModTags`:

```java
public static final TagKey<Block> METAL_DETECTABLES =
        BlockTags.create(Identifier.fromNamespaceAndPath(
                ExampleMod.MOD_ID, "metal_detectables"));
```

Generate entries in the matching tag provider and query tags at runtime:

```java
if (blockState.is(ModTags.Blocks.METAL_DETECTABLES)) {
    // Handle a detectable block.
}
```

Use `ItemStack.is(tag)` for item tags. This project uses tags for detector targets, Magic Block inputs, Azurite tool and armor classification, crops, farmland maintenance, and creeper music-disc drops.

## Tools and Tool Material

Define a tool tier/material with durability, mining speed, attack bonus, enchantability, and repair ingredient. Register each tool with the appropriate helper:

```java
ITEMS.registerItem("example_pickaxe",
        properties -> new Item(properties.pickaxe(ModToolTier.EXAMPLE, 1, -2.8f)));
```

Use the matching constructors/helpers for swords, axes, shovels, hoes, and spears. Add tool/mining tags, repair tags, shaped recipes, recipe advancements, item models, textures, translations, and creative-tab entries. Add a dedicated held-item model when first-person visuals need special treatment.

The Azurite tool material uses 1,200 durability, mining speed 3, attack bonus 3, enchantability 22, and Azurite as its repair ingredient.

## Armor and Horse Armor

Define an armor material with durability, defense values, toughness, knockback resistance, enchantability, repair ingredient, and equipment texture. Register each armor slot:

```java
ITEMS.registerItem("example_helmet", properties -> new Item(
        properties.humanoidArmor(ModArmorMaterials.EXAMPLE, ArmorType.HELMET)));
```

For a complete armor set:

1. Define the material and its equipment asset/layer.
2. Register helmet, chestplate, leggings, and boots.
3. Generate armor recipes, item models, equipment assets, and armor-slot tags.
4. Add armor textures and trim-compatible definitions.
5. Add language and creative-tab entries.

For horse armor, register `properties.horseArmor(material)`, add a `HORSE_BODY` equipment layer, generate the item model, add the horse texture, and expose it in the Combat tab. The Azurite armor uses durability multiplier 1,200, defenses 5/9/7/5, toughness 2, knockback resistance 0.1, and enchantability 16.

## Persistent Item State

Use a data component for state belonging to an individual item stack. In `ModDataComponents`, register a persistent and network-synchronized component:

```java
public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockPos>>
        COORDINATES = DATA_COMPONENTS.registerComponentType("coordinates", builder -> builder
                .persistent(BlockPos.CODEC)
                .networkSynchronized(BlockPos.STREAM_CODEC));
```

Then set the component on the relevant `ItemStack`, read it in the tooltip, remove it when the item clears its state, override `isFoil` when it should glow, and generate a `HasComponent` conditional model. The Data Tablet uses this pattern for the last Metal Detector coordinate.

## Curved Bow

Register a bow and add it to the bow enchantment tag:

```java
public static final DeferredItem<Item> CURVED_BOW = ITEMS.registerItem(
        "curved_bow", properties -> new BowItem(properties.durability(500)));
```

Generate the base model and three pull-stage models with `ModelTemplates.BOW` and `generateBow`. Add four matching textures: base, pull 0, pull 1, and pull 2. Add the item to the creative tab and language file.

For draw zoom, subscribe to `ComputeFovModifierEvent` in the client entry point, check that the player is using this bow, calculate a clamped draw-progress value from use ticks, and multiply the FOV modifier by the desired reduction. Keep client-only FOV code separate from common gameplay code.

## Crops

For a normal farmland crop, extend `CropBlock` or `BeetrootBlock`:

```java
public class ExampleCropBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    public ExampleCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.EXAMPLE_SEEDS;
    }
}
```

Then define the age range, register a random-ticking crop, register seeds as a `BlockItem`, generate one model per stage and the blockstate, generate age-conditional loot, add `BlockTags.CROPS` and `BlockTags.MAINTAINS_FARMLAND`, and add textures, translations, and creative-tab entries.

The Onion Crop uses ages 0-3, farmland support, and mature loot containing Onions and Onion Seeds.

For a water crop, override survival and use `PlaceOnWaterBlockItem`:

```java
@Override
protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    return level.getBlockState(pos.below()).is(Blocks.WATER);
}

public static final DeferredItem<Item> RICE_SHOOT = ITEMS.registerItem(
        "rice_shoot", properties -> new PlaceOnWaterBlockItem(
                ModBlocks.RICE_CROP.get(), properties));
```

The Rice Crop uses ages 0-7 and only survives with water below it. Generate all eight stage models, the item model, blockstate, textures, and mature-crop loot.

## Berry Bush

Extend `SweetBerryBushBlock` when the crop should be harvested by right-clicking the planted block:

1. Override the clone item so the bush gives the berry item.
2. In `useWithoutItem`, check the age and harvest at the desired stages.
3. Drop a random number of berries and an extra berry at full maturity.
4. Play the berry-picking sound.
5. Reset the bush to a lower age and emit a block-change game event.
6. Generate age-specific models/blockstates and Fortune-aware loot.
7. Register the berry as food if edible and add its translation and creative-tab entry.

The Goji Berry Bush harvests at ages 2 and 3, drops 1-3 berries plus an extra mature berry, and resets to age 1.

## Composting

Use the NeoForge compostable data map in `ModDataMapProvider`:

```java
builder(NeoForgeDataMaps.COMPOSTABLES)
        .add(ModItems.ONION_SEED.getId(), new Compostable(0.3F), false)
        .add(ModItems.ONION.getId(), new Compostable(0.5F), false);
```

The value is the chance that an item increases the composter level. Register the provider with datagen and regenerate JSON after changes.

## Custom Sounds

Create a deferred sound-event register:

```java
public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
        DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, ExampleMod.MOD_ID);
```

For each sound, register a `SoundEvent`, add an OGG file under `assets/examplemod/sounds`, create a `SoundDefinitionsProvider` entry with a subtitle and sound identifier, register the provider with datagen, register the sound events on the mod bus, and play them from runtime code. Add subtitle translations and inspect generated `sounds.json`.

The Metal Detector has separate custom sounds for successful and unsuccessful scans.

## Music Disc

A music disc needs an audio event, jukebox data, an item, and optional drop integration:

1. Register the sound event and add a streamed OGG sound definition.
2. Define a jukebox-song `ResourceKey` and bootstrap its `JukeboxSong` through `ModDataPackProvider`.
3. Register the item with stack size 1, EPIC rarity, and `.jukeboxPlayable(...)`.
4. Generate its flat item model and add the disc texture and translation.
5. Add it to the mod creative tab.
6. Add it to `CREEPER_DROP_MUSIC_DISCS` if creepers should drop it.
7. Generate and inspect sound, jukebox, model, and tag JSON.

The Bar Brawl disc follows this sequence and uses streamed audio with a 162-second jukebox song.

## Paintings

Painting variants are dynamic datapack registry entries, not ordinary deferred items:

1. Define `ResourceKey<PaintingVariant>` values.
2. Bootstrap each `PaintingVariant` with width, height, title, and author translation keys.
3. Add the painting registry to the `RegistrySetBuilder` in `ModDataPackProvider`.
4. Add variants to `PaintingVariantTags.PLACEABLE`.
5. Add painting textures and title/author translations.
6. Run datagen to generate variant data and the placeable tag.

This mod contains Shrimp, Saw Them, and World painting variants.

## Custom Statistic

Create `ModStats` and register a custom statistic through `BuiltInRegistries.CUSTOM_STAT`. Register it during mod initialization and award it at the successful point in runtime code:

```java
player.awardStat(ModStats.VALUABLES_FOUND.get(), 1);
```

Add `stat.examplemod.valuables_found` to the language file. The Metal Detector awards its statistic only after finding a valuable block.

## Mob Effect

Register a deferred `MobEffect` and put behavior in a custom effect class:

1. Create `ModEffects` and register it on the mod event bus.
2. Extend `MobEffect` with the desired category and color.
3. Override the server-side tick method.
4. Find nearby living entities from an expanded owner bounding box.
5. Apply amplifier-scaled behavior and avoid damaging the owner unless intended.
6. Add the effect icon, display name, description, and test access.

The Stinky effect expands its radius with `amplifier + 1` and damages nearby entities every tick for `0.25 * (amplifier + 1)`.

## Potion and Brewing Recipe

Register the potion after the effect exists:

```java
public static final DeferredHolder<Potion, Potion> STINKY_POTION = POTIONS.register(
        "stinky_potion", () -> new Potion(new MobEffectInstance(
                ModEffects.STINKY, 1200, 0)));
```

Then register the potion register on the mod event bus, subscribe to `RegisterBrewingRecipesEvent` in a common event class, and add the base potion plus ingredient:

```java
event.getBuilder().addRecipe(
        new BrewingRecipe(Items.POTION, Items.DIRT, ModPotions.STINKY_POTION));
```

Use the exact brewing-recipe API required by the target NeoForge version. Verify splash and lingering conversions, add translations, and test with a brewing stand and commands. The Stinky Potion applies Stinky for 1,200 ticks and is brewed from Awkward Potion plus dirt.

## Custom Damage Type

Custom damage types need both a Java key and a datapack registry entry:

1. Define a `DAMAGE_TYPE` `ResourceKey` in `ModDamageTypes`.
2. Bootstrap `DamageType("stinky", 0.1F, DamageEffects.HURT)`.
3. Add the damage-type registry to `RegistrySetBuilder` in `ModDataPackProvider`.
4. Resolve the holder from `Level.registryAccess()` when damage is dealt.
5. Construct a `DamageSource` from the holder and pass it to `hurtServer`.
6. Add `death.attack.stinky` and `death.attack.stinky.player` translations.
7. Generate the datapack JSON and test the actual death messages.

Defining only the Java resource key is insufficient; datapack bootstrap makes the type available at runtime.

## Recipes, Loot, Models, and Language

For every feature, check the appropriate locations:

- `ModItems` or `ModBlocks`: registry entry and properties.
- `ModCreativeModeTabs`: mod-tab placement.
- `ModModelProvider`: item, block, state, animation, or custom-model generation.
- `ModRecipeProvider`: crafting, smelting, blasting, and recipe advancements.
- `ModBlockLootTableProvider`: block drops and conditional harvest behavior.
- `ModItemTagsProvider` and `ModBlockTagsProvider`: classification, tools, crops, repairs, and drops.
- `ModDataMapProvider`: NeoForge item data such as fuel and composting.
- `ModDataPackProvider`: paintings, jukebox songs, damage types, and other dynamic registries.
- `ModSoundsProvider`: sound definitions and subtitles.
- `en_us.json`: every item, block, effect, potion, statistic, sound subtitle, tooltip, and death-message key.
- `assets/examplemod/textures`: all referenced PNG files.
- `assets/examplemod/sounds`: all referenced OGG files.

## Validation Workflow

After implementing a feature:

1. Run the data generator so generated JSON reflects the providers.
2. Run `./gradlew.bat compileJava` or `./gradlew.bat build`.
3. Run `git diff --check`.
4. Search for the registry ID and confirm every reference uses identical spelling.
5. Check every generated model references an existing texture.
6. Check every custom sound references an existing audio file.
7. Confirm datapack registry entries are included in the registry builder.
8. Test interactive behavior in an actual client/server run.
9. Update `README.md` and `CHANGELOG.md` with user-visible changes.
