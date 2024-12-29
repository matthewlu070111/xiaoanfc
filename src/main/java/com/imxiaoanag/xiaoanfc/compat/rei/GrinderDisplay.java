package com.imxiaoanag.xiaoanfc.compat.rei;

import com.imxiaoanag.xiaoanfc.recipe.GrinderRecipes;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.recipe.RecipeEntry;

import java.util.Collections;
import java.util.List;

public class GrinderDisplay extends BasicDisplay {
    public GrinderDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public GrinderDisplay(RecipeEntry<GrinderRecipes> recipe) {
        super(getInputList(recipe.value()), List.of(EntryIngredient.of(EntryStacks.of(recipe.value().getResult(null)))));
    }

    private static List<EntryIngredient> getInputList(GrinderRecipes value) {
        if (value.getIngredients().isEmpty()) {
            return Collections.emptyList();
        }
        return EntryIngredients.ofIngredients(value.getIngredients());
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return GrinderCategory.GRINDER_DISPLAY_CATEGORY_IDENTIFIER;
    }
}
