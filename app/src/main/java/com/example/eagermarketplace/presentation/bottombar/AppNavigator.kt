package com.example.eagermarketplace.presentation.bottombar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.eagermarketplace.R
import com.example.eagermarketplace.presentation.bottombar.bottombarcomponent.BottomNavigation
import com.example.eagermarketplace.presentation.bottombar.bottombarcomponent.BottomNavigationItem
import com.example.eagermarketplace.presentation.cart.CartScreen
import com.example.eagermarketplace.presentation.favorite.FavoriteScreen
import com.example.eagermarketplace.presentation.homescreen.HomeScreen
import com.example.eagermarketplace.presentation.navigation.Destinations
import com.example.eagermarketplace.presentation.user_profile.ProfileScreen
import com.example.eagermarketplace.presentation.user_profile.UserProfileScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigator() {
    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_bookmark, text = "Favorite"),
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Cart"),
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Profile")
        )
    }

    val navController = rememberNavController()
    val backstackState = navController.currentBackStackEntryAsState().value

    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }

    selectedItem = when(backstackState?.destination?.route) {
        Destinations.HomeScreen.route -> 0
        Destinations.CartScreen.route -> 1
        Destinations.FavoriteScreen.route -> 2
        Destinations.ProfileScreen.route -> 3
        else -> 0
    }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                items = bottomNavigationItems,
                selected = selectedItem,
                onItemClicked = {index ->
                    when (index) {
                        0 -> navigateToTab(
                            navController = navController,
                            route = Destinations.HomeScreen.route
                        )
                        1 -> navigateToTab(
                            navController = navController,
                            Destinations.CartScreen.route
                        )
                        2 -> navigateToTab(
                            navController = navController,
                            route = Destinations.FavoriteScreen.route
                        )
                        3 -> navigateToTab(
                            navController = navController,
                            route = Destinations.ProfileScreen.route
                        )
                    }
                }
            )
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Destinations.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Destinations.HomeScreen.route) {
                HomeScreen()
            }
            composable(route = Destinations.CartScreen.route) {
                CartScreen()
            }
            composable(route = Destinations.FavoriteScreen.route) {
                FavoriteScreen()
            }
            composable(route = Destinations.ProfileScreen.route) {
                ProfileScreen()
            }
        }
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?. let {homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}
