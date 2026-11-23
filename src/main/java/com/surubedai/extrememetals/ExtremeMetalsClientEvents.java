package com.surubedai.extrememetals;
import com.surubedai.extrememetals.regi.ExtremeMetalsAddItems;
import com.surubedai.extrememetals.regi.ExtremeMetalsAddScreens;

import com.surubedai.extrememetals.screen.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ExtremeMetalsMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExtremeMetalsClientEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // Menu と Screen を紐付ける公式の登録処理
            MenuScreens.register(ExtremeMetalsAddScreens.PRIMITIVE_REDUCTION_MENU.get(), ScreenPrimitiveReductionFurnaceDrawing::new);
            MenuScreens.register(ExtremeMetalsAddScreens.PRIMITIVE_ALLOYING_MENU.get(), ScreenPrimitiveAlloyingMachineDrawing::new);
            MenuScreens.register(ExtremeMetalsAddScreens.PRIMITIVE_BOILER_MENU.get(), ScreenPrimitiveSteamBoilerDrawing::new);
            MenuScreens.register(ExtremeMetalsAddScreens.STEAM_ROLLING_MENU.get(), ScreenSteamRollingMillDrawing::new);
            MenuScreens.register(ExtremeMetalsAddScreens.STEAM_LATHE_MENU.get(), ScreenSteamLatheDrawing::new);
            MenuScreens.register(ExtremeMetalsAddScreens.STEAM_LOOM_MENU.get(), ScreenSteamAutomaticLoomDrawing::new);
        });
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        for (MaterialColors mat : MaterialColors.values()) {
            event.register(
                    (stack, tintIndex) -> tintIndex == 0 ? mat.color : -1,
                    mat.ingot.get(),
                    mat.plate.get()
            );
        }
    }

}
