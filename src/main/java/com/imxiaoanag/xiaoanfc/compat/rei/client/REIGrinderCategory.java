package com.imxiaoanag.xiaoanfc.compat.rei.client;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.block.FCBlocks;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class REIGrinderCategory implements DisplayCategory<BasicDisplay> {

    public static final Identifier TEXTURE = Identifier.of(XiaoansFarmingCore.MOD_ID, "textures/gui/grinder_rei.png");
    public static final CategoryIdentifier<REIGrinderDisplay> GRINDER_DISPLAY_CATEGORY_IDENTIFIER = CategoryIdentifier.of(XiaoansFarmingCore.MOD_ID, "grinder");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return GRINDER_DISPLAY_CATEGORY_IDENTIFIER;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("container.grinder");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(FCBlocks.GRINDER.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        final Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 45);
        List<Widget> widgets = new ArrayList<>();

        widgets.add(Widgets.createTexturedWidget(TEXTURE, startPoint.x, startPoint.y, 0, 0, 175, 90));

        if (!display.getInputEntries().isEmpty()) {
            widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 11)).entries(display.getInputEntries().get(0)));
        }

        if (!display.getOutputEntries().isEmpty()) {
            widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 59)).entries(display.getOutputEntries().get(0)));
        }

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 95;
    }
}
