package com.imxiaoanag.xiaoanfc.world;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.block.FCBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class FCPlacedFeatures {
    public static final RegistryKey<PlacedFeature> APRICOT_TREE_PLACED_KEY = of("apricot_tree_placed");
    public static final RegistryKey<PlacedFeature> WALNUT_TREE_PLACED_KEY = of("walnut_tree_placed");

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup1 = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(featureRegisterable, APRICOT_TREE_PLACED_KEY, registryEntryLookup1.getOrThrow(FCConfiguredFeatures.APRICOT_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.02F, 1),
                        FCBlocks.APRICOT_SAPLING));

        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup2 = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(featureRegisterable, WALNUT_TREE_PLACED_KEY, registryEntryLookup2.getOrThrow(FCConfiguredFeatures.WALNUT_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.01F, 1),
                        FCBlocks.WALNUT_SAPLING));
    }

    public static RegistryKey<PlacedFeature> of(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(XiaoansFarmingCore.MOD_ID, name));
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            List<PlacementModifier> modifiers
    ) {
        featureRegisterable.register(key, new PlacedFeature(feature, modifiers));
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            PlacementModifier... modifiers
    ) {
        register(featureRegisterable, key, feature, List.of(modifiers));
    }
}
