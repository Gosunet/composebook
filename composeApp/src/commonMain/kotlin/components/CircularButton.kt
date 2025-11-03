package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
internal fun CircularButton(
    modifier: Modifier = Modifier,
    painterProvider: @Composable () -> Painter,
    onClick: () -> Unit,
) {
    Box(
        modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(Color(25, 25, 28, 180))
            .clickable { onClick() }, contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterProvider(),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
    }
}
