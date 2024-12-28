package com.imxiaoanag.xiaoanfc.block.entity;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.block.FarmingCoreBlockRegister;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class FarmingCoreBlockEntity {

    public static final BlockEntityType<GrinderBlockEntity> GRINDER_BLOCK_ENTITY_TYPE = create("grinder_block_entity_type", BlockEntityType.Builder.create(GrinderBlockEntity::new, FarmingCoreBlockRegister.GRINDER));

    private static <T extends BlockEntity> BlockEntityType<T> create(String name, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(XiaoansFarmingCore.MOD_ID, name), builder.build(type));
    }

    public static void initialize() {
        XiaoansFarmingCore.LOGGER.info("Block entities registration succeed!");
    }
}
