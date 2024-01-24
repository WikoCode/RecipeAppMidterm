package com.example.recipeappmidterm.recipies.presentation.model.recipedetailpresentation

import com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain.MeasuresDomain

data class ExtendedIngredientPresentation(
    val aisle: String,
    val amount: Double,
    val id: Int,
    val image: String,
    val measures: MeasuresDomain,
    val meta: List<String>,
    val name: String,
    val unit: String
)
