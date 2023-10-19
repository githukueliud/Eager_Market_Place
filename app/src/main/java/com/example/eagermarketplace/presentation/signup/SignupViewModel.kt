package com.example.eagermarketplace.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eagermarketplace.data.repository.AuthRepository
import com.example.eagermarketplace.data.repository.FormValidationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignupViewModel @Inject constructor(
    private val formValidationRepository: FormValidationRepository,
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SignupState())
    val state = _state.asStateFlow()

    private val _eventFlow = MutableSharedFlow<SignupUiEvents>()
    val eventFlow = _eventFlow.asSharedFlow()


    fun onEvent(event: SignupEvents) {
        when (event) {
            is SignupEvents.OnEmailChanged -> {
                _state.update { it.copy(email = event.email) }
            }
            is SignupEvents.OnPasswordChanged -> {
                _state.update { it.copy(password = event.password) }
            }
            is SignupEvents.OnConfirmPasswordChanged -> {
                _state.update { it.copy(confirmPassword = event.confirmPassword) }
            }
            is SignupEvents.OnUsernameChanged -> {
                _state.update { it.copy(username = event.name) }
            }
            SignupEvents.OnSignupClicked -> {
                submitData()
            }
            SignupEvents.OnLoginClicked -> {
                viewModelScope.launch {
                    _eventFlow.emit(SignupUiEvents.NavigateToLogin)
                }
            }
            SignupEvents.OnPasswordVisibilityClicked -> {
                _state.update { it.copy(passwordVisibility = !_state.value.passwordVisibility) }
            }
        }
    }

    private fun submitData() {
        val usernameResult = formValidationRepository.validateUsername(_state.value.username)
        val emailResult = formValidationRepository.validateEmail(_state.value.email)
        val passwordResult = formValidationRepository.validatePassword(_state.value.password)
        val confirmPasswordResult = formValidationRepository.validateConfirmPassword(
            _state.value.password,
            _state.value.confirmPassword
        )

        val hasError = listOf(
            usernameResult,
            emailResult,
            passwordResult,
            confirmPasswordResult
        ).any { !it.successful }

        if (hasError) {
            _state.update {
                it.copy(
                    usernameError = usernameResult.message,
                    emailError = emailResult.message,
                    passwordError =  passwordResult.message,
                    confirmPasswordError = confirmPasswordResult.message
                )
            }
            return
        } else {
            //handle the sign up request
        }

    }


}