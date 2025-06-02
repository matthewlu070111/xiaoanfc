package com.imxiaoanag.xiaoanfc.item;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.block.FCBlocks;
import com.imxiaoanag.xiaoanfc.item.custom.*;
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
    public static final Item LOTUS_SEED = regFCItem("lotus_seed", new LotusSeedItem(new Item.Settings().food(FCFoods.LOTUS_SEED)));
    public static final Item RED_BEAN = regFCItem("red_bean", new RedBeanItem(FCBlocks.RED_BEAN_CROP, new Item.Settings().food(FCFoods.RED_BEAN)));
    public static final Item RED_BEAN_PASTE = regFCItem("red_bean_paste", new Item(new Item.Settings().food(FCFoods.RED_BEAN_PASTE)));
    public static final Item SESAME = regFCItem("sesame", new SesameItem(FCBlocks.SESAME_CROP, new Item.Settings().food(FCFoods.SESAME)));
    public static final Item PEANUT = regFCItem("peanut", new PeanutItem(FCBlocks.PEANUT_CROP, new Item.Settings().food(FCFoods.PEANUT)));
    public static final Item SUNFLOWER_SEEDS = regFCItem("sunflower_seeds", new SunflowerSeedsItem(new Item.Settings()));
    public static final Item SALTED_SUNFLOWER_SEEDS = regFCItem("salted_sunflower_seeds", new Item(new Item.Settings().food(FCFoods.SALTED_SUNFLOWER_SEEDS)));
    public static final Item APRICOT = regFCItem("apricot", new Item(new Item.Settings().food(FCFoods.APRICOT)));
    public static final Item ALMOND = regFCItem("almond", new Item(new Item.Settings().food(FCFoods.ALMOND)));
    public static final Item WALNUT = regFCItem("walnut", new Item(new Item.Settings().food(FCFoods.WALNUT)));

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
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(LOTUS_SEED));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(RED_BEAN));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(RED_BEAN_PASTE));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(SESAME));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(PEANUT));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(SUNFLOWER_SEEDS));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(SALTED_SUNFLOWER_SEEDS));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(APRICOT));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(ALMOND));
        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MATERIALS).register((itemGroup) -> itemGroup.add(WALNUT));

        ItemGroupEvents.modifyEntriesEvent(FCItemGroups.XIAOANFC_MISCELLANEOUS).register((itemGroup) -> itemGroup.add(IRON_STICK));

        XiaoansFarmingCore.LOGGER.info("Items registration succeed!");
    }
}
