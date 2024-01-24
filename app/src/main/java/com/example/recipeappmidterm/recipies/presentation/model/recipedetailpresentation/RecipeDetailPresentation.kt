package com.example.recipeappmidterm.recipies.presentation.model.recipedetailpresentation

import com.example.recipeappmidterm.recipies.data.remote.model.ExtendedIngredient

data class RecipeDetailPresentation(
    val id: Int,
    val title: String,
    val image: String,
    val servings: Int,
    val readyInMinutes: Int,
    val license: String,
    val sourceName: String,
    val sourceUrl: String,
    val spoonacularSourceUrl: String,
    val healthScore: Double,
    val spoonacularScore: Double,
    val pricePerServing: Double,
    val cheap: Boolean,
    val dairyFree: Boolean,
    val glutenFree: Boolean,
    val ketogenic: Boolean,
    val vegan: Boolean,
    val dishTypes: List<String>,
    val extendedIngredients: List<ExtendedIngredient>,
    val summary: String,
)
