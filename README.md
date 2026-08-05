# Example Mod — Azurite Content

A Minecraft content mod built with [NeoForge](https://neoforged.net/). It introduces Azurite resources, ores, storage blocks, recipes, and dedicated Creative Mode tabs.

## Compatibility

- Minecraft `26.2`
- NeoForge `26.2.0.41-beta` or newer
- Mod ID: `examplemod`

## Content

### Items

- **Raw Azurite** — the unprocessed Azurite resource.
- **Azurite** — the processed resource currently registered in-game as `examplemod:hook`.

### Blocks

- Block of Azurite
- Block of Raw Azurite
- Azurite Ore
- Deepslate Azurite Ore
- Nether Azurite Ore
- End Azurite Ore

The ore variants award experience when mined. Azurite and Raw Azurite blocks require the correct harvesting tool and use an amethyst-like sound; ore blocks likewise require the correct tool.

## Obtaining Azurite

- Smelt or blast Raw Azurite or any Azurite ore variant to obtain Azurite.
- Smelting awards `0.25` experience and takes 100 ticks; blasting takes 50 ticks.
- Craft nine Azurite into one Block of Azurite.
- Break down one Block of Azurite into nine Azurite.
- Combine a Block of Azurite with Blaze Powder to receive eighteen Azurite.

## Creative Mode

The mod includes two Creative Mode tabs:

- **Example Items**: Raw Azurite and Azurite.
- **Example Blocks**: All Azurite blocks and ore variants.

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

## License

This project is marked as `MIT Reserved` in its mod metadata.
