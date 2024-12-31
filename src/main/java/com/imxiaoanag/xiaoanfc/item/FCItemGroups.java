package com.imxiaoanag.xiaoanfc.item;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.block.FCBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FCItemGroups {
    public static final RegistryKey<ItemGroup> XIAOANFC_TOOLS = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            Identifier.of(XiaoansFarmingCore.MOD_ID, "xiaoanfc_tools"));

    public static final RegistryKey<ItemGroup> XIAOANFC_MATERIALS = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            Identifier.of(XiaoansFarmingCore.MOD_ID, "xiaoanfc_materials"));

    public static final RegistryKey<ItemGroup> XIAOANFC_MISCELLANEOUS = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            Identifier.of(XiaoansFarmingCore.MOD_ID, "xiaoanfc_miscellaneous"));

    public static void regToolsGroup(){
        Registry.register(Registries.ITEM_GROUP, XIAOANFC_TOOLS, FabricItemGroup.builder().displayName(Text.translatable("itemGroup.xiaoanfc.xiaoanfc_tools"))
                .icon(() -> new ItemStack(FCBlocks.GRINDER)).build());
    }

    public static void regMaterialsGroup(){
        Registry.register(Registries.ITEM_GROUP, XIAOANFC_MATERIALS, FabricItemGroup.builder().displayName(Text.translatable("itemGroup.xiaoanfc.xiaoanfc_materials"))
                .icon(() -> new ItemStack(FCItems.FLOUR)).build());
    }

    public static void regMiscellaneousGroup(){
        Registry.register(Registries.ITEM_GROUP, XIAOANFC_MISCELLANEOUS, FabricItemGroup.builder().displayName(Text.translatable("itemGroup.xiaoanfc.xiaoanfc_miscellaneous"))
                .icon(() -> new ItemStack(FCItems.IRON_STICK)).build());
    }

    public static void initialize(){
        regToolsGroup();
        regMaterialsGroup();
        regMiscellaneousGroup();

        XiaoansFarmingCore.LOGGER.info("Itemgroup registration succeed!");
    }
}
