package com.example.eagermarketplace.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarDestination(val route: String, val label: String, val icon: ImageVector) {
    object HomeScreen: BottomBarDestination("homeScreen", "home", Icons.Filled.Home)

    object CartScreen: BottomBarDestination("cartScreen", "cart", Icons.Filled.ShoppingCart)

    object History: BottomBarDestination("historyScreen", "history", Icons.Filled.Timelapse)

    object Settings: BottomBarDestination("settingsScreen", "settings", Icons.Filled.Settings)
}