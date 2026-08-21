# Changelog

Changes are listed in chronological order, from oldest to newest.

## 2026-08-05

- Established the Azurite content foundation: resources, ore variants, storage blocks, recipes, loot tables, models, and advancements.
- Added the Metal Detector, which scans downward for ores and reports its first find.
- Added the Magic Block with interaction effects, a Glowing effect for players standing on it, and diamond transmutation for configured items.

## 2026-08-06

- Added Onion, a food item that restores hunger and has a chance to cause Nausea.
- Added End Fire Starter, a 4,800-tick furnace fuel.
- Added tooltips for Onion, Magic Block, and Metal Detector.
- Added configurable tags for Metal Detector targets and Magic Block transmutation inputs.

## 2026-08-07

- Added Azurite Stairs and Slabs, with crafting recipes, loot behavior, models, tooltips, and Creative Mode availability.
- Added Azurite Pressure Plate and Button redstone components, including recipes, tags, models, tooltips, and Creative Mode availability.

## 2026-08-08

- Added Azurite Fence, Fence Gate, and Wall with recipes, loot behavior, tags, models, and Creative Mode availability.
- Added redstone-operated Azurite Door and Trapdoor with recipes, textures, tags, loot behavior, and Creative Mode availability.
- Changed the Azurite Button and Pressure Plate recipes to use Azurite instead of Blocks of Azurite.
- Updated the NeoForge requirement to `26.2.0.52-beta`.

## 2026-08-10

- Added the Azurite Sword, Pickaxe, Axe, Shovel, Hoe, and Spear, including recipes, tool tags, repair support, textures, and a dedicated held-spear model.
- Added the Azurite armor set: Helmet, Chestplate, Leggings, and Boots, with recipes, equipment assets, armor trims, and Creative Mode availability.
- Added Azurite Horse Armor with a dedicated horse equipment texture and Creative Mode availability.
- Updated the NeoForge requirement to `26.2.0.57`.

## 2026-08-11

- Added Azurite Lamp, an empty-hand-toggleable light block that emits light level 15 when on, with on/off models, textures, loot data, and Creative Mode availability.
- Added the Data Tablet, a utility item that stores the last ore coordinates detected by the Metal Detector, displays them in the tooltip, and clears them when used.

## 2026-08-14

- Added the Curved Bow, a ranged weapon with 500 durability that supports bow-specific enchantments, including bow pull-state animations and textures, and Creative Mode availability.
- Added FOV zoom mechanic for the Curved Bow: drawing the bow gradually reduces field of view for improved aiming feedback.
- Added End Rod + Sheep interaction: hitting a Sheep with an End Rod applies Poison II for 30 seconds and consumes the End Rod.
- Added the Blizzard Staff, a staff item with a unique 3D model and single-item stack limit, with Creative Mode availability.
- Added the Pedestal, a decorative block with a narrow column design, pickaxe-mineable with correct tool requirement, and Creative Mode availability.
- Updated mod version to `1.0.0-26.2`.

## 2026-08-15

- Added three custom paintings by NanoAttack: Shrimp (2×1), Saw Them (2×2), and World (2×2).
- Added custom stat tracking: Metal Detector now increments the **Valuables Found** statistic when a valuable block is discovered.

## 2026-08-19

- Updated the NeoForge requirement to `26.2.0.64`.
- Added an Azurite block icon and banner image for the mod's NeoForge UI metadata.

## 2026-08-20

- Renamed the Curved Bow item registry ID from `example_bow` to `curved_bow` for consistency.
- Fixed the language key from `exmaple_bow` (typo) to `curved_bow` in en_us.json.
- Updated the Magic Block's transformable items to use `minecraft:iron_ingot` instead of the iron ores tag, making only iron ingots transformable to diamonds.
- Renamed creative mode tabs: "Example Items" → "Azurite Items" and "Example Blocks" → "Azurite Building Blocks" for better mod branding.
- Updated the NeoForge moddev plugin from version 2.0.143 to 2.0.144.
- Code cleanup: removed unused imports and reformatted item tag provider entries for better readability.
- Added Onion Seeds and a four-stage Onion Crop with generated models, textures, loot, and crop tags.
- Fully grown Onion Crops drop Onions and Onion Seeds; immature crops drop seeds.
- Added Onion Seeds to the Azurite Items Creative Mode tab.
- Added composting support for Onion Seeds (30% chance) and Onions (50% chance).

## 2026-08-21

- Added the Goji Berry Bush, a multi-stage crop-like block that drops Goji Berries when harvested.
- Added Goji Berries as a food item with custom berry-bush growth and harvest behavior.
- Added generated block models, textures, and loot tables for the Goji Berry Bush.
- Added Goji Berries to the Azurite Items Creative Mode tab.
- Added Rice Crop support with a water-dependent crop block and Rice Shoot placement item.
- Added generated Rice Crop models, textures, and loot tables for the new crop lifecycle.
- Added Rice Shoot to the Azurite Items Creative Mode tab.
- Added custom Metal Detector sounds for successful finds and failed scans, with sound definitions registered through the mod's data generation pipeline.
