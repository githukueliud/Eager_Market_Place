package com.example.eagermarketplace.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.eagermarketplace.presentation.Dimens.MediumPadding1
import com.example.eagermarketplace.presentation.Dimens.PaddingIndicatorWidth
import com.example.eagermarketplace.presentation.common.AppButton
import com.example.eagermarketplace.presentation.common.AppTextButton
import com.example.eagermarketplace.presentation.onboarding.components.OnboardingPage
import com.example.eagermarketplace.presentation.onboarding.components.PageIndicator
import com.example.eagermarketplace.ui.theme.EagerMarketPlaceTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    navController: NavController,
    event: (OnboardingEvent) -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }
        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) {index ->
            OnboardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding1)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.padding(PaddingIndicatorWidth),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )


            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val scope = rememberCoroutineScope()
                if (buttonState.value[0].isNotEmpty()) {
                    AppTextButton(
                        text = buttonState.value[0],
                        onclick = {
                            scope.launch {
                                pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                            }
                        }
                    )
                }
                AppButton(
                    text = buttonState.value[1],
                    onclick = {
                        scope.launch {
                            if (pagerState.currentPage == 2) {
                                //Navigate to signup screen
                                event(OnboardingEvent.SaveAppEntry)
                            } else {
                                pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                            }
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.weight(0.5f)) //placed before the column closes
    }
}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreenContent(

) {

}


@Preview
@Composable
fun OnboardingScreenContentPreview() {
    EagerMarketPlaceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ){

        }
    }
}