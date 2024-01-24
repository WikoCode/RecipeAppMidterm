package com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain

data class ExtendedIngredientDomain(
    val aisle: String,
    val amount: Double,
    val id: Int,
    val image: String,
    val measures: MeasuresDomain,
    val meta: List<String>,
    val name: String,
    val unit: String
)