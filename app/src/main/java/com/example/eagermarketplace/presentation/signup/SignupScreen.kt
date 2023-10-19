package com.example.eagermarketplace.presentation.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun SignupScreen(
    navController: NavController,
    signupViewModel: SignupViewModel = hiltViewModel()
) {
    val state = signupViewModel.state.collectAsState().value
}


@Composable
fun SignupScreenComponent(){}