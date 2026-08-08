# Changelog

All notable changes to this project are documented in this file.

## [Unreleased]

### Added

- Added the **Metal Detector** item (`examplemod:metal_detector`) with 64 durability.
- The Metal Detector scans vertically downward from the selected block for ores in the common `c:ores` tag.
- On finding a valuable ore, the detector reports its block name and coordinates, plays an amethyst chime, and shows block particles.
- Added a localized message for unsuccessful scans: `No valuables found.`
- Added the Metal Detector item texture and generated item-definition/model files.
- Added the **Onion** food item (`examplemod:onion`). It restores 2 hunger points with 0.3 saturation and takes 2.1 seconds to consume.
- Eating an Onion has a 10% chance to apply Nausea for 400 ticks (20 seconds).
- Added the Onion texture, localization, item definition, and item model.
- Added the **End Fire Starter** fuel item (`examplemod:end_fire_starter`), which stacks to 32.
- Each End Fire Starter burns for 4,800 furnace ticks (4 minutes), enough to smelt 24 standard items.
- Added the End Fire Starter texture, localization, item definition, and item model.
- Added the **Magic Block** (`examplemod:magic_block`), including its texture, blockstate, item definition, model, and loot table.
- Added **Azurite Stairs** (`examplemod:azurite_stairs`) and **Azurite Slabs** (`examplemod:azurite_slab`) as pickaxe-mineable building blocks that require the correct tool for drops.
- Added crafting recipes: 6 Blocks of Azurite make 4 Azurite Stairs, and 3 Blocks of Azurite make 6 Azurite Slabs.
- Added generated blockstates, models, item definitions, loot tables, recipe advancements, and localized tooltips for Azurite Stairs and Slabs.
- Added **Azurite Pressure Plate** (`examplemod:azurite_pressure_plate`) and **Azurite Button** (`examplemod:azurite_button`) redstone components.
- Added recipes: 2 Azurite make a pressure plate, and 1 Azurite makes a button. The button uses iron-button behavior with a 20-tick press duration.
- Added generated models, blockstates, item definitions, loot tables, recipe advancements, block tags, and localized tooltips for the Azurite Pressure Plate and Button.
- Added **Azurite Fence** (`examplemod:azurite_fence`), **Azurite Fence Gate** (`examplemod:azurite_fence_gate`), and **Azurite Wall** (`examplemod:azurite_wall`).
- Added recipes: 4 Azurite and 2 sticks make 3 fences; 2 Azurite and 4 sticks make a fence gate; and 6 Blocks of Azurite make 6 walls.
- Added generated models, blockstates, item definitions, loot tables, recipe advancements, and standard fence, fence-gate, and wall tags for the Azurite fencing set.
- Empty-hand use of the Magic Block produces an end-rod particle and an amethyst sound.
- Players standing on the Magic Block receive the Glowing effect for 300 ticks (15 seconds).
- Item entities containing iron-ore-tagged items, redstone, copper ingots, or Azurite transform one-for-one into diamonds when they touch the Magic Block.
- Added an Onion tooltip: `Tasts like Onion.`
- Added a Magic Block tooltip identifying it as magical.
- Added Shift-sensitive Metal Detector tooltips: the default prompt asks players to hold Shift, while the expanded tooltip explains how to discover valuables.

### Changed

- Added the Metal Detector to the **Example Items** Creative Mode tab.
- Added Onion to the **Example Items** Creative Mode tab.
- Added End Fire Starter to the **Example Items** Creative Mode tab.
- Added Metal Detector model generation to the data-generation provider.
- Added Onion model generation to the data-generation provider.
- Added a NeoForge furnace-fuel data-map provider and generated fuel data for the End Fire Starter.
- Added the Magic Block to the **Example Blocks** Creative Mode tab.
- Added Azurite Stairs and Slabs to the **Example Blocks** Creative Mode tab.
- Added the Azurite Pressure Plate and Button to the **Example Blocks** Creative Mode tab.
- Added the Azurite Fence, Fence Gate, and Wall to the **Example Blocks** Creative Mode tab.
- Added Magic Block model generation, pickaxe mining-tag data, and self-drop loot generation.
- Added block-family model generation, pickaxe mining tags, and loot handling for Azurite Stairs and Slabs.
- Added block-family model generation and standard button/pressure-plate tags for the Azurite redstone components.
- Added block-family model generation and self-drop loot handling for the Azurite fencing set.
- Added data-generated item and block tags: `examplemod:transformable_items` configures Magic Block transmutation inputs, and `examplemod:metal_detectables` includes all `c:ores` for the Metal Detector.
- Updated the project requirement to NeoForge `26.2.0.52-beta`.
- Updated the Azurite Button and Pressure Plate recipes and unlock criteria to use Azurite instead of Blocks of Azurite.
