import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
    val close = { scope.launch { drawerState.close() } }

    remember { EmojiService.initialize() }

    val isSystemInDarkTheme = isSystemInDarkTheme()
    var useDarkTheme by remember { mutableStateOf(isSystemInDarkTheme) }
    val onThemeToggle: () -> Unit = { useDarkTheme = !useDarkTheme }
    val colorScheme = when {
        useDarkTheme -> darkColorScheme()
        else -> lightColorScheme()
    }

    MaterialTheme(
        colorScheme = colorScheme
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            BoxWithConstraints {
                if (maxWidth < 840.dp) {
                    ModalNavigationDrawer(
                        drawerState = drawerState,
                        drawerContent = {
                            NavigationDrawer(
                                navController = navController,
                                close = close,
                            )
                        },
                    ) {
                        Content(navController, useDarkTheme, onThemeToggle)
                    }
                } else {
                    PermanentNavigationDrawer(
                        drawerContent = {
                            NavigationDrawer(
                                navController = navController,
                                close = close,
                            )
                        },
                    ) {
                        Content(navController, useDarkTheme, onThemeToggle)
                    }
                }
            }
        }
    }
}