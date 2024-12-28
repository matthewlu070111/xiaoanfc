package com.imxiaoanag.xiaoanfc.item;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FarmingCoreItemRegister {

    public static final Item DOUGH = regItem("dough", new Item(new Item.Settings()));
    public static final Item FLOUR = regItem("flour", new Item(new Item.Settings()));
    public static final Item MIXING_BOWL = regItem("mixing_bowl", new Item(new Item.Settings()));

    // Function regItem
    public static Item regItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(XiaoansFarmingCore.MOD_ID, name), item);
    }

    public static void initialize() {
        XiaoansFarmingCore.LOGGER.info("Items registration succeed!");
    }
}
