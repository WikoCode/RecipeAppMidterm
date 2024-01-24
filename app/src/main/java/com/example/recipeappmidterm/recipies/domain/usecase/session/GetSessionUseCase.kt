package com.example.recipeappmidterm.recipies.domain.usecase.session

import com.example.recipeappmidterm.recipies.domain.repository.datastore.DataStoreRepository
import com.example.recipeappmidterm.recipies.data.local.DataStoreKeys
import javax.inject.Inject

class GetSessionUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
){
    operator fun invoke() = dataStoreRepository.readSession(DataStoreKeys.USER_LOGGED_IN_KEY)
}