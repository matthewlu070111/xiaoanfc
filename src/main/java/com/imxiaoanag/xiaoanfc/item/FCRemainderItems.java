package com.imxiaoanag.xiaoanfc.item;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.util.FCUtilRegister;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;

public class FCRemainderItems extends FCItems {
    public static final Item EGG_SEPARATOR = regFCRemainderItem("egg_separator", new Item(new Item.Settings().recipeRemainder(FCItems.USED_EGG_SEPARATOR)));

    private static Item regFCRemainderItem(String name, Item item) {
        return FCUtilRegister.regItem(name, item, XiaoansFarmingCore.MOD_ID);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_TOOLS).register((itemGroup) -> itemGroup.add(EGG_SEPARATOR));

        XiaoansFarmingCore.LOGGER.info("Items need remainder's registration succeed!");
    }
}
