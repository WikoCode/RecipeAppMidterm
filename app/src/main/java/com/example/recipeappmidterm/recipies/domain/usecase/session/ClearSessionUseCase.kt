package com.example.recipeappmidterm.recipies.domain.usecase.session

import com.example.recipeappmidterm.recipies.domain.repository.datastore.DataStoreRepository
import javax.inject.Inject

class ClearSessionUseCase @Inject constructor(private val dataStoreRepository: DataStoreRepository) {

    suspend operator fun invoke() =dataStoreRepository.clearSession()

}