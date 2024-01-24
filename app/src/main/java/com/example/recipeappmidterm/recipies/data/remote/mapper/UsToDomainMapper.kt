package com.example.recipeappmidterm.recipies.data.remote.mapper

import com.example.recipeappmidterm.recipies.data.remote.model.Us
import com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain.UsDomain

fun Us.toDomain(): UsDomain {
    return UsDomain(
        amount = amount,
        unitLong = unitLong,
        unitShort = unitShort
    )
}