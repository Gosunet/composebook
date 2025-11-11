package components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import viewmodel.RealtimePriceIndicatorViewModel

@Composable
fun RealtimePriceIndicator() { // only exist for demo purposes
    val viewModel: RealtimePriceIndicatorViewModel = viewModel { RealtimePriceIndicatorViewModel() }
    val randomPrice by viewModel.uiState.collectAsState()

    Column {
        PriceIndicator(randomPrice)
    }
}