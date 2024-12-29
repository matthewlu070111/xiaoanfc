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
    public static final ItemGroup XIAOANFC_CORE = FabricItemGroup.builder()
            .icon(() -> new ItemStack(FarmingCoreBlockRegister.GRINDER))
            .displayName(Text.translatable("itemGroup.xiaoanfc.xiaoanfc_core"))
            .entries((context, entries) -> {
                entries.add(FarmingCoreItemRegister.FLOUR);
                entries.add(FarmingCoreItemRegister.DOUGH);
                entries.add(FarmingCoreItemRegister.STIR_STICK);
                entries.add(FarmingCoreItemRegister.MIXING_BOWL);

                entries.add(FarmingCoreBlockRegister.GRINDER);
            })
            .build();

    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, Identifier.of(XiaoansFarmingCore.MOD_ID, "xiaoanfc_materials"), XIAOANFC_CORE);

        XiaoansFarmingCore.LOGGER.info("Item group registration succeed!");
    }
}
