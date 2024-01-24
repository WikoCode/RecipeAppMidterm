package com.example.recipeappmidterm.recipies.presentation.model.recipedetailpresentation

import com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain.MetricDomain
import com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain.UsDomain

data class MeasuresPresentation(
    val metric: MetricDomain,
    val us: UsDomain
)
