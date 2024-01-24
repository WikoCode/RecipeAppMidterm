package com.example.recipeappmidterm.recipies.data.remote.service

import com.example.recipeappmidterm.recipies.data.remote.model.RecipeDetailDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeDetailService {
    @GET("recipes/{id}/information")
    suspend fun getRecipeInformation(@Path("id") recipeId: Long): Response<RecipeDetailDto>
}
