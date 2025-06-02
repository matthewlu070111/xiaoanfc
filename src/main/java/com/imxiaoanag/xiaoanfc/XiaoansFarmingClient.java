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

        // Crops
        BlockRenderLayerMap.INSTANCE.putBlock(FCBlocks.RED_BEAN_CROP, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FCBlocks.SESAME_CROP, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FCBlocks.PEANUT_CROP, RenderLayer.getTranslucent());

        // Saplings & Leaves
        BlockRenderLayerMap.INSTANCE.putBlock(FCBlocks.APRICOT_SAPLING, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FCBlocks.APRICOT_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FCBlocks.WALNUT_SAPLING, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(FCBlocks.WALNUT_LEAVES, RenderLayer.getCutout());

        XiaoansFarmingCore.LOGGER.info("Xiaoan's Farming Core Client Loaded!");
    }
}
