package com.example.eagermarketplace.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.eagermarketplace.R
import com.example.eagermarketplace.presentation.navigation.Destinations
import com.example.eagermarketplace.presentation.onboarding.components.OnboardingButton
import com.example.eagermarketplace.presentation.onboarding.components.Page
import com.example.eagermarketplace.ui.theme.EagerMarketPlaceTheme
import kotlinx.coroutines.flow.collectLatest


@Composable
fun OnboardingScreen(
    navController: NavController,
    viewModel: OnboardingViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {
        viewModel.onboardingFlow.collectLatest {event ->
            when(event) {
                OnboardingUiEvents.NavigateToLogin -> {
                    navController.navigate(Destinations.LoginScreen.route) {
                        popUpTo(Destinations.OnboardingScreen.route) {
                            inclusive = true
                        }
                    }
                }
                OnboardingUiEvents.NavigateToSignup -> {
                    navController.navigate(Destinations.SignupScreen.route) {
                        popUpTo(Destinations.OnboardingScreen.route) {
                            inclusive = true
                        }
                    }
                }
                OnboardingUiEvents.BeginOnboarding -> {
                    navController.navigate(Destinations.OnboardingScreen.route)
                }

                OnboardingUiEvents.NavigateToHome -> {
                    navController.navigate(Destinations.BottomNavGraph.route){
                        popUpTo(Destinations.OnboardingScreen.route) {
                            inclusive = true
                        }
                    }
                }
            }
        }
    }

}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreenContent(
    onEvent: (OnboardingEvents) -> Unit
) {
    val pageCount = 3
    val numberOfPages = 3
    val initialPage = (numberOfPages - 1).toFloat()
    val pagerState = rememberPagerState(initialPage = 0)


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        item {
            AnimatedVisibility(visible = pagerState.currentPage == 0) {
                OutlinedButton(
                    onClick = { onEvent(OnboardingEvents.OnSkipClicked) },
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(text = "Skip", fontWeight = FontWeight.Bold)
                }
            }
        }
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                HorizontalPager(
                    state = pagerState,
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    pageSpacing = 16.dp,
                    pageCount = pageCount
                ) {page ->
                    when (page) {
                        0 -> {
                            Page(
                                imageId = R.drawable.soko_5,
                                description = "Welcome to your online version of the local kibanda"
                            )
                        }
                        1 -> {
                            Page(
                                imageId = R.drawable.soko_5,
                                description = "Hapa ni mboka mtu yangu"
                            )
                        }
                        2 -> {
                            Page(
                                imageId = R.drawable.soko_6,
                                description = "Sasa wacha tuanze kazi"
                            )
                        }
                    }
                }
                Row(
                    Modifier
                        .height(50.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pageCount) {iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.primary else Color.LightGray
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(20.dp)
                        )
                    }
                }
            }
        }
        item {
            AnimatedVisibility(visible = pagerState.currentPage == 2) {
                OnboardingButton(
                    onClick = { onEvent(OnboardingEvents.OnBeginClicked) },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}


@Preview
@Composable
fun OnboardingScreenContentPreview() {
    EagerMarketPlaceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ){
            OnboardingScreenContent(
                onEvent = {}
            )
        }
    }
}