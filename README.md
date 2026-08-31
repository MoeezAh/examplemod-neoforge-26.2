# Example Mod — Azurite Content

A Minecraft content mod built with [NeoForge](https://neoforged.net/). It introduces Azurite resources, ores, storage blocks, recipes, and dedicated Creative Mode tabs.

## Compatibility

- Minecraft `26.2`
- NeoForge `26.2.0.75` or newer
- Mod ID: `examplemod`
- Version: `1.42.0-26.2`

## Content

### Items

- **Raw Azurite** — the unprocessed Azurite resource.
- **Azurite** — the processed Azurite resource.
- **Metal Detector** — a 64-use tool for finding ores below the selected block.
- **Data Tablet** — a utility item that stores the last ore coordinates found by the Metal Detector.
- **Curved Bow** — a ranged weapon with 500 durability, enchantable with bow-specific enchantments.
- **Blizzard Staff** — a staff item with a single-item stack limit.
- **Radiation Staff** — an EPIC-tier staff item with a unique visual identity and a single-item stack limit.
- **Onion** — a consumable food item that restores 2 hunger points and 0.3 saturation.
- **Onion Seeds** — plantable seeds used to grow Onion Crops.
- **Goji Berries** — a harvestable berry item gathered from a Goji Berry Bush.
- **Rice Shoot** — a water-planted seed item used to grow Rice Crops.
- **Bar Brawl Music Disc** — an EPIC music disc featuring “Bar Brawl” by Bryan Tech.
- **Stinky Potion** — a potion that applies the Stinky effect for 60 seconds.
- **End Fire Starter** — a furnace fuel item that stacks to 32.
- **Azurite Equipment** — a sword, pickaxe, axe, shovel, hoe, and spear crafted from Azurite.
- **Azurite Armor** — a four-piece armor set crafted from Azurite.
- **Azurite Horse Armor** — protective horse equipment using the Azurite armor material.

### End Fire Starter

Each End Fire Starter burns for 4,800 furnace ticks (4 minutes), enough to smelt 24 standard items.

### End Rod Sheep Interaction

Hitting a Sheep with an End Rod will apply the **Poison II** effect for 30 seconds (600 ticks). The attacking player receives a system message indicating the action. The End Rod is consumed with each use.

### Onion

Eating an Onion takes 2.1 seconds. Each serving has a 10% chance to apply **Nausea** for 20 seconds. Its tooltip reads, “Tasts like Onion.”

Onion Seeds grow through four stages when planted on farmland. A fully grown Onion Crop drops Onions and Onion Seeds, while immature crops drop seeds. Onion Seeds can be composted with a 30% chance of increasing the composter level, and Onions have a 50% chance.

### Metal Detector

Use the Metal Detector on a block to scan vertically downward, starting at the selected block, for the first ore in the common `c:ores` tag. When it finds one, the detector reports the block name and coordinates, plays a custom "valuables found" sound, and shows block particles. If nothing is found, it displays **"No valuables found."** and plays a matching custom failure sound. Each use consumes one durability point. Hovering it prompts you to hold Shift; holding Shift displays usage guidance. The detector also increments the **Valuables Found** statistic on each successful discovery.

### Data Tablet

The Data Tablet is a utility item that stores the coordinates of the last valuable block found by the Metal Detector. When a matching ore is detected, the detector automatically writes its position into the tablet if one is in the player's inventory. The tablet glows while it contains a saved location and displays the saved coordinates in its tooltip. Using the tablet clears the stored coordinates and resets it to its normal state.

### Curved Bow

The Curved Bow is a ranged weapon with 500 durability points. It fires arrows and can be enchanted with bow-specific enchantments such as Power, Draw Speed, Punch, Flame, and Infinity. Its drawing animation features multiple pull stages for visual feedback. When held and drawn, it reduces the player's field of view (FOV) for a zooming effect, providing better accuracy feedback as the draw reaches completion.

### Blizzard Staff

The Blizzard Staff is a staff item with a unique 3D model. It has a single-item stack limit, meaning only one can be held in a stack at a time.

### Radiation Staff

The Radiation Staff is an EPIC-tier staff item with a dedicated 3D item model and a single-item stack limit. It is featured in the Azurite Items creative tab and acts as a high-tier utility or combat item that fits the mod's more advanced endgame theme.

### Azurite Tools and Spear

The Azurite tool set includes a sword, pickaxe, axe, shovel, hoe, and spear. All use an Azurite material with 1,200 durability, mining speed 3, attack bonus 3, enchantability 22, and Azurite repair material. The Azurite Pickaxe can mine iron-tool blocks and the Magic Block.

Craft the sword with 2 Azurite and 1 stick; the pickaxe with 3 Azurite and 2 sticks; the shovel with 1 Azurite and 2 sticks; the axe or spear with 3 Azurite and 2 sticks; and the hoe with 2 Azurite and 2 sticks. The spear has dedicated held-item visuals.

### Azurite Armor

The Azurite armor set consists of a helmet, chestplate, leggings, and boots. Its defense values are 5, 9, 7, and 5 respectively, with 2 armor toughness, 0.1 knockback resistance, and enchantability 16. It is repairable with Azurite and supports armor trims.

Craft a helmet from 5 Azurite, a chestplate from 8, leggings from 7, and boots from 4.

### Azurite Horse Armor

Azurite Horse Armor uses the Azurite armor material and has a dedicated horse equipment texture.

### Blocks

- Block of Azurite
- Block of Raw Azurite
- Azurite Ore
- Deepslate Azurite Ore
- Nether Azurite Ore
- End Azurite Ore
- Azurite Stairs
- Azurite Slab
- Azurite Pressure Plate
- Azurite Button
- Azurite Fence
- Azurite Fence Gate
- Azurite Wall
- Azurite Door
- Azurite Trapdoor
- Azurite Lamp
- Pedestal
- Magic Block
- Onion Crop
- Goji Berry Bush
- Rice Crop

The ore variants award experience when mined. Azurite blocks, stairs, and slabs require the correct pickaxe for drops and use amethyst-like sounds; ore blocks likewise require the correct tool.

### Azurite Building Blocks

Azurite Stairs and Azurite Slabs are decorative building variants of the Block of Azurite. Craft 4 stairs from 6 Blocks of Azurite in the standard stair pattern, or craft 6 slabs from 3 Blocks of Azurite in a row. Stairs drop themselves when broken; a double slab drops 2 slabs. Their tooltips describe them as “The cool Azurite stairs” and “The flat slab of Azurite.”

### Azurite Redstone Components

Azurite Pressure Plates and Buttons provide redstone input using Azurite. Craft one button from 1 Azurite, or one pressure plate from 2 Azurite placed side-by-side. The button uses iron-button behavior and remains pressed for 20 ticks (1 second). Both components drop themselves when broken and have custom tooltips.

### Azurite Fencing

Azurite Fences, Fence Gates, and Walls extend the Azurite building set. They require the correct tool for drops, use amethyst-like sounds, and drop themselves when broken. Craft 3 fences from 4 Azurite and 2 sticks; craft one fence gate from 2 Azurite and 4 sticks; or craft 6 walls from 6 Blocks of Azurite. The fence gate uses acacia gate behavior.

### Azurite Access Blocks

Azurite Doors and Trapdoors use iron-style, redstone-operated behavior. Both require the correct tool for drops, use amethyst-like sounds, and drop themselves when broken. Craft 3 doors from 6 Azurite arranged in two vertical columns, or craft 2 trapdoors from 6 Azurite arranged in two rows.

### Azurite Lamp

The Azurite Lamp is a pickaxe-mineable light block that requires the correct tool for drops. Use it with an empty hand to toggle it on or off. When on, it emits light level 15 and switches to its illuminated texture. It drops itself when broken.

### Pedestal

The Pedestal is a decorative block with a narrow column design. It requires a pickaxe to mine and drops itself when broken. Its reduced collision box makes it suitable for displaying items or as an architectural accent.

### Magic Block

The Magic Block is a pickaxe-mineable block that drops itself when broken. Use it with an empty hand to create an end-rod particle and play an amethyst sound. Players who stand on it receive the **Glowing** effect for 15 seconds. Item entities that touch it transform one-for-one into diamonds when they contain an iron ingot, redstone, a copper ingot, or Azurite. Its tooltip identifies it as magical.

### Goji Berry Bush

The Goji Berry Bush is a crop-like plant that grows through several stages. Once mature, it can be harvested for Goji Berries, and the bush will regrow from a lower stage after picking. It drops multiple berries at higher growth stages and follows the same general berry-bush behavior as other plant-based crops.

### Rice Crop

Rice is grown from Rice Shoots planted in water. The crop progresses through several growth stages and is designed as a water-dependent crop that only survives when planted over water. A fully grown Rice Crop produces the harvestable rice item represented by the Rice Shoot item used for planting.

## Effects

The **Stinky** effect damages nearby living entities every tick. Its affected radius is based on the effect amplifier: amplifier 0 affects entities within 1 block, with each additional amplifier level increasing the radius by 1 block. Damage scales with the amplifier level.

Stinky damage uses a dedicated damage type with custom death messages. It has 0.1 exhaustion and scales when caused by a living non-player entity.

## Potions

Brew a **Stinky Potion** by combining an Awkward Potion with dirt. The potion applies the Stinky effect at amplifier 0 for 1,200 ticks (60 seconds). Splash and lingering variants are also available through the standard potion conversion recipes.

## Paintings

The mod includes four custom paintings:

- **Shrimp** — a 2×1 painting featuring a shrimp design by NanoAttack.
- **Saw Them** — a 2×2 painting with a notable scene by NanoAttack.
- **World** — a 2×2 painting depicting a world scene by NanoAttack.
- **Wanderer** — a 1×2 painting by PlatinumG17.

## Music Disc

The **Bar Brawl Music Disc** plays “Bar Brawl” by Bryan Tech (CC0) for 162 seconds. It outputs a comparator signal of 15 while playing, is available in the Azurite Items Creative Mode tab, and is included in the vanilla creeper music-disc drop tag.

## Obtaining Azurite

- Smelt or blast Raw Azurite or any Azurite ore variant to obtain Azurite.
- Smelting awards `0.25` experience and takes 100 ticks; blasting takes 50 ticks.
- Craft nine Azurite into one Block of Azurite.
- Break down one Block of Azurite into nine Azurite.
- Combine a Block of Azurite with Blaze Powder to receive eighteen Azurite.

## Creative Mode

The mod includes two Creative Mode tabs:

- **Azurite Items**: Raw Azurite, Azurite, the Metal Detector, the Data Tablet, the Curved Bow, the Blizzard Staff, the Radiation Staff, Onion, Onion Seeds, Goji Berries, Rice Shoot, the Bar Brawl Music Disc, Stinky Potion, End Fire Starter, Azurite tools and spear, the full Azurite armor set, and Azurite Horse Armor.
- **Azurite Building Blocks**: All Azurite blocks and ore variants, including Stairs, Slabs, redstone components, fencing, Doors, Trapdoors, and the Lamp, plus the Pedestal, Magic Block, Goji Berry Bush, and Rice Crop.

Raw Azurite and Azurite are also available in Minecraft's Ingredients tab, and the Block of Azurite appears in Building Blocks. The Azurite Sword, Spear, armor set, and Horse Armor are also available in Minecraft's Combat tab.

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

## Implementation Guide

See [IMPLEMENTATION_HISTORY.md](IMPLEMENTATION_HISTORY.md) for a reusable guide to the mod's feature implementations, including registries, data generation, resources, custom behavior, and validation workflows.

## Changelog

See [CHANGELOG.md](CHANGELOG.md) for the dated, oldest-first record of project changes.

## License

This project is marked as `MIT Reserved` in its mod metadata.
