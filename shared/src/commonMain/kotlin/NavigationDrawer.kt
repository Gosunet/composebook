import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.Job
import org.kodein.emoji.Emoji
import org.kodein.emoji.activities.arts_crafts.ArtistPalette
import org.kodein.emoji.compose.WithPlatformEmoji
import org.kodein.emoji.objects.tool.Hammer
import org.kodein.emoji.people_body.hand_fingers_open.WavingHand
import org.kodein.emoji.travel_places.place_building.Bricks
import org.kodein.emoji.travel_places.place_building.House

@Composable
fun NavigationDrawer(
    navController: NavController,
    close: () -> Job
) {
    ModalDrawerSheet {
        Text(
            "Compose Book",
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.primary
        )
        HorizontalDivider()
        NavigationDrawerItem(
            label = {
                WithPlatformEmoji(
                    "${Emoji.House} Home"
                ) { text, inlineContent ->
                    Text(text = text, inlineContent = inlineContent)
                }
            },
            selected = false,
            onClick = {
                navController.navigate(Screens.HOME.name)
                close()
            }
        )
        NavigationDrawerItem(
            label = {
                WithPlatformEmoji(
                    "${Emoji.ArtistPalette} Styles"
                ) { text, inlineContent ->
                    Text(text = text, inlineContent = inlineContent)
                }
            },
            selected = false,
            onClick = {
                navController.navigate(Screens.STYLES.name)
                close()
            }
        )
        NavigationDrawerItem(
            label = {
                WithPlatformEmoji(
                    "${Emoji.Bricks} Components"
                ) { text, inlineContent ->
                    Text(text = text, inlineContent = inlineContent)
                }
            },
            selected = false,
            onClick = {
                navController.navigate(Screens.COMPONENTS.name)
                close()
            }
        )
        NavigationDrawerItem(
            label = {
                WithPlatformEmoji(
                    "${Emoji.WavingHand} About"
                ) { text, inlineContent ->
                    Text(text = text, inlineContent = inlineContent)
                }
            },
            selected = false,
            onClick = {
                navController.navigate(Screens.ABOUT.name)
                close()
            }
        )
        NavigationDrawerItem(
            label = {
                WithPlatformEmoji(
                    "${Emoji.Hammer} About"
                ) { text, inlineContent ->
                    Text(text = text, inlineContent = inlineContent)
                }
            },
            selected = false,
            onClick = {
                navController.navigate(Screens.SETTINGS.name)
                close()
            }
        )
    }
}