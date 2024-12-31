package com.imxiaoanag.xiaoanfc;

import com.imxiaoanag.xiaoanfc.block.FCBlocks;
import com.imxiaoanag.xiaoanfc.block.entity.FarmingCoreBlockEntity;
import com.imxiaoanag.xiaoanfc.item.FCItemGroups;
import com.imxiaoanag.xiaoanfc.item.FCItems;
import com.imxiaoanag.xiaoanfc.item.FCRemainderItems;
import com.imxiaoanag.xiaoanfc.recipe.FarmingCoreRecipes;
import com.imxiaoanag.xiaoanfc.screen.FarmingCoreScreenHandlers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XiaoansFarmingCore implements ModInitializer {
	public static final String MOD_ID = "xiaoanfc";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Xiaoan's Farming Core Loaded!");

		// Register all stuffs
		FCBlocks.initialize();
		FCItems.initialize();
		FCRemainderItems.initialize();
		FCItemGroups.initialize();
		FarmingCoreScreenHandlers.initialize();
		FarmingCoreBlockEntity.initialize();
		FarmingCoreRecipes.initialize();
	}
}