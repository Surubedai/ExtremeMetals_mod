package com.surubedai.extrememetals.worldgen;

import com.surubedai.extrememetals.ExtremeMetalsMain;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ExtremeMetalsBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_CASSITERITE_ORE =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "add_cassiterite_ore"));
    public static final ResourceKey<BiomeModifier> ADD_SPHALERITE_ORE =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "add_sphalerite_ore"));
    public static final ResourceKey<BiomeModifier> ADD_NATIVE_SILVER_ORE =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "add_native_silver_ore"));


    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(ADD_CASSITERITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ExtremeMetalsPlacedFeatures.CASSITERITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_SPHALERITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ExtremeMetalsPlacedFeatures.SPHALERITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_NATIVE_SILVER_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ExtremeMetalsPlacedFeatures.NATIVE_SILVER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
    }
}
