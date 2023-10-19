package com.example.eagermarketplace.presentation.signup

sealed interface SignupUiEvents {
    object NavigateToLogin: SignupUiEvents
    data class ShowSnackBar(val message: String): SignupUiEvents
}