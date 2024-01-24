package com.example.recipeappmidterm.recipies.data.remote.mapper

import com.example.recipeappmidterm.recipies.data.remote.model.RecipeDto
import com.example.recipeappmidterm.recipies.domain.model.RecipeDomain

fun RecipeDto.toDomain(): RecipeDomain {
    return RecipeDomain(
        id = id,
        image = image,
        imageType = imageType,
        title = title
    )
}