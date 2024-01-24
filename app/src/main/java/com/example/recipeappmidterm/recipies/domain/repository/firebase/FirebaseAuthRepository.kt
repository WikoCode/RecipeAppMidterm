package com.example.recipeappmidterm.recipies.domain.repository.firebase

import com.example.recipeappmidterm.recipies.data.common.Resource
import com.example.recipeappmidterm.recipies.domain.model.UserDomain
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface FirebaseAuthRepository {
    suspend fun registerUser(user: UserDomain): Flow<Resource<AuthResult>>

    suspend fun loginUser(user: UserDomain): Flow<Resource<AuthResult>>

}