package com.imxiaoanag.xiaoanfc.screen;

import com.imxiaoanag.xiaoanfc.XiaoansFarmingCore;
import com.imxiaoanag.xiaoanfc.data.GrinderData;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class FarmingCoreScreenHandlers {

    public static final ScreenHandlerType<GrinderScreenHandler> GRINDER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(XiaoansFarmingCore.MOD_ID, "grinder"),
                    new ExtendedScreenHandlerType<>(GrinderScreenHandler::new, GrinderData.CODEC));

    public static void initialize() {
        XiaoansFarmingCore.LOGGER.info("Screen handler registration succeed!");
    }
}
