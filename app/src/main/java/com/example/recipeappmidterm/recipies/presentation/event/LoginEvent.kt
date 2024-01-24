package com.example.recipeappmidterm.recipies.presentation.event

sealed class LoginEvent {
    data class Login(
        val email: String,
        val password: String
    ) : LoginEvent()

    data object LoginToRegistration : LoginEvent()
    data object ResetErrorMessage : LoginEvent()
}