package hu.ait.todocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import hu.ait.todocompose.navigation.MainNavigation
import hu.ait.todocompose.ui.screen.SummaryScreen
import hu.ait.todocompose.ui.screen.TodoListScreen
import hu.ait.todocompose.ui.theme.TodoComposeTheme
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TodoAppNavHost(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TodoAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainNavigation.SplashScreen.route // Updated to SplashScreen
) {
    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        // Splash Screen
        composable(MainNavigation.SplashScreen.route) {
            SplashScreen {
                navController.navigate(MainNavigation.TodoListScreen.route) {
                    // Remove SplashScreen from the back stack
                    popUpTo(MainNavigation.SplashScreen.route) { inclusive = true }
                }
            }
        }

        // Todo List Screen
        composable(MainNavigation.TodoListScreen.route) {
            TodoListScreen(
                onNavigateToSummary = { all, important ->
                    navController.navigate(
                        MainNavigation.SummaryScreen.createRoute(all, important)
                    )
                }
            )
        }

        // Summary Screen
        composable(MainNavigation.SummaryScreen.route) {
            SummaryScreen()
        }
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    // Use LaunchedEffect to perform a side-effect on composition
    LaunchedEffect(Unit) {
        delay(3000L) // 3-second delay
        onTimeout()
    }

    // Your custom logo or image
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // Replace with your image resource
            contentDescription = "App Logo"
        )
    }
}
