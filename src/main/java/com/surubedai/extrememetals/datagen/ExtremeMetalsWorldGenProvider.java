package com.surubedai.extrememetals.datagen;

import com.surubedai.extrememetals.ExtremeMetalsMain;
import com.surubedai.extrememetals.worldgen.ExtremeMetalsBiomeModifiers;
import com.surubedai.extrememetals.worldgen.ExtremeMetalsConfiguredFeatures;
import com.surubedai.extrememetals.worldgen.ExtremeMetalsPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ExtremeMetalsWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ExtremeMetalsConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ExtremeMetalsPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ExtremeMetalsBiomeModifiers::bootstrap);

    public ExtremeMetalsWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ExtremeMetalsMain.MODID));
    }
}
