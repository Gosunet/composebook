import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import screens.AboutScreen
import screens.ComponentsScreen
import screens.HomeScreen
import screens.SettingsScreen
import screens.StylesScreen

@Composable
fun Content(
    navController: NavHostController,
    isDarkMode: Boolean,
    toggleDarkMode: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screens.HOME.name,
        modifier = Modifier
    ) {
        composable(route = Screens.HOME.name) {
            HomeScreen()
        }
        composable(route = Screens.STYLES.name) {
            StylesScreen()
        }
        composable(route = Screens.COMPONENTS.name) {
            ComponentsScreen()
        }
        composable(route = Screens.ABOUT.name) {
            AboutScreen()
        }
        composable(route = Screens.SETTINGS.name) {
            SettingsScreen(isDarkMode, toggleDarkMode)
        }
    }
}

