package com.surubedai.extrememetals.worldgen;

import com.surubedai.extrememetals.ExtremeMetalsMain;
import com.surubedai.extrememetals.regi.ExtremeMetalsAddBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ExtremeMetalsConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CASSITERITE_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "cassiterite_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPHALERITE_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "sphalerite_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NATIVE_SILVER_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "native_silver_ore"));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // 1. 錫石（Cassiterite）用リスト
        List<OreConfiguration.TargetBlockState> cassiteriteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ExtremeMetalsAddBlocks.Blocks.CASSITERITE_ORE.get().defaultBlockState())
        );

        // 2. 閃亜鉛鉱（Sphalerite）用リスト
        List<OreConfiguration.TargetBlockState> sphaleriteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ExtremeMetalsAddBlocks.Blocks.SPHALERITE_ORE.get().defaultBlockState())
        );

        // 3. 自然銀（Native Silver）用リスト
        List<OreConfiguration.TargetBlockState> nativeSilverOres = List.of(
                OreConfiguration.target(deepslateReplaceables, ExtremeMetalsAddBlocks.Blocks.NATIVE_SILVER_ORE.get().defaultBlockState())
        );

        // それぞれ専用のリストを渡して登録
        context.register(CASSITERITE_ORE_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(cassiteriteOres, 8)));
        context.register(SPHALERITE_ORE_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(sphaleriteOres, 8)));
        context.register(NATIVE_SILVER_ORE_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(nativeSilverOres, 4)));
    }

}
