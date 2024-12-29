package com.imxiaoanag.xiaoanfc.compat.rei.client;

import com.imxiaoanag.xiaoanfc.block.FarmingCoreBlockRegister;
import com.imxiaoanag.xiaoanfc.recipe.GrinderRecipes;
import com.imxiaoanag.xiaoanfc.screen.GrinderScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class FCREIClientPlugins implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new REIGrinderCategory());
        registry.addWorkstations(REIGrinderCategory.GRINDER_DISPLAY_CATEGORY_IDENTIFIER, EntryStacks.of(FarmingCoreBlockRegister.GRINDER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(GrinderRecipes.class, GrinderRecipes.Type.INSTANCE, REIGrinderDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), GrinderScreen.class, REIGrinderCategory.GRINDER_DISPLAY_CATEGORY_IDENTIFIER);
    }
}
