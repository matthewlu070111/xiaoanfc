package com.imxiaoanag.xiaoanfc.recipe;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FarmingCoreRecipes {
    public static void initialize() {
        Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(XiaoansFarmingCore.MOD_ID, GrinderRecipes.Serializer.ID), GrinderRecipes.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, Identifier.of(XiaoansFarmingCore.MOD_ID, GrinderRecipes.Type.ID), GrinderRecipes.Type.INSTANCE);

        XiaoansFarmingCore.LOGGER.info("Recipes registration succeed!");
    }
}
