package com.example.recipeappmidterm.recipies.domain.repository.recipe

import com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain.RecipeDetailDomain

interface RecipeDetailRepository {
    suspend fun getRecipeDetail(recipeId: Long): RecipeDetailDomain
}
