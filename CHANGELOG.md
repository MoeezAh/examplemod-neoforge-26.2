# Changelog

All notable changes to this project are documented in this file.

## [Unreleased]

### Added

- Added the **Metal Detector** item (`examplemod:metal_detector`) with 64 durability.
- The Metal Detector scans vertically downward from the selected block for iron ore, deepslate iron ore, diamond ore, and deepslate diamond ore.
- On finding a valuable ore, the detector reports its block name and coordinates, plays an amethyst chime, and shows block particles.
- Added a localized message for unsuccessful scans: `No valuables found.`
- Added the Metal Detector item texture and generated item-definition/model files.

### Changed

- Added the Metal Detector to the **Example Items** Creative Mode tab.
- Added Metal Detector model generation to the data-generation provider.
