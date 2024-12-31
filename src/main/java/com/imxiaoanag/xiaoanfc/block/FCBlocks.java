package com.imxiaoanag.xiaoanfc.block;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.block.custom.GrinderCustomBlock;
import com.imxiaoanag.xiaoanfc.item.FCItemGroups;
import com.imxiaoanag.xiaoanfc.util.FCUtilRegister;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class FCBlocks {

    public static final Block GRINDER = regFCBlock("grinder", new GrinderCustomBlock(AbstractBlock.Settings.create().strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD)));

    private static Block regFCBlock(String name, Block block) {
        return FCUtilRegister.regBlock(name, block, XiaoansFarmingCore.MOD_ID);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_TOOLS).register((itemGroup) -> itemGroup.add(GRINDER));

        XiaoansFarmingCore.LOGGER.info("Blocks registration succeed!");
    }
}
