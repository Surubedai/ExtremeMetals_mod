package com.surubedai.extrememetals.datagen;

import com.surubedai.extrememetals.ExtremeMetalsMain;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ExtremeMetalsMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // クライアント側データ（モデルJSONなど）の生成
        generator.addProvider(event.includeClient(), new ExtremeMetalsItemModelProvider(packOutput, helper));

        // サーバー側データ（レシピなど）の生成
        generator.addProvider(event.includeServer(), new ExtremeMetalsRecipeProvider(packOutput));

        generator.addProvider(event.includeServer(), new ExtremeMetalsWorldGenProvider(packOutput, lookupProvider));
    }
}