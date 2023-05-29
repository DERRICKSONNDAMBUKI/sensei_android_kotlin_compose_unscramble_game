package com.example.ncemptycomposeactivitymaterial3.ui.uiState

import com.example.ncemptycomposeactivitymaterial3.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class GameUiState(val currentScrambledWord: String = "")