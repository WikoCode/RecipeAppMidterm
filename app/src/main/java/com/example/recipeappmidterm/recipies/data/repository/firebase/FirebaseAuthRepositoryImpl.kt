package com.example.recipeappmidterm.recipies.data.repository.firebase

import com.example.recipeappmidterm.recipies.data.common.Resource
import com.example.recipeappmidterm.recipies.domain.model.UserDomain
import com.example.recipeappmidterm.recipies.domain.repository.firebase.FirebaseAuthRepository
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    FirebaseAuthRepository {
    override suspend fun registerUser(user: UserDomain): Flow<Resource<AuthResult>> = flow {

        emit(Resource.Loading(loading = true))
        try {
            val result =
                firebaseAuth.createUserWithEmailAndPassword(user.email, user.password).await()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: ""))
        }
        emit(Resource.Loading(loading =false))
    }

    override suspend fun loginUser(user: UserDomain): Flow<Resource<AuthResult>> = flow {
        emit(Resource.Loading(loading = true))
        try {
            val result = firebaseAuth.signInWithEmailAndPassword(user.email, user.password).await()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: ""))
        }
        emit(Resource.Loading(loading = false))
    }

}