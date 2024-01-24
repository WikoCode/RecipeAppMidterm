package com.example.recipeappmidterm.recipies.presentation.screen.splash

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.recipeappmidterm.databinding.FragmentSplashBinding
import com.example.recipeappmidterm.recipies.presentation.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    private val viewModel: SplashViewModel by viewModels()

    override fun setupUI() {

    }

    override fun setupListeners() {

    }

    override fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiEvent.collect {
                    handleNavigationEvents(event = it)
                }
            }
        }
    }

    private fun handleNavigationEvents(event: SplashViewModel.SplashUiEvent) {
        when (event) {
            is SplashViewModel.SplashUiEvent.NavigateToHome -> findNavController().navigate(
                SplashFragmentDirections.actionSplashFragmentToHomeFragment()
            )

            is SplashViewModel.SplashUiEvent.NavigateToLogIn -> findNavController().navigate(
                SplashFragmentDirections.actionSplashFragmentToLoginFragment()
            )
        }
    }
}