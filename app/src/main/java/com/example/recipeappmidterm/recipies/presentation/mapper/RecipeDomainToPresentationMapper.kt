package com.example.recipeappmidterm.recipies.presentation.mapper

import com.example.recipeappmidterm.recipies.domain.model.RecipeDomain
import com.example.recipeappmidterm.recipies.presentation.model.RecipePresentation

fun RecipeDomain.toPresentation(): RecipePresentation {
    return RecipePresentation(
        id = id,
        image = image,
        imageType = imageType,
        title = title
    )
}