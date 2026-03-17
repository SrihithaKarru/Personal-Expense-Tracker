package uk.ac.tees.s3603702.personalexpensetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import uk.ac.tees.s3603702.personalexpensetracker.navigation.Screen
import uk.ac.tees.s3603702.personalexpensetracker.ui.screens.*
import uk.ac.tees.s3603702.personalexpensetracker.ui.theme.PersonalExpenseTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.Splash.route
            ){
                composable(Screen.Splash.route){
                    SplashScreen {
                        navController.navigate(Screen.Login.route)
                    }
                }
                composable(Screen.Login.route){
                    LoginScreen {
                        navController.navigate(Screen.Dashboard.route)
                    }
                }
                composable(Screen.Dashboard.route){
                    DashboardScreen()
                    }
                }
            }
        }
    }
