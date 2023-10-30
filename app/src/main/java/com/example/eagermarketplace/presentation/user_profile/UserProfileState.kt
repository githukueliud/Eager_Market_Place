package com.example.eagermarketplace.presentation.user_profile

import androidx.annotation.DrawableRes

data class UserProfileState(
    val username: String = "",
    val usernameError: String = "",
    val firstName: String = "",
    val firstNameError: String = "",
    val lastName: String = "",
    val lastNameError: String = "",
    val changePassword: String = "",
    val changeEmail: String = "",
    val emailError: String = "",
    val passwordError: String = "",
    val passwordVisibility: Boolean = false,
    val changeLocation: String = "",
    @DrawableRes val userImage: Int
)
