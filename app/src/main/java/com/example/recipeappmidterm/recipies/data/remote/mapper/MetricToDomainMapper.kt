package com.example.recipeappmidterm.recipies.data.remote.mapper

import com.example.recipeappmidterm.recipies.data.remote.model.Metric
import com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain.MetricDomain

fun Metric.toDomain(): MetricDomain {
    return MetricDomain(
        amount = amount,
        unitLong = unitLong,
        unitShort = unitShort
    )
}