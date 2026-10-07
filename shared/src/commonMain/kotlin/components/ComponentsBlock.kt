package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ComponentsBlock(
    modifier: Modifier = Modifier,
    title: String,
    description: String? = null,
    components: @Composable () -> Unit
) {
    Card(
        modifier = modifier.width(500.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                style = MaterialTheme.typography.titleMedium,
                text = title,
                color = MaterialTheme.colorScheme.secondary
            )
            description?.let { Text(style = MaterialTheme.typography.bodyMedium, text = it) }
            FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                components()
            }
        }
    }
}