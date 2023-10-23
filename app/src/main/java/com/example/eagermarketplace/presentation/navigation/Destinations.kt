package com.example.eagermarketplace.presentation.navigation

sealed class Destinations(val route: String) {
    object OnboardingScreen: Destinations("onboardingScreen")
    object LoginScreen: Destinations("loginScreen")
    object SignupScreen: Destinations("signupScreen")
    object BottomNavGraph: Destinations("bottomNavGraph")
    object AppStartNavigation: Destinations("appStartNavigation")
    object AppNavigation: Destinations("appNavigation")
    object AppNavigatorScreen: Destinations("appNavigatorScreen")

    object BottomBar: Destinations("bottomBar")
    object AppAuthProcess: Destinations("appAuthProcess")

}