package components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import utils.formatDecimal


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