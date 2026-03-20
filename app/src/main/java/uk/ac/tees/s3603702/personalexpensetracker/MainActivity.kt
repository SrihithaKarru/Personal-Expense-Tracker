package uk.ac.tees.s3603702.personalexpensetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import androidx.navigation.compose.NavHost
import uk.ac.tees.s3603702.personalexpensetracker.navigation.Screen
import uk.ac.tees.s3603702.personalexpensetracker.ui.screens.*

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
                    DashboardScreen(navController)
                    }
                }
            }
        }
    }
