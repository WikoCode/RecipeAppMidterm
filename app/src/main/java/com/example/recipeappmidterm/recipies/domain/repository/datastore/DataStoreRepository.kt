package com.example.recipeappmidterm.recipies.domain.repository.datastore

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun saveSession(key: Preferences.Key<String>, value: String)

    fun readSession(key: Preferences.Key<String>): Flow<String>

    suspend fun clearSession()


}