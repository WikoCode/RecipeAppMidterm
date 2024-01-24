package com.example.recipeappmidterm.recipies.presentation.event

sealed class RegisterEvent {
    data class Register(
        val email: String,
        val password: String
    ) : RegisterEvent()

    data class RegisterToLogin(
        val email: String,
        val password: String
    ) : RegisterEvent()

    data object ResetErrorMessage : RegisterEvent()
}