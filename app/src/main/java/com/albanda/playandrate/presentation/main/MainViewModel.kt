package com.albanda.playandrate.presentation.main

import androidx.lifecycle.ViewModel
import com.albanda.playandrate.domain.repository.AuthRepository
import com.albanda.playandrate.presentation.navigation.Graph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: AuthRepository
) : ViewModel() {

    private val _startDestination = MutableStateFlow(Graph.AUTHENTICATION)
    val startDestination: StateFlow<String> = _startDestination

    init {
        if (repository.isUserAuthenticated) {
            _startDestination.value = Graph.HOME
        }
    }
}
