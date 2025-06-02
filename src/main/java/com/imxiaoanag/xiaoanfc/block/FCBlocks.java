package com.imxiaoanag.xiaoanfc.block;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.block.custom.GrinderCustomBlock;
import com.imxiaoanag.xiaoanfc.block.custom.PeanutCustomBlock;
import com.imxiaoanag.xiaoanfc.block.custom.RedBeanCustomBlock;
import com.imxiaoanag.xiaoanfc.block.custom.SesameCustomBlock;
import com.imxiaoanag.xiaoanfc.item.FCItemGroups;
import com.imxiaoanag.xiaoanfc.util.FCUtilRegister;
import com.imxiaoanag.xiaoanfc.world.tree.FCTreeGen;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class FCBlocks {

    // Machines
    public static final Block GRINDER = regFCBlock("grinder", new GrinderCustomBlock(AbstractBlock.Settings.create().strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD)));

    // Crops
    public static final Block RED_BEAN_CROP = regFCBlock("red_bean_crop", new RedBeanCustomBlock(AbstractBlock.Settings.copy(Blocks.CARROTS)));
    public static final Block SESAME_CROP = regFCBlock("sesame_crop", new SesameCustomBlock(AbstractBlock.Settings.copy(Blocks.CARROTS)));
    public static final Block PEANUT_CROP = regFCBlock("peanut_crop", new PeanutCustomBlock(AbstractBlock.Settings.copy(Blocks.CARROTS)));

    // Trees
    public static final Block APRICOT_LEAVES = regFCBlock("apricot_leaves", new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block APRICOT_SAPLING = regFCBlock("apricot_sapling", new SaplingBlock(FCTreeGen.APRICOT_SAPLING_TREE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block WALNUT_LEAVES = regFCBlock("walnut_leaves", new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block WALNUT_SAPLING = regFCBlock("walnut_sapling", new SaplingBlock(FCTreeGen.WALNUT_SAPLING_TREE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    private static Block regFCBlock(String name, Block block) {
        return FCUtilRegister.regBlock(name, block, XiaoansFarmingCore.MOD_ID);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_TOOLS).register((itemGroup) -> itemGroup.add(GRINDER));

        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(APRICOT_LEAVES));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(APRICOT_SAPLING));

        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(WALNUT_LEAVES));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(WALNUT_SAPLING));


        XiaoansFarmingCore.LOGGER.info("Blocks registration succeed!");
    }
}
