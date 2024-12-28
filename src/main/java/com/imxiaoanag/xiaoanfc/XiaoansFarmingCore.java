package com.imxiaoanag.xiaoanfc;

import com.imxiaoanag.xiaoanfc.item.FarmingCoreItemGroupRegister;
import com.imxiaoanag.xiaoanfc.item.FarmingCoreItemRegister;
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
		FarmingCoreItemRegister.initialize();
		FarmingCoreItemGroupRegister.initialize();
	}
}