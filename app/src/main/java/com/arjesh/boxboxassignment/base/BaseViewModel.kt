package com.arjesh.boxboxassignment.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

abstract class BaseViewModel<
        ScreenVmState : BaseViewModelState,
        ScreenUiState : BaseUiState,
        ScreenUiEffect : BaseEffect,
        >(
    initialState: ScreenVmState,
) : ViewModel() {
    protected val viewModelState = MutableStateFlow(initialState)
    val uiState: StateFlow<ScreenUiState> =
        viewModelState
            .map { state -> state.toUiState() as ScreenUiState }
            .stateIn(
                viewModelScope,
                SharingStarted.Eagerly,
                viewModelState.value.toUiState() as ScreenUiState,
            )
    var effects = Channel<ScreenUiEffect>(Channel.UNLIMITED)
        private set

}
