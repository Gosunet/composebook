package components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import utils.formatDecimal
import kotlin.random.Random


@Composable
fun PriceIndicator(price: Double) {
    var priceState by remember { mutableStateOf(price) }

    val oldPrice = remember(price) {
        val prev = priceState
        priceState = price // Update for the *next* recomposition
        prev
    }
    val indicatorColor by animateColorAsState(
        targetValue = when {
            price > oldPrice -> Color.Green
            price < oldPrice -> Color.Red
            else -> Color.Gray
        },
        animationSpec = tween(durationMillis = 500),
        label = "priceIndicatorColor"
    )

    val formattedPrice = price.formatDecimal(2)
    Text(text = "Price: $formattedPrice €", color = indicatorColor)
}

@Composable
fun RealtimePriceIndicator() { // only exist for demo purposes
    var randomPrice by remember { mutableStateOf(Random.nextDouble() * 100) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(2000) // Wait for 2 seconds
            randomPrice = Random.nextDouble() * 100 // Update the state with a new random value
        }
    }

    Column {
        PriceIndicator(randomPrice)
    }
}