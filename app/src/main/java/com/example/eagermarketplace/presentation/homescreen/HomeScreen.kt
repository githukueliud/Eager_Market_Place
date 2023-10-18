package com.example.eagermarketplace.presentation.homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.eagermarketplace.presentation.onboarding.OnboardingEvents
import com.example.eagermarketplace.presentation.onboarding.OnboardingViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: OnboardingViewModel = hiltViewModel()
) {}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreenContent(
    onEvent: (OnboardingEvents) -> Unit
) {
    val pageCount = 3
//    val pageState = rememberPagerState{
//        3
//    }
}