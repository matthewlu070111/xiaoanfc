package com.imxiaoanag.xiaoanfc.mixin;

import com.imxiaoanag.xiaoanfc.block.FCBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RenderLayers.class)
public class RenderLayersMixin {
    @Shadow @Final private static Map<Block, RenderLayer> BLOCKS;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void onBlockInit(CallbackInfo ci) {
        // Add custom render layers for blocks here if needed
        // Example: BLOCKS.put(MyCustomBlock.BLOCK, RenderLayer.getCutout());
        // Note: Ensure that the block is registered before this point

        BLOCKS.put(FCBlocks.RED_BEAN_CROP, RenderLayer.getCutout());
    }
}
