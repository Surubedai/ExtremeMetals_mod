package com.surubedai.extrememetals.worldgen;

import com.surubedai.extrememetals.ExtremeMetalsMain;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ExtremeMetalsPlacedFeatures {
    public static final ResourceKey<PlacedFeature> CASSITERITE_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "cassiterite_ore_placed"));
    public static final ResourceKey<PlacedFeature> SPHALERITE_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "sphalerite_ore_placed"));
    public static final ResourceKey<PlacedFeature> NATIVE_SILVER_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "native_silver_ore_placed"));

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return List.of(
                CountPlacement.of(count),
                InSquarePlacement.spread(),
                heightRange,
                BiomeFilter.biome()
        );
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //1チャンク10回、Y=0〜56（均一）
        register(context, CASSITERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ExtremeMetalsConfiguredFeatures.CASSITERITE_ORE_KEY),
                commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(56))));

        //1チャンク8回、Y=12〜78（台形分布：真ん中付近が濃い）
        register(context, SPHALERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ExtremeMetalsConfiguredFeatures.SPHALERITE_ORE_KEY),
                commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(12), VerticalAnchor.absolute(78))));

        //1チャンク2回、Y=-52〜-46（均一）
        register(context, NATIVE_SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ExtremeMetalsConfiguredFeatures.NATIVE_SILVER_ORE_KEY),
                commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-52), VerticalAnchor.absolute(-46))));

    }

}
