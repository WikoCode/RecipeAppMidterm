package com.example.recipeappmidterm.recipies.domain.usecase.recipe

import com.example.recipeappmidterm.recipies.data.common.Resource
import com.example.recipeappmidterm.recipies.domain.model.RecipeDomain
import com.example.recipeappmidterm.recipies.domain.repository.recipe.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipeUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository
) {

    suspend fun invoke(query: String): Flow<Resource<List<RecipeDomain>>> {
        return recipeRepository.getRecipe(query)
    }
}
