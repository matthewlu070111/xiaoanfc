package com.imxiaoanag.xiaoanfc.world.gen;

import com.imxiaoanag.xiaoanfc.world.FCPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class FCTreeReg {
    public static void registerTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST), GenerationStep.Feature.VEGETAL_DECORATION, FCPlacedFeatures.APRICOT_TREE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST), GenerationStep.Feature.VEGETAL_DECORATION, FCPlacedFeatures.WALNUT_TREE_PLACED_KEY);
    }
}
