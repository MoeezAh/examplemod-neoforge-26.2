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
- **End Fire Starter** — a furnace fuel item that stacks to 32.

### End Fire Starter

Each End Fire Starter burns for 4,800 furnace ticks (4 minutes), enough to smelt 24 standard items.

### Onion

Eating an Onion takes 2.1 seconds. Each serving has a 10% chance to apply **Nausea** for 20 seconds. Its tooltip reads, “Tasts like Onion.”

### Metal Detector

Use the Metal Detector on a block to scan vertically downward, starting at the selected block, for the first ore in the common `c:ores` tag. When it finds one, the detector reports the block name and coordinates, plays an amethyst chime, and shows block particles. If nothing is found, it displays **"No valuables found."** Each use consumes one durability point. Hovering it prompts you to hold Shift; holding Shift displays usage guidance.

### Blocks

- Block of Azurite
- Block of Raw Azurite
- Azurite Ore
- Deepslate Azurite Ore
- Nether Azurite Ore
- End Azurite Ore
- Azurite Stairs
- Azurite Slab
- Magic Block

The ore variants award experience when mined. Azurite blocks, stairs, and slabs require the correct pickaxe for drops and use amethyst-like sounds; ore blocks likewise require the correct tool.

### Azurite Building Blocks

Azurite Stairs and Azurite Slabs are decorative building variants of the Block of Azurite. Craft 4 stairs from 6 Blocks of Azurite in the standard stair pattern, or craft 6 slabs from 3 Blocks of Azurite in a row. Stairs drop themselves when broken; a double slab drops 2 slabs. Their tooltips describe them as “The cool Azurite stairs” and “The flat slab of Azurite.”

### Magic Block

The Magic Block is a pickaxe-mineable block that drops itself when broken. Use it with an empty hand to create an end-rod particle and play an amethyst sound. Players who stand on it receive the **Glowing** effect for 15 seconds. Item entities that touch it transform one-for-one into diamonds when they contain an iron-ore-tagged item, redstone, a copper ingot, or Azurite. Its tooltip identifies it as magical.

## Obtaining Azurite

- Smelt or blast Raw Azurite or any Azurite ore variant to obtain Azurite.
- Smelting awards `0.25` experience and takes 100 ticks; blasting takes 50 ticks.
- Craft nine Azurite into one Block of Azurite.
- Break down one Block of Azurite into nine Azurite.
- Combine a Block of Azurite with Blaze Powder to receive eighteen Azurite.

## Creative Mode

The mod includes two Creative Mode tabs:

- **Example Items**: Raw Azurite, Azurite, the Metal Detector, Onion, and End Fire Starter.
- **Example Blocks**: All Azurite blocks and ore variants, including Azurite Stairs and Slabs, plus the Magic Block.

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

See [CHANGELOG.md](CHANGELOG.md) for the complete record of unreleased changes, including the Metal Detector, Magic Block, Onion, End Fire Starter, and Azurite building blocks.

## License

This project is marked as `MIT Reserved` in its mod metadata.
