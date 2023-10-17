package com.example.eagermarketplace.presentation.navigation

sealed class Destinations(val route: String) {
    object OnboardingScreen: Destinations("onboarding_screen")
    object LoginScreen: Destinations("login_screen")
    object SignupScreen: Destinations("signup_screen")
    object BottomNavGraph: Destinations("bottom_nav_graph")
}