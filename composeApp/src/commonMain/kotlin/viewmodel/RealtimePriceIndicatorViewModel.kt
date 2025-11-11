package viewmodel

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random

class RealtimePriceIndicatorViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(Random.nextDouble() * 100)
    val uiState: StateFlow<Double> = _uiState.asStateFlow()

    init {
        startGenerating()
    }

    private fun startGenerating() {
        viewModelScope.launch {
            while (true) {
                delay(2000)
                _uiState.update { Random.nextDouble() * 100 }
            }
        }
    }
}