package com.imxiaoanag.xiaoanfc.util;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FCUtilRegister {

    // Item Registration
    public static Item regItem(String name, Item item, String modid) {
        return Registry.register(Registries.ITEM, Identifier.of(modid, name), item);
    }

    public static Item regUsedItem(String name, String modid, String how) {
        return regItem(name, new FCUtilUsedItem(new Item.Settings(), how), modid);
    }


    // Block Registration
    private static void regBlockItem(String name, Block block, String modid) {
        Item item = Registry.register(Registries.ITEM, Identifier.of(modid, name), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    public static Block regBlock(String name, Block block, String modid) {
        regBlockItem(name, block, modid);
        return Registry.register(Registries.BLOCK, Identifier.of(modid, name), block);
    }
}
