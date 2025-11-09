import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import screens.About
import screens.Components
import screens.Home
import screens.Styles

@Composable
fun Content(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.HOME.name,
        modifier = Modifier
    ) {
        composable(route = Screens.HOME.name) {
            Home()
        }
        composable(route = Screens.STYLES.name) {
            Styles()
        }
        composable(route = Screens.COMPONENTS.name) {
            Components()
        }
        composable(route = Screens.ABOUT.name) {
            About()
        }
    }
}

