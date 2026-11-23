package com.surubedai.extrememetals.compat.jei;


import com.surubedai.extrememetals.ExtremeMetalsMain;
import com.surubedai.extrememetals.regi.ExtremeMetalsAddBlocks;
import com.surubedai.extrememetals.recipe.RecipePrimitiveReductionFurnace;
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

public class PrimitiveReductionRecipeCategory implements IRecipeCategory<RecipePrimitiveReductionFurnace> {

    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "primitive_reduction_furnace");
    public static final RecipeType<RecipePrimitiveReductionFurnace> RECIPE_TYPE = new RecipeType<>(UID, RecipePrimitiveReductionFurnace.class);

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(ExtremeMetalsMain.MODID, "textures/gui/primitive_reduction_furnace.png");

    private final IDrawable background;
    private final IDrawable icon;

    public PrimitiveReductionRecipeCategory(IGuiHelper helper) {
        // (テクスチャ, 切り抜き開始X, 切り抜き開始Y, 幅, 高さ)
        this.background = helper.createDrawable(TEXTURE, 45, 20, 102, 46);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ExtremeMetalsAddBlocks.BlockItems.PRIMITIVE_REDUCTION_FURNACE.get()));
    }

    @Override
    public RecipeType<RecipePrimitiveReductionFurnace> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        // JEI画面の上部に表示されるタイトル（翻訳キーを指定）
        return Component.translatable("block.extrememetals.primitive_reduction_furnace");
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
    public void setRecipe(IRecipeLayoutBuilder builder, RecipePrimitiveReductionFurnace recipe, IFocusGroup focuses) {
        // 入力
        builder.addSlot(RecipeIngredientRole.INPUT, 11, 15)
                .addIngredients(recipe.getIngredients().get(0));
        // 出力
        builder.addSlot(RecipeIngredientRole.OUTPUT, 71, 15)
                .addItemStack(recipe.getResultItem(null));
    }
}
