package com.surubedai.extrememetals.compat.jei;


import com.surubedai.extrememetals.ExtremeMetalsMain;
import com.surubedai.extrememetals.recipe.RecipeSteamRollingMill;
import com.surubedai.extrememetals.regi.ExtremeMetalsAddBlocks;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SteamRollingRecipeCategory implements IRecipeCategory<RecipeSteamRollingMill> {

    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "steam_rolling_mill");
    public static final RecipeType<RecipeSteamRollingMill> RECIPE_TYPE = new RecipeType<>(UID, RecipeSteamRollingMill.class);

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "textures/gui/steam_rolling_mill.png");

    private final IDrawable background;
    private final IDrawable icon;

    public SteamRollingRecipeCategory(IGuiHelper helper) {
        // (テクスチャ, 切り抜き開始X, 切り抜き開始Y, 幅, 高さ)
        this.background = helper.createDrawable(TEXTURE, 45, 20, 102, 46);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ExtremeMetalsAddBlocks.BlockItems.STEAM_ROLLING_MILL.get()));
    }

    @Override
    public RecipeType<RecipeSteamRollingMill> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        // JEI画面の上部に表示されるタイトル（翻訳キーを指定）
        return Component.translatable("block.extrememetals.steam_rolling_mill");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeSteamRollingMill recipe, IFocusGroup focuses) {
        // 入力
        builder.addSlot(RecipeIngredientRole.INPUT, 11, 15)
                .addIngredients(recipe.getIngredients().get(0));
        // 出力
        builder.addSlot(RecipeIngredientRole.OUTPUT, 71, 15)
                .addItemStack(recipe.getResultItem(null));
    }
}
