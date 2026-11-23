package com.surubedai.extrememetals.regi.tab;

import com.surubedai.extrememetals.MaterialColors;
import com.surubedai.extrememetals.regi.ExtremeMetalsAddBlocks;
import com.surubedai.extrememetals.regi.ExtremeMetalsAddFluids;
import com.surubedai.extrememetals.regi.ExtremeMetalsAddItems;
import net.minecraft.world.item.Item;

public class ExtremeMetalsItems {
    public static final Item[] items = {
            ExtremeMetalsAddItems.IRON_COAL_MIXTURE.get(),
            ExtremeMetalsAddItems.COPPER_COAL_MIXTURE.get(),
            ExtremeMetalsAddItems.GOLD_COAL_MIXTURE.get(),
            ExtremeMetalsAddItems.NATIVE_SILVER_COAL_MIXTURE.get(),
            ExtremeMetalsAddItems.CASSITERITE_COAL_MIXTURE.get(),
            ExtremeMetalsAddItems.ZINC_OXIDE_COAL_MIXTURE.get(),

            MaterialColors.SILVER.ingot.get(),
            MaterialColors.TIN.ingot.get(),
            MaterialColors.ZINC.ingot.get(),
            MaterialColors.BRONZE.ingot.get(),
            MaterialColors.BRASS.ingot.get(),
            MaterialColors.PIG_IRON.ingot.get(),
            MaterialColors.STEEL.ingot.get(),

            MaterialColors.IRON.plate.get(),
            MaterialColors.TIN.plate.get(),
            MaterialColors.BRONZE.plate.get(),
            MaterialColors.BRASS.plate.get(),

            ExtremeMetalsAddItems.IRON_ROD.get(),

            ExtremeMetalsAddItems.UNSHAPED_BRASS_TURBINE_BLADES.get(),
            ExtremeMetalsAddItems.BRASS_TURBINE_BLADES.get(),

            ExtremeMetalsAddItems.BRASS_GEAR.get(),

            ExtremeMetalsAddItems.SODIUM_HYDROXIDE.get(),
            ExtremeMetalsAddItems.ZINC_OXIDE.get(),

            ExtremeMetalsAddBlocks.BlockItems.NATIVE_SILVER_ORE.get(),
            ExtremeMetalsAddBlocks.BlockItems.CASSITERITE_ORE.get(),
            ExtremeMetalsAddBlocks.BlockItems.SPHALERITE_ORE.get(),

            ExtremeMetalsAddItems.RAW_NATIVE_SILVER.get(),
            ExtremeMetalsAddItems.RAW_CASSITERITE.get(),
            ExtremeMetalsAddItems.RAW_SPHALERITE.get(),

            ExtremeMetalsAddItems.DISPOSABLE_PLATE_MOLD.get(),
            ExtremeMetalsAddItems.DISPOSABLE_TURBINE_BLADES_MOLD.get(),
            ExtremeMetalsAddItems.DISPOSABLE_ROD_MOLD.get(),
            ExtremeMetalsAddItems.DISPOSABLE_GEAR_MOLD.get(),
            ExtremeMetalsAddItems.WEIGHT.get(),

            ExtremeMetalsAddItems.STEAM_POWER_UNIT.get(),

            ExtremeMetalsAddBlocks.BlockItems.PRIMITIVE_REDUCTION_FURNACE.get(),
            ExtremeMetalsAddBlocks.BlockItems.PRIMITIVE_ALLOYING_MACHINE.get(),
            ExtremeMetalsAddBlocks.BlockItems.PRIMITIVE_STEAM_BOILER.get(),

            ExtremeMetalsAddBlocks.BlockItems.STEAM_ROLLING_MILL.get(),
            ExtremeMetalsAddBlocks.BlockItems.STEAM_LATHE.get(),
            ExtremeMetalsAddBlocks.BlockItems.STEAM_AUTOMATIC_LOOM.get(),

            ExtremeMetalsAddFluids.BucketItems.STEAM_BUCKET.get()
    }; //items
}
