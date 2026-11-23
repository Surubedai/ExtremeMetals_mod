package com.surubedai.extrememetals.compat.jei;

import com.surubedai.extrememetals.ExtremeMetalsMain;
import com.surubedai.extrememetals.recipe.RecipeSteamLathe;
import com.surubedai.extrememetals.recipe.RecipeSteamRollingMill;
import com.surubedai.extrememetals.regi.ExtremeMetalsAddBlocks;
import com.surubedai.extrememetals.recipe.RecipePrimitiveReductionFurnace;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class ExtremeMetalsJeiPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new PrimitiveReductionRecipeCategory(registration.getJeiHelpers().getGuiHelper()),
                new SteamLatheRecipeCategory(registration.getJeiHelpers().getGuiHelper()),
                new SteamRollingRecipeCategory(registration.getJeiHelpers().getGuiHelper())
        );
    }

    // 4. 実際のレシピ一覧をゲーム内から取得してJEIに登録します
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<RecipePrimitiveReductionFurnace> PrimitiveReductionRecipes = recipeManager.getAllRecipesFor(RecipePrimitiveReductionFurnace.Type.INSTANCE);
        registration.addRecipes(PrimitiveReductionRecipeCategory.RECIPE_TYPE, PrimitiveReductionRecipes);

        List<RecipeSteamLathe> SteamLatheRecipes = recipeManager.getAllRecipesFor(RecipeSteamLathe.Type.INSTANCE);
        registration.addRecipes(SteamLatheRecipeCategory.RECIPE_TYPE, SteamLatheRecipes);

        List<RecipeSteamRollingMill> SteamRollingRecipes = recipeManager.getAllRecipesFor(RecipeSteamRollingMill.Type.INSTANCE);
        registration.addRecipes(SteamRollingRecipeCategory.RECIPE_TYPE, SteamRollingRecipes);
    }

    // 5. 「この機械ブロックでレシピを作れる」という紐づけ（触媒の登録）を行います
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(
                new ItemStack(ExtremeMetalsAddBlocks.BlockItems.PRIMITIVE_REDUCTION_FURNACE.get()),
                PrimitiveReductionRecipeCategory.RECIPE_TYPE
        );

        registration.addRecipeCatalyst(
                new ItemStack(ExtremeMetalsAddBlocks.BlockItems.STEAM_LATHE.get()),
                SteamLatheRecipeCategory.RECIPE_TYPE
        );

        registration.addRecipeCatalyst(
                new ItemStack(ExtremeMetalsAddBlocks.BlockItems.STEAM_ROLLING_MILL.get()),
                SteamRollingRecipeCategory.RECIPE_TYPE
        );
    }
}
