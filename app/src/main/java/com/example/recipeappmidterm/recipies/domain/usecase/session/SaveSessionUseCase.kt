package com.example.recipeappmidterm.recipies.domain.usecase.session

import com.example.recipeappmidterm.recipies.data.local.DataStoreKeys
import com.example.recipeappmidterm.recipies.domain.repository.datastore.DataStoreRepository
import javax.inject.Inject

class SaveSessionUseCase @Inject constructor(private val dataStoreRepository: DataStoreRepository) {

    suspend operator fun invoke(token:String) = dataStoreRepository.saveSession(DataStoreKeys.USER_LOGGED_IN_KEY,token)

}