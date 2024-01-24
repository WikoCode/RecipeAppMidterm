package com.example.recipeappmidterm.recipies.domain.repository.recipe

import com.example.recipeappmidterm.recipies.data.common.Resource
import com.example.recipeappmidterm.recipies.domain.model.RecipeDomain
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun getRecipe(query: String): Flow<Resource<List<RecipeDomain>>>
}
