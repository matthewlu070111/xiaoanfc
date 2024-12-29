package com.imxiaoanag.xiaoanfc;

import com.imxiaoanag.xiaoanfc.screen.FarmingCoreScreenHandlers;
import com.imxiaoanag.xiaoanfc.screen.GrinderScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class XiaoansFarmingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(FarmingCoreScreenHandlers.GRINDER_SCREEN_HANDLER, GrinderScreen::new);

        XiaoansFarmingCore.LOGGER.info("Xiaoan's Farming Core Client Loaded!");
    }
}
