package com.imxiaoanag.xiaoanfc;

import com.imxiaoanag.xiaoanfc.block.FCBlocks;
import com.imxiaoanag.xiaoanfc.screen.FarmingCoreScreenHandlers;
import com.imxiaoanag.xiaoanfc.screen.GrinderScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class XiaoansFarmingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(FarmingCoreScreenHandlers.GRINDER_SCREEN_HANDLER, GrinderScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(FCBlocks.RED_BEAN_CROP, RenderLayer.getTranslucent());

        XiaoansFarmingCore.LOGGER.info("Xiaoan's Farming Core Client Loaded!");
    }
}
