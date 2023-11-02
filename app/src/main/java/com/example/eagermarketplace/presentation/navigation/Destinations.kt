package com.example.eagermarketplace.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Timelapse

sealed class Destinations(val route: String) {
    object OnboardingScreen: Destinations("onboardingScreen")
    object LoginScreen: Destinations("loginScreen")
    object SignupScreen: Destinations("signupScreen")
    object BottomNavGraph: Destinations("bottomNavGraph")
    object AppStartNavigation: Destinations("appStartNavigation")
    object AppNavigation: Destinations("appNavigation")
    object AppNavigatorScreen: Destinations("appNavigatorScreen")
    object HomeScreen: Destinations("homeScreen" )

    object CartScreen: Destinations("cartScreen")

    object ProfileScreen: Destinations("profileScreen")
    object FavoriteScreen: Destinations("profileScreen")

    object Settings: Destinations("settingsScreen")
    object BottomBar: Destinations("bottomBar")
    object AppAuthProcess: Destinations("appAuthProcess")

}