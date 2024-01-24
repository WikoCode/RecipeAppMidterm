package com.example.recipeappmidterm.recipies.presentation.state

data class RegisterState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isRegisterSuccesful: Boolean = false
)