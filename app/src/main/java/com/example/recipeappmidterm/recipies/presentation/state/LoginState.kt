package com.example.recipeappmidterm.recipies.presentation.state

data class LoginState (
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val accessToken: String? = null
    )