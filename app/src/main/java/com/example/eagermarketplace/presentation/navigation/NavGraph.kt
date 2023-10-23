package com.example.eagermarketplace.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.eagermarketplace.presentation.bottombar.BottomBar
import com.example.eagermarketplace.presentation.homescreen.HomeScreen
import com.example.eagermarketplace.presentation.login.LoginScreen
import com.example.eagermarketplace.presentation.onboarding.OnboardingScreen
import com.example.eagermarketplace.presentation.onboarding.OnboardingViewModel
import com.example.eagermarketplace.presentation.signup.SignupScreen


@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        //onboarding process
        navigation(
            route = Destinations.AppStartNavigation.route,
            startDestination = Destinations.OnboardingScreen.route
        ) {
            composable(route = Destinations.OnboardingScreen.route) {
                val viewModel: OnboardingViewModel = hiltViewModel()
                OnboardingScreen(event = viewModel::onEvent)
            }
        }
        
        //login & signup process
        navigation(
            route = Destinations.AppAuthProcess.route,
            startDestination = Destinations.SignupScreen.route
        ) {
            composable(route = Destinations.SignupScreen.route) {
                SignupScreen(navController = navController)
            }
            composable(route = Destinations.LoginScreen.route) {
                LoginScreen(navController = navController)
            }
        }

        
        //app navigation once logged in
        navigation(
            startDestination = Destinations.BottomBar.route,
            route = Destinations.BottomNavGraph.route
        ) {
            composable(route = Destinations.BottomBar.route) {
                BottomBar(navController = navController)
            }
        }
    }
}

