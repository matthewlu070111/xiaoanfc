package com.imxiaoanag.xiaoanfc.item;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.item.custom.StirStickItem;
import com.imxiaoanag.xiaoanfc.util.FCUtilRegister;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class FCItems {

    // Tools
    public static final Item STIR_STICK = regFCItem("stir_stick", new StirStickItem(new Item.Settings()));
    public static final Item MIXING_BOWL = regFCItem("mixing_bowl", new Item(new Item.Settings().recipeRemainder(Items.BOWL)));
    public static final Item USED_EGG_SEPARATOR = regFCUsedItem("used_egg_separator", "wash");

    // Materials
    public static final Item FLOUR = regFCItem("flour", new Item(new Item.Settings()));
    public static final Item DOUGH = regFCItem("dough", new Item(new Item.Settings()));
    public static final Item YOLK = regFCItem("yolk", new Item(new Item.Settings()));
    public static final Item EGG_WHITE = regFCItem("egg_white", new Item(new Item.Settings()));

    // Miscellaneous
    public static final Item IRON_STICK = regFCItem("iron_stick", new Item(new Item.Settings()));

    // Function regItem
    private static Item regFCItem(String name, Item item) {
        return FCUtilRegister.regItem(name, item, XiaoansFarmingCore.MOD_ID);
    }

    // Function regItem but used
    private static Item regFCUsedItem(String name, String how) {
        return FCUtilRegister.regUsedItem(name, XiaoansFarmingCore.MOD_ID, how);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_TOOLS).register((itemGroup) -> itemGroup.add(STIR_STICK));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_TOOLS).register((itemGroup) -> itemGroup.add(MIXING_BOWL));

        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(FLOUR));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(DOUGH));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(YOLK));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(EGG_WHITE));

        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MISCELLANEOUS).register((itemGroup) -> itemGroup.add(IRON_STICK));

        XiaoansFarmingCore.LOGGER.info("Items registration succeed!");
    }
}
