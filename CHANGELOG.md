# Changelog

All notable changes to this project are documented in this file.

## [Unreleased]

### Added

- Added the **Metal Detector** item (`examplemod:metal_detector`) with 64 durability.
- The Metal Detector scans vertically downward from the selected block for iron ore, deepslate iron ore, diamond ore, and deepslate diamond ore.
- On finding a valuable ore, the detector reports its block name and coordinates, plays an amethyst chime, and shows block particles.
- Added a localized message for unsuccessful scans: `No valuables found.`
- Added the Metal Detector item texture and generated item-definition/model files.
- Added the **Magic Block** (`examplemod:magic_block`), including its texture, blockstate, item definition, model, and loot table.
- Empty-hand use of the Magic Block produces an end-rod particle and an amethyst sound.
- Players standing on the Magic Block receive the Glowing effect for 300 ticks (15 seconds).
- Item entities containing iron ingots, Azurite, or redstone transform one-for-one into diamonds when they touch the Magic Block.

### Changed

- Added the Metal Detector to the **Example Items** Creative Mode tab.
- Added Metal Detector model generation to the data-generation provider.
- Added the Magic Block to the **Example Blocks** Creative Mode tab.
- Added Magic Block model generation, pickaxe mining-tag data, and self-drop loot generation.
