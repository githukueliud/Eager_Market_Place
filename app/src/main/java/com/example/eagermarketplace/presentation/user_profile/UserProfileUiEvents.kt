package com.example.eagermarketplace.presentation.user_profile

sealed interface UserProfileUiEvents {
    data class ShowSnackBar (val message: String): UserProfileUiEvents

    object NavigateToHome: UserProfileUiEvents

    object NavigateToCart: UserProfileUiEvents
}