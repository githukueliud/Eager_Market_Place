package com.example.eagermarketplace.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eagermarketplace.data.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    private val _state = MutableStateFlow(OnboardingState())
    val state = _state.asStateFlow()

    private val _onboardingFlow = MutableSharedFlow<OnboardingUiEvents>()
    val onboardingFlow = _onboardingFlow.asSharedFlow()


    fun onEvent(event: OnboardingEvents) {
        when(event) {
            OnboardingEvents.OnBeginClicked -> {
                viewModelScope.launch(Dispatchers.IO) {
                    dataStoreRepository.saveOnboardingState(true)
                    _onboardingFlow.emit(OnboardingUiEvents.NavigateToSignup)
                }
            }
            OnboardingEvents.OnSkipClicked -> {
                viewModelScope.launch(Dispatchers.IO) {
                    dataStoreRepository.saveOnboardingState(true)
                    _onboardingFlow.emit(OnboardingUiEvents.NavigateToLogin)
                }
            }
        }
    }

    private fun readOnboardingState() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    isOnBoarded = dataStoreRepository.readOnboardingState().stateIn(this).value,
                    isLoggedIn = dataStoreRepository.readOnboardingState().stateIn(this).value
                )
            }
            delay(3000)
            if (_state.value.isOnBoarded) {
                if (_state.value.isLoggedIn) {
                    _onboardingFlow.emit(OnboardingUiEvents.NavigateToHome)
                } else {
                    _onboardingFlow.emit(OnboardingUiEvents.NavigateToLogin)
                }
            } else {
                _onboardingFlow.emit(OnboardingUiEvents.BeginOnboarding)
            }
        }
    }


}