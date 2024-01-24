package com.example.recipeappmidterm.recipies.data.remote.service

import com.example.recipeappmidterm.recipies.data.remote.model.RecipeDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {
    @GET("recipes/complexSearch")
    suspend fun getRecipe(@Query("query") query: String): Response<List<RecipeDto>>
}

