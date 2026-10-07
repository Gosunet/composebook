package components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material.RangeSlider as MaterialRangeSlider

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RangeSlider() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Column {
        MaterialRangeSlider(
            value = sliderPosition,
            steps = 5,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
            },
        )
        Text(text = sliderPosition.toString())
    }
}