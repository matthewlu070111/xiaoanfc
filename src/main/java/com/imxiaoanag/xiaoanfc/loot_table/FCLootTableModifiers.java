package com.imxiaoanag.xiaoanfc.loot_table;

import com.imxiaoanag.xiaoanfc.block.FCBlocks;
import com.imxiaoanag.xiaoanfc.item.FCItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;

public class FCLootTableModifiers {
    public static final RegistryKey<LootTable> LILY_PAD_ID = Blocks.LILY_PAD.getLootTableKey();
    public static final RegistryKey<LootTable> SHORT_GRASS_ID = Blocks.SHORT_GRASS.getLootTableKey();
    public static final RegistryKey<LootTable> TALL_GRASS_ID = Blocks.TALL_GRASS.getLootTableKey();

    public static void initialize() {
        LootTableEvents.MODIFY.register((id, tableBuilder, source, registries) -> {
            if (id.equals(LILY_PAD_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.7f)) // Chance to drop is 70%
                        .with(ItemEntry.builder(FCItems.LOTUS_SEED))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());  // Random count between 1 and 2

                tableBuilder.pool(poolBuilder);
            }

            if (id.equals(SHORT_GRASS_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Chance to drop is 5%
                        .with(ItemEntry.builder(FCItems.RED_BEAN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());  // Count is always 1

                tableBuilder.pool(poolBuilder);
            }

            if (id.equals(TALL_GRASS_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f)) // Chance to drop is 15%
                        .with(ItemEntry.builder(FCItems.RED_BEAN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());  // Count is always 1

                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
