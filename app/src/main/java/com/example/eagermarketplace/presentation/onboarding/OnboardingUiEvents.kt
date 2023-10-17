package com.example.eagermarketplace.presentation.onboarding

sealed interface OnboardingUiEvents {
    object NavigateToSignup: OnboardingUiEvents
    object NavigateToLogin: OnboardingUiEvents
}