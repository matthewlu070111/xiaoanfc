package com.imxiaoanag.xiaoanfc.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class RedBeanItem extends Item {
    public RedBeanItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("itemTooltip.xiaoanfc.red_bean"));
        } else {
            tooltip.add(Text.translatable("itemTooltip.xiaoanfc.hold_shift").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
        }
    }
}
