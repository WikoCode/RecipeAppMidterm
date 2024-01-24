package com.example.recipeappmidterm.recipies.presentation.mapper

import com.example.recipeappmidterm.recipies.domain.model.UserDomain
import com.example.recipeappmidterm.recipies.presentation.model.UserPresentation

fun UserDomain.toPresentation(): UserPresentation {
    return UserPresentation(
        email = email,
        password = password
    )
}