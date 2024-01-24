package com.example.recipeappmidterm.recipies.domain.usecase.auth

import com.example.recipeappmidterm.recipies.data.common.Resource
import com.example.recipeappmidterm.recipies.domain.model.UserDomain
import com.example.recipeappmidterm.recipies.domain.repository.firebase.FirebaseAuthRepository
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: FirebaseAuthRepository) {

    suspend operator fun invoke(user: UserDomain): Flow<Resource<AuthResult>> {
        return authRepository.loginUser(user)
    }
}