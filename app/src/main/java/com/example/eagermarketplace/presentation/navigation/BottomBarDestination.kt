package com.example.eagermarketplace.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarDestination(val route: String, val label: String, val icon: ImageVector) {
    object HomeScreen: BottomBarDestination("home_screen", "home", Icons.Filled.Home)

    object Cart: BottomBarDestination("cart_screen", "cart", Icons.Filled.ShoppingCart)

    object History: BottomBarDestination("history_screen", "history", Icons.Filled.Timelapse)

    object Settings: BottomBarDestination("settings_screen", "settings", Icons.Filled.Settings)
}