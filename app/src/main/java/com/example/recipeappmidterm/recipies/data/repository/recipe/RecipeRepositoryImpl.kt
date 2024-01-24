package com.example.recipeappmidterm.recipies.data.repository.recipe

import com.example.recipeappmidterm.recipies.data.common.HandleResponse
import com.example.recipeappmidterm.recipies.data.common.Resource
import com.example.recipeappmidterm.recipies.data.remote.mapper.base.asResource
import com.example.recipeappmidterm.recipies.data.remote.mapper.toDomain
import com.example.recipeappmidterm.recipies.data.remote.service.RecipeService
import com.example.recipeappmidterm.recipies.domain.model.RecipeDomain
import com.example.recipeappmidterm.recipies.domain.repository.recipe.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipeService: RecipeService,
    private val handleResponse: HandleResponse
) : RecipeRepository {

    override suspend fun getRecipe(query: String): Flow<Resource<List<RecipeDomain>>> {
        return handleResponse.safeApiCall {
            recipeService.getRecipe(query)
        }.asResource {
            it.map { dto ->
                dto.toDomain()
            }
        }
    }
}
