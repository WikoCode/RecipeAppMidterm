package com.example.recipeappmidterm.recipies.data.remote.mapper

import com.example.recipeappmidterm.recipies.data.remote.model.Measures
import com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain.MeasuresDomain

fun Measures.toDomain(): MeasuresDomain {
    return MeasuresDomain(
        metric = metric.toDomain(),
        us = us.toDomain()
    )
}