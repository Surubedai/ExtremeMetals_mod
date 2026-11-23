package com.surubedai.extrememetals.datagen;

import com.surubedai.extrememetals.MaterialColors;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ExtremeMetalsItemModelProvider extends ItemModelProvider {

    public ExtremeMetalsItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, "extrememetals", existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ResourceLocation baseIngotTexture = modLoc("item/base_ingot");
        ResourceLocation basePlateTexture = modLoc("item/base_plate");

        for (MaterialColors mat : MaterialColors.values()) {
            // すべてのインゴットで同じ base_ingot.png を指定
            withExistingParent(mat.ingot.getId().getPath(), mcLoc("item/generated"))
                    .texture("layer0", baseIngotTexture);

            // すべてのプレートで同じ base_plate.png を指定
            withExistingParent(mat.plate.getId().getPath(), mcLoc("item/generated"))
                    .texture("layer0", basePlateTexture);
        }
    }
}

