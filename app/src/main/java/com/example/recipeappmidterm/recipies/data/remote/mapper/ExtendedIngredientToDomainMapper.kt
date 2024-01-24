package com.example.recipeappmidterm.recipies.data.remote.mapper

import com.example.recipeappmidterm.recipies.data.remote.model.ExtendedIngredient
import com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain.ExtendedIngredientDomain


fun ExtendedIngredient.toDomain(): ExtendedIngredientDomain {
    return ExtendedIngredientDomain(
        id = id,
        name = name,
        amount = amount,
        unit = unit,
        measures = measures.toDomain(),
        image = image,
        aisle = aisle,
        meta = meta
    )
}