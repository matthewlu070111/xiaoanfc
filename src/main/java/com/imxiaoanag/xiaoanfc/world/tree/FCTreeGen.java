package com.imxiaoanag.xiaoanfc.world.tree;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.world.FCConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class FCTreeGen {
    public static final SaplingGenerator APRICOT_SAPLING_TREE = new SaplingGenerator(
            XiaoansFarmingCore.MOD_ID + ":apricot_tree",
            Optional.empty(),
            Optional.of(FCConfiguredFeatures.APRICOT_TREE_KEY),
            Optional.empty()
    );

    public static final SaplingGenerator WALNUT_SAPLING_TREE = new SaplingGenerator(
            XiaoansFarmingCore.MOD_ID + ":walnut_tree",
            Optional.empty(),
            Optional.of(FCConfiguredFeatures.WALNUT_TREE_KEY),
            Optional.empty()
    );
}
