package com.imxiaoanag.xiaoanfc.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class SesameItem extends AliasedBlockItem {
    public SesameItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("itemTooltip.xiaoanfc.sesame"));
        } else {
            tooltip.add(Text.translatable("itemTooltip.xiaoanfc.hold_shift").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
        }
    }
}
