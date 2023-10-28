package com.example.eagermarketplace.presentation.user_profile

sealed interface UserProfileEvents {
    object OnNavigateToHomeClicked: UserProfileEvents
    object OnNavigateToCartClicked: UserProfileEvents
    data class OnUsernameChanged(val username: String): UserProfileEvents
    data class OnEmailChanged(val email: String): UserProfileEvents

    data class OnImageChanged(val imageUrl: String): UserProfileEvents
    data class OnFirstNameChanged(val firstName: String): UserProfileEvents
    data class OnLastNameChanged(val lastName: String): UserProfileEvents

    data class OnLocationChanged(val location: String): UserProfileEvents

    object onSaveClicked: UserProfileEvents

}