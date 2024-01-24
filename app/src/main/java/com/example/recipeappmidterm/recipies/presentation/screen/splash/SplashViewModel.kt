package com.example.recipeappmidterm.recipies.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeappmidterm.recipies.domain.usecase.session.GetSessionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getSessionUseCase: GetSessionUseCase
) : ViewModel() {

    private val _uiEvent = MutableSharedFlow<SplashUiEvent>()
    val uiEvent: SharedFlow<SplashUiEvent> get() = _uiEvent

    init {
        readSession()
    }

    private fun readSession() {
        viewModelScope.launch {
            getSessionUseCase().collect {
                if (it.isEmpty())
                    _uiEvent.emit(SplashUiEvent.NavigateToLogIn)
                else
                    _uiEvent.emit(SplashUiEvent.NavigateToHome)
            }
        }
    }


    sealed interface SplashUiEvent {
        data object NavigateToLogIn : SplashUiEvent
        data object NavigateToHome : SplashUiEvent
    }


}