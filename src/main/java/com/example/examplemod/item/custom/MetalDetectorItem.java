package com.example.examplemod.item.custom;

import java.util.function.Consumer;

import com.example.examplemod.data.ModDataComponents;
import com.example.examplemod.item.ModItems;
import com.example.examplemod.sound.ModSounds;
import com.example.examplemod.stat.ModStats;
import com.example.examplemod.tags.ModTags;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos positionClicked = context.getClickedPos();
        Player player = context.getPlayer();

        if (!level.isClientSide()) {
            // We are on the server.
            Boolean foundBlock = false;

            for (int i = 0; i < positionClicked.getY() + 64; i++) {
                BlockState blockState = level.getBlockState(positionClicked.below(i));

                if (isValuableBlock(blockState)) {
                    outputValuableBlockCordinates(positionClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    // Play the sound
                    level.playSound(null, positionClicked, ModSounds.VALUABLES_FOUND.get(), SoundSource.BLOCKS, 1.5f,
                            0.8F + level.getRandom().nextFloat() * 0.4F);

                    // Spawn particles
                    spawnFoundParticles(level, positionClicked, blockState);

                    addDataToDataTablet(player, positionClicked.below(i));

                    player.awardStat(ModStats.VLAUABLES_FOUND.get(), 1);

                    break;
                }
            }

            if (!foundBlock) {
                outputNoValuableFound(player);
                // Play the sound
                level.playSound(null, positionClicked, ModSounds.VALUABLES_NOT_FOUND.get(), SoundSource.BLOCKS, 1.5f,
                        0.8F + level.getRandom().nextFloat() * 0.4F);
            }

            // Damage the item
            context.getItemInHand().hurtAndBreak(1, player, context.getHand());
        }

        return InteractionResult.SUCCESS;
    }

    private void addDataToDataTablet(Player player, BlockPos position) {
        int slotIndex = player.getInventory().findSlotMatchingItem(new ItemStack(ModItems.DATA_TABLET.get()));

        if (slotIndex == -1) {
            return;
        }

        ItemStack dataTablet = player.getInventory().getItem(slotIndex);
        dataTablet.set(ModDataComponents.CORDINATES, position);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display,
            Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if (Minecraft.getInstance().hasShiftDown()) {
            builder.accept(Component.translatable("tooltip.examplemod.metal_detector.shift_down"));
        } else {
            builder.accept(Component.translatable("tooltip.examplemod.metal_detector"));
        }
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }

    private void spawnFoundParticles(Level level, BlockPos positionClicked, BlockState blockState) {
        for (int i = 0; i < 20; i++) {
            ServerLevel serverLevel = (ServerLevel) level;

            serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockState),
                    positionClicked.getX() + 0.5d,
                    positionClicked.getY() + 1.0d,
                    positionClicked.getZ() + 0.5d,
                    1,
                    Math.cos(i * 18) * 0.15d,
                    0.15d,
                    Math.sin(i * 18) * 0.15d,
                    0.1);
        }
    }

    private void outputNoValuableFound(Player player) {
        player.sendSystemMessage(Component.translatable("item.examplemod.metal_detector.no_valuables"));
    }

    private void outputValuableBlockCordinates(BlockPos position, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Valuable found. ")
                .append(block.getName())
                .append(Component
                        .literal(" at " + position.getX() + ", " + position.getY() + ", " + position.getZ() + ".")));
    }

    private boolean isValuableBlock(BlockState blockState) {
        // return blockState.is(Blocks.IRON_ORE)
        // || blockState.is(Blocks.DEEPSLATE_IRON_ORE)
        // || blockState.is(Blocks.DIAMOND_ORE)
        // || blockState.is(Blocks.DEEPSLATE_DIAMOND_ORE);
        return blockState.is(ModTags.Blocks.METAL_DETECTABLES);
    }

}
