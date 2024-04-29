import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.kodein.emoji.compose.EmojiService

@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val scope = rememberCoroutineScope()
    val close = { scope.launch { drawerState.close() }}

    remember { EmojiService.initialize() }

    MaterialTheme {
        BoxWithConstraints {
            if (maxWidth < 840.dp) {
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = { NavigationDrawer(navController, close) },
                ) {
                    Content(navController)
                }
            } else {
                PermanentNavigationDrawer(
                    drawerContent = { NavigationDrawer(navController, close) },
                ) {
                    Content(navController)
                }
            }
        }
    }
}