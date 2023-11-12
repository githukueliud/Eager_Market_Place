package com.example.eagermarketplace.presentation.navigation



sealed class Destinations(val route: String) {
    object OnboardingScreen: Destinations("onboardingScreen")
    object LoginScreen: Destinations("loginScreen")
    object SignupScreen: Destinations("signupScreen")
    object AppStartNavigation: Destinations("appStartNavigation")
    object AppNavigation: Destinations("appNavigation")
    object AppNavigatorScreen: Destinations("App_Navigator_Screen")
    object HomeScreen: Destinations("homeScreen" )
    object CartScreen: Destinations("cartScreen")
    object HistoryScreen: Destinations("historyScreen")

    object ProfileScreen: Destinations("profileScreen")
    object FavoriteScreen: Destinations("favoriteScreen")

    object Settings: Destinations("settingsScreen")
    object AppAuthProcess: Destinations("appAuthProcess")

}