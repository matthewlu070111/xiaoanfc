package com.imxiaoanag.xiaoanfc.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class FCUtilUsedItem extends Item {

    private final String wayHow;

    public FCUtilUsedItem(Settings settings, String how) {
        super(settings);
        wayHow = how;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.xiaoanfc.used_" + wayHow));
    }
}
