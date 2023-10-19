package com.example.eagermarketplace.presentation.signup

data class SignupState(
    val username: String = "",
    val usernameError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val confirmPassword: String = "",
    val confirmPasswordError: String? = null,
    val loading: Boolean = false,
    val passwordVisibility: Boolean = false
)
