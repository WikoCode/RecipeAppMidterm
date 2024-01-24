package com.example.recipeappmidterm.recipies.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.recipeappmidterm.recipies.data.common.HandleResponse
import com.example.recipeappmidterm.recipies.data.remote.service.RecipeDetailService
import com.example.recipeappmidterm.recipies.data.remote.service.RecipeService
import com.example.recipeappmidterm.recipies.data.repository.datastore.DataStoreRepositoryImpl
import com.example.recipeappmidterm.recipies.data.repository.firebase.FirebaseAuthRepositoryImpl
import com.example.recipeappmidterm.recipies.data.repository.recipe.RecipeDetailRepositoryImpl
import com.example.recipeappmidterm.recipies.data.repository.recipe.RecipeRepositoryImpl
import com.example.recipeappmidterm.recipies.domain.repository.datastore.DataStoreRepository
import com.example.recipeappmidterm.recipies.domain.repository.firebase.FirebaseAuthRepository
import com.example.recipeappmidterm.recipies.domain.repository.recipe.RecipeDetailRepository
import com.example.recipeappmidterm.recipies.domain.repository.recipe.RecipeRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRecipeRepository(
        recipeService: RecipeService,
        handleResponse: HandleResponse
    ) : RecipeRepository {
        return RecipeRepositoryImpl(
            handleResponse = handleResponse,
            recipeService = recipeService
        )
    }

    @Provides
    @Singleton
    fun provideRecipeDetailRepository(
        recipeDetailService: RecipeDetailService,
        handleResponse: HandleResponse
    ): RecipeDetailRepository {
        return RecipeDetailRepositoryImpl(
            handleResponse = handleResponse,
            recipeDetailService = recipeDetailService

        )
    }

    @Provides
    @Singleton
    fun provideDataStoreRepository(dataStore: DataStore<Preferences>): DataStoreRepository {
        return DataStoreRepositoryImpl(dataStore)
    }

    @Provides
    @Singleton
    fun provideFirebaseRepository(firebaseAuth: FirebaseAuth): FirebaseAuthRepository {
        return FirebaseAuthRepositoryImpl(
            firebaseAuth = firebaseAuth
        )
    }


}