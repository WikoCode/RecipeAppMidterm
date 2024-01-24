package com.example.recipeappmidterm.recipies.presentation.screen.login

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.recipeappmidterm.R
import com.example.recipeappmidterm.databinding.FragmentLoginBinding
import com.example.recipeappmidterm.recipies.presentation.common.BaseFragment
import com.example.recipeappmidterm.recipies.presentation.event.LoginEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels()

    override fun setupUI() {
    }

    override fun setupListeners() {
        binding.btnSignIn.setOnClickListener {
            val email = binding.etLoginEmail.text.toString()
            val password = binding.etLoginPassword.text.toString()
            viewModel.handleEvent(LoginEvent.Login(email, password))
        }

        binding.tvLoginSignUp.setOnClickListener {
            navigateToSignUp()
        }

        binding.tvForgotPassword.setOnClickListener {

        }

        binding.btnLoginGoogle.setOnClickListener {

        }
    }

    override fun setupObservers() {
        observeLoginState()
        observeNavigationEvents()
    }

    private fun observeLoginState() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                viewModel.userLoginState.collect { state ->
                    state.errorMessage?.let {
                        Toast.makeText(
                            requireContext(),
                            "${state.errorMessage}",
                            Toast.LENGTH_SHORT
                        ).show()
                        viewModel.handleEvent(LoginEvent.ResetErrorMessage)
                    }

                    binding.apply {
                        progressBar.visibility =
                            if (state.isLoading) View.VISIBLE else View.GONE
                    }


                    state.accessToken?.let {
                        Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }

    private fun observeNavigationEvents() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.navigationEvent.collect { event ->
                    when (event) {
                        LoginViewModel.UserLoginNavigation.NavigateHome -> navigateToHome()
                        LoginViewModel.UserLoginNavigation.NavigateSignUp -> navigateToSignUp()
                    }
                }
            }
        }
    }

    private fun navigateToHome() {
        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }

    private fun navigateToSignUp() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }
}
