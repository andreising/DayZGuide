package com.andreisingeleytsev.dayzguide.ui.activity

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.articlesapp.data.datastore.DataStoreRepository
import com.andreisingeleytsev.dayzguide.ui.utils.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
): ViewModel() {
    private val _isLoading = mutableStateOf(true)
    val isLoading = _isLoading

    private val _startDestination: MutableState<String?> = mutableStateOf(null)
    val startDestination: State<String?> = _startDestination

    fun onBoardFinished(){
        viewModelScope.launch {
            dataStoreRepository.saveOnBoardingState(true)
            _startDestination.value = Routes.HOME_SCREEN
        }
    }
    init {
        viewModelScope.launch {
            dataStoreRepository.readOnBoardingState().collect{completed ->
                if (completed) {
                    _startDestination.value = Routes.HOME_SCREEN
                } else {
                    _startDestination.value = Routes.ONBOARDING_SCREEN
                }
                _isLoading.value = false
            }
        }
    }
}