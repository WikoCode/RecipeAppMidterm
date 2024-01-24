package com.example.recipeappmidterm.recipies.domain.usecase.recipe

import com.example.recipeappmidterm.recipies.domain.model.recipedetaildomain.RecipeDetailDomain
import com.example.recipeappmidterm.recipies.domain.repository.recipe.RecipeDetailRepository
import javax.inject.Inject

class GetRecipeDetailsUseCase @Inject constructor(
    private val recipeDetailRepository: RecipeDetailRepository
){
    suspend operator fun invoke(recipeId: Long): RecipeDetailDomain {
        return recipeDetailRepository.getRecipeDetail(recipeId)
    }

}