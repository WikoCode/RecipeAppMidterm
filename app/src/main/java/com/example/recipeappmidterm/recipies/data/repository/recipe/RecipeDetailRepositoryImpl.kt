package com.example.recipeappmidterm.recipies.data.repository.recipe

import com.example.recipeappmidterm.recipies.data.common.HandleResponse
import com.example.recipeappmidterm.recipies.data.common.Resource
import com.example.recipeappmidterm.recipies.data.remote.mapper.base.asResource
import com.example.recipeappmidterm.recipies.data.remote.mapper.toDomain
import com.example.recipeappmidterm.recipies.data.remote.service.RecipeDetailService
import com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain.RecipeDetailDomain
import com.example.recipeappmidterm.recipies.domain.repository.recipe.RecipeDetailRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class RecipeDetailRepositoryImpl @Inject constructor(
    private val recipeDetailService: RecipeDetailService,
    private val handleResponse: HandleResponse
) : RecipeDetailRepository {

    override suspend fun getRecipeDetail(recipeId: Long): RecipeDetailDomain {
        val responseFlow = handleResponse.safeApiCall {
            recipeDetailService.getRecipeInformation(recipeId)
        }
        val domainFlow = responseFlow.asResource { dto ->
            dto.toDomain()
        }

        // Assuming we want to get the first emitted item and that the flow won't be empty
        return when (val firstItem = domainFlow.first()) {
            is Resource.Success -> firstItem.data ?: throw Exception("Data not found")
            is Resource.Error -> throw Exception(firstItem.errorMessage)
            is Resource.Loading -> throw Exception("Loading state not handled")
        }
    }
}
