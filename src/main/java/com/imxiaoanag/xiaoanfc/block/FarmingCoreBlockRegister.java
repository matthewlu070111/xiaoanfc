package com.imxiaoanag.xiaoanfc.block;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.block.custom.GrinderCustomBlock;
import com.imxiaoanag.xiaoanfc.item.FarmingCoreItemGroupRegister;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class FarmingCoreBlockRegister {

    public static final Block GRINDER = regBlock("grinder", new GrinderCustomBlock(AbstractBlock.Settings.create().strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD)));

    public static void regBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, Identifier.of(XiaoansFarmingCore.MOD_ID, name), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    public static Block regBlock(String name, Block block) {
        regBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(XiaoansFarmingCore.MOD_ID, name), block);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(FarmingCoreItemGroupRegister.XIAOANFC_TOOLS).register((itemGroup) -> itemGroup.add(GRINDER));

        XiaoansFarmingCore.LOGGER.info("Blocks registration succeed!");
    }
}
