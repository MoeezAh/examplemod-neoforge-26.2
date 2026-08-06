# Example Mod — Azurite Content

A Minecraft content mod built with [NeoForge](https://neoforged.net/). It introduces Azurite resources, ores, storage blocks, recipes, and dedicated Creative Mode tabs.

## Compatibility

- Minecraft `26.2`
- NeoForge `26.2.0.41-beta` or newer
- Mod ID: `examplemod`

## Content

### Items

- **Raw Azurite** — the unprocessed Azurite resource.
- **Azurite** — the processed resource currently registered in-game as `examplemod:azurite`.
- **Metal Detector** — a 64-use tool for finding iron and diamond ores below the selected block.
- **Onion** — a consumable food item that restores 2 hunger points and 0.3 saturation.

### Onion

Eating an Onion takes 2.1 seconds. Each serving has a 10% chance to apply **Nausea** for 20 seconds.

### Metal Detector

Use the Metal Detector on a block to scan vertically downward, starting at the selected block, for the first iron or diamond ore, including their deepslate variants. When it finds one, the detector reports the block name and coordinates, plays an amethyst chime, and shows block particles. If nothing is found, it displays **"No valuables found."** Each use consumes one durability point.

### Blocks

- Block of Azurite
- Block of Raw Azurite
- Azurite Ore
- Deepslate Azurite Ore
- Nether Azurite Ore
- End Azurite Ore
- Magic Block

The ore variants award experience when mined. Azurite and Raw Azurite blocks require the correct harvesting tool and use an amethyst-like sound; ore blocks likewise require the correct tool.

### Magic Block

The Magic Block is a pickaxe-mineable block that drops itself when broken. Use it with an empty hand to create an end-rod particle and play an amethyst sound. Players who stand on it receive the **Glowing** effect for 15 seconds. Item entities that touch it transform one-for-one into diamonds when they contain an iron ingot, Azurite, or redstone.

## Obtaining Azurite

- Smelt or blast Raw Azurite or any Azurite ore variant to obtain Azurite.
- Smelting awards `0.25` experience and takes 100 ticks; blasting takes 50 ticks.
- Craft nine Azurite into one Block of Azurite.
- Break down one Block of Azurite into nine Azurite.
- Combine a Block of Azurite with Blaze Powder to receive eighteen Azurite.

## Creative Mode

The mod includes two Creative Mode tabs:

- **Example Items**: Raw Azurite, Azurite, the Metal Detector, and Onion.
- **Example Blocks**: All Azurite blocks and ore variants, plus the Magic Block.

Raw Azurite and Azurite are also available in Minecraft's Ingredients tab, and the Block of Azurite appears in Building Blocks.

## Installation

1. Install the compatible NeoForge version for Minecraft 26.2.
2. Place the built mod JAR in your instance's `mods` folder.
3. Launch Minecraft using the NeoForge profile.

## Building from Source

Run the following from the project root on Windows:

```powershell
.\gradlew.bat build
```

The built JAR will be written to `build/libs`.

## Changelog

See [CHANGELOG.md](CHANGELOG.md) for the complete record of unreleased changes, including the Metal Detector, Magic Block, and Onion.

## License

This project is marked as `MIT Reserved` in its mod metadata.
