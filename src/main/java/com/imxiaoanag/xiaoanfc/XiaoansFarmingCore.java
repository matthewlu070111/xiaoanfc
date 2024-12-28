package com.imxiaoanag.xiaoanfc;

import com.imxiaoanag.xiaoanfc.block.FarmingCoreBlockRegister;
import com.imxiaoanag.xiaoanfc.block.entity.FarmingCoreBlockEntity;
import com.imxiaoanag.xiaoanfc.item.FarmingCoreItemGroupRegister;
import com.imxiaoanag.xiaoanfc.item.FarmingCoreItemRegister;
import com.imxiaoanag.xiaoanfc.recipe.FarmingCoreRecipes;
import com.imxiaoanag.xiaoanfc.screen.FarmingCoreScreenHandlers;
import com.imxiaoanag.xiaoanfc.screen.GrinderScreen;
import net.fabricmc.api.ModInitializer;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XiaoansFarmingCore implements ModInitializer {
	public static final String MOD_ID = "xiaoanfc";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Xiaoan's Farming Core Loaded!");

		// Register all stuffs
		FarmingCoreItemRegister.initialize();
		FarmingCoreItemGroupRegister.initialize();
		FarmingCoreBlockRegister.initialize();
		FarmingCoreScreenHandlers.initialize();
		FarmingCoreBlockEntity.initialize();
		FarmingCoreRecipes.initialize();

		HandledScreens.register(FarmingCoreScreenHandlers.GRINDER_SCREEN_HANDLER, GrinderScreen::new);
	}
}