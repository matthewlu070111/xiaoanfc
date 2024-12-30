package com.imxiaoanag.xiaoanfc.item;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.block.FarmingCoreBlockRegister;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FarmingCoreItemGroupRegister {
    public static final RegistryKey<ItemGroup> XIAOANFC_MATERIALS = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            Identifier.of(XiaoansFarmingCore.MOD_ID, "xiaoanfc_materials"));

    public static final RegistryKey<ItemGroup> XIAOANFC_TOOLS = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            Identifier.of(XiaoansFarmingCore.MOD_ID, "xiaoanfc_tools"));

    public static void regMaterialsGroup(){
        Registry.register(Registries.ITEM_GROUP, XIAOANFC_MATERIALS, FabricItemGroup.builder().displayName(Text.translatable("itemGroup.xiaoanfc.xiaoanfc_materials"))
                .icon(() -> new ItemStack(FarmingCoreItemRegister.FLOUR)).build());
    }

    public static void regToolsGroup(){
        Registry.register(Registries.ITEM_GROUP, XIAOANFC_TOOLS, FabricItemGroup.builder().displayName(Text.translatable("itemGroup.xiaoanfc.xiaoanfc_tools"))
                .icon(() -> new ItemStack(FarmingCoreBlockRegister.GRINDER)).build());
    }

    public static void initialize(){
        regMaterialsGroup();
        regToolsGroup();

        XiaoansFarmingCore.LOGGER.info("Itemgroup registration succeed!");
    }
}
