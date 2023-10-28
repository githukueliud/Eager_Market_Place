package com.example.eagermarketplace.presentation.user_profile

import androidx.annotation.DrawableRes

data class UserProfileState(
    val username: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val changePassword: String = "",
    val changeEmail: String = "",
    val emailError: String = "",
    val passwordEmail: String = "",
    val passwordVisibility: Boolean = false,
    val changeLocation: String = "",
    @DrawableRes val userImage: Int
)
