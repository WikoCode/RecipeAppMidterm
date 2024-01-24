package com.example.recipeappmidterm.recipies.presentation.mapper

import com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain.RecipeDetailDomain
import com.example.recipeappmidterm.recipies.presentation.model.recipedetailpresentation.RecipeDetailPresentation

fun RecipeDetailDomain.toPresentation(): RecipeDetailPresentation {
    return RecipeDetailPresentation(
        id = id,
        title = title,
        image = image,
        servings = servings,
        readyInMinutes = readyInMinutes,
        license = license,
        sourceName = sourceName,
        sourceUrl = sourceUrl,
        spoonacularSourceUrl = spoonacularSourceUrl,
        healthScore = healthScore,
        spoonacularScore = spoonacularScore,
        pricePerServing = pricePerServing,
        cheap = cheap,
        dairyFree = dairyFree,
        glutenFree = glutenFree,
        ketogenic = ketogenic,
        vegan = vegan,
        dishTypes = dishTypes,
        extendedIngredients = extendedIngredients,
        summary = summary
    )
}