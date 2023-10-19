package com.example.eagermarketplace.presentation.login

sealed interface LoginUIEvents {
    data class ShowSnackBar(val message: String): LoginUIEvents
    object NavigateToHome: LoginUIEvents
    object NavigateToSignup: LoginUIEvents
}