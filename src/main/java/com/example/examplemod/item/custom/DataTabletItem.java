package com.example.examplemod.item.custom;

import java.util.Optional;
import java.util.function.Consumer;

import org.jetbrains.annotations.ApiStatus.AvailableSince;

import com.example.examplemod.data.ModDataComponents;
import com.mojang.serialization.DataResult;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class DataTabletItem extends Item {

    public DataTabletItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (player.getItemInHand(hand).has(ModDataComponents.CORDINATES)) {
            player.getItemInHand(hand).remove(ModDataComponents.CORDINATES);
        }

        if (player.getItemInHand(hand).has(ModDataComponents.TRESURE_BLOCK_NAME)) {
            player.getItemInHand(hand).remove(ModDataComponents.TRESURE_BLOCK_NAME);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return itemStack.has(ModDataComponents.CORDINATES);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display,
            Consumer<Component> builder, TooltipFlag tooltipFlag) {
        // Only show tooltip if coordinates are present
        if (stack.has(ModDataComponents.CORDINATES)) {
            BlockPos pos = stack.get(ModDataComponents.CORDINATES);
            Component posText = Component.literal(pos.getX() + ", " + pos.getY() + ", " + pos.getZ());

            Component blockText;

            if (stack.has(ModDataComponents.TRESURE_BLOCK_NAME)) {
                String storedName = stack.get(ModDataComponents.TRESURE_BLOCK_NAME);

                // Parse identifier string
                DataResult<Identifier> parsed = Identifier.read(storedName);

                if (parsed.isSuccess()) {
                    Identifier id = parsed.result().get();
                    Optional<Block> blockOpt = BuiltInRegistries.BLOCK.getOptional(id);

                    blockText = blockOpt
                            .map(Block::getName) // localized name
                            .orElse(Component.literal("**Unknown Block**"));
                } else {
                    blockText = Component.literal("**Invalid Block Identifier**");
                }
            } else {
                blockText = Component.literal("**Unbound Block**");
            }

            // Combine block name + position into one line
            builder.accept(blockText.copy().append(Component.literal(" at ")).append(posText));
        }
    }
}
