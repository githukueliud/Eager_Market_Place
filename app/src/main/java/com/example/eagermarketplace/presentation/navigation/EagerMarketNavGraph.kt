package com.example.eagermarketplace.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.eagermarketplace.presentation.cart.CartScreen
import com.example.eagermarketplace.presentation.history.HistoryScreen
import com.example.eagermarketplace.presentation.homescreen.HomeScreen
import com.example.eagermarketplace.presentation.login.LoginScreen
import com.example.eagermarketplace.presentation.onboarding.OnboardingScreen
import com.example.eagermarketplace.presentation.onboarding.OnboardingViewModel
import com.example.eagermarketplace.presentation.settings.SettingsScreen
import com.example.eagermarketplace.presentation.signup.SignupScreen


@Composable
fun EagerMarketAppNav(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destinations.OnboardingScreen.route
    ) {
        composable(route = Destinations.OnboardingScreen.route) {
            val viewModel: OnboardingViewModel = hiltViewModel()
            OnboardingScreen(navController = navController, event = viewModel::onEvent)
        }
        composable(route = Destinations.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Destinations.SignupScreen.route) {
            SignupScreen(navController = navController)
        }
        bottomBarGraph(navController = navController)
    }
}

fun NavGraphBuilder.bottomBarGraph(navController: NavController) {
    navigation(
        startDestination = BottomBarDestination.HomeScreen.route,
        route = Destinations.BottomNavGraph.route
    ) {
        composable(route = BottomBarDestination.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = BottomBarDestination.Cart.route) {
            CartScreen()
        }
        composable(route = BottomBarDestination.History.route) {
            HistoryScreen()
        }
        composable(route = BottomBarDestination.Settings.route) {
            SettingsScreen()
        }
    }
}