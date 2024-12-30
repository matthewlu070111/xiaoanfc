package com.imxiaoanag.xiaoanfc.item;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.block.FarmingCoreBlockRegister;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FarmingCoreItemGroupRegister {
    public static final ItemGroup XIAOANFC_MATERIALS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(FarmingCoreItemRegister.FLOUR))
            .displayName(Text.translatable("itemGroup.xiaoanfc.xiaoanfc_materials"))
            .entries((context, entries) -> {
                entries.add(FarmingCoreItemRegister.FLOUR);
                entries.add(FarmingCoreItemRegister.DOUGH);
            })
            .build();

    public static final ItemGroup XIAOANFC_TOOLS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(FarmingCoreItemRegister.STIR_STICK))
            .displayName(Text.translatable("itemGroup.xiaoanfc.xiaoanfc_tools"))
            .entries((context, entries) -> {
                entries.add(FarmingCoreBlockRegister.GRINDER);

                entries.add(FarmingCoreItemRegister.STIR_STICK);
                entries.add(FarmingCoreItemRegister.MIXING_BOWL);
            })
            .build();

    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, Identifier.of(XiaoansFarmingCore.MOD_ID, "xiaoanfc_materials"), XIAOANFC_MATERIALS);
        Registry.register(Registries.ITEM_GROUP, Identifier.of(XiaoansFarmingCore.MOD_ID, "xiaoanfc_tools"), XIAOANFC_TOOLS);

        XiaoansFarmingCore.LOGGER.info("Itemgroup registration succeed!");
    }
}
