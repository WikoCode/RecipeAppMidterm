package com.example.recipeappmidterm.recipies.data.remote.mapper

import com.example.recipeappmidterm.recipies.data.remote.model.RecipeDetailDto
import com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain.RecipeDetailDomain

fun RecipeDetailDto.toDomain(): RecipeDetailDomain {
    return RecipeDetailDomain(
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