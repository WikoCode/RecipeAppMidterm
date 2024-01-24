package com.example.recipeappmidterm.recipies.presentation.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeappmidterm.recipies.data.common.Resource
import com.example.recipeappmidterm.recipies.domain.model.UserDomain
import com.example.recipeappmidterm.recipies.domain.usecase.auth.LoginUseCase
import com.example.recipeappmidterm.recipies.domain.usecase.session.SaveSessionUseCase
import com.example.recipeappmidterm.recipies.presentation.event.LoginEvent
import com.example.recipeappmidterm.recipies.presentation.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val saveSessionUseCase: SaveSessionUseCase
) : ViewModel() {

    private val _userLoginState = MutableStateFlow(LoginState())
    val userLoginState: StateFlow<LoginState> = _userLoginState

    private val _navigationEvent = MutableSharedFlow<UserLoginNavigation>()
    val navigationEvent get() =  _navigationEvent

    fun handleEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.Login -> authenticateUser(event.email, event.password)
            LoginEvent.LoginToRegistration -> navigateToSignUpScreen()
            LoginEvent.ResetErrorMessage -> clearLoginError()
        }
    }

    private fun authenticateUser(email: String, password: String) {
        val user = UserDomain(email = email, password = password)
        viewModelScope.launch {
            loginUseCase(user).collect { result ->
                when (result) {
                    is Resource.Error -> _userLoginState.update { it.copy(errorMessage = result.errorMessage) }
                    is Resource.Loading -> _userLoginState.update { it.copy(isLoading = true) }
                    is Resource.Success -> handleSuccessfulLogin(result.data?.user?.uid)
                }
            }
        }
    }

    private fun handleSuccessfulLogin(token: String?) {
        _userLoginState.update { it.copy(accessToken = token.orEmpty()) }
        storeToken(token.orEmpty())
        navigateToHomeScreen()
    }

    private fun storeToken(token: String) {
        viewModelScope.launch { saveSessionUseCase(token) }
    }

    private fun navigateToHomeScreen() = viewModelScope.launch {
        _navigationEvent.emit(UserLoginNavigation.NavigateHome)
    }

    private fun navigateToSignUpScreen() = viewModelScope.launch {
        _navigationEvent.emit(UserLoginNavigation.NavigateSignUp)
    }

    private fun clearLoginError() {
        _userLoginState.update { it.copy(errorMessage = null) }
    }

    sealed interface UserLoginNavigation {
        object NavigateHome : UserLoginNavigation
        object NavigateSignUp : UserLoginNavigation
    }
}