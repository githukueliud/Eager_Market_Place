package com.example.eagermarketplace.presentation.onboarding

sealed interface OnboardingEvents{
    object OnSkipClicked: OnboardingEvents
    object OnBeginClicked: OnboardingEvents
}