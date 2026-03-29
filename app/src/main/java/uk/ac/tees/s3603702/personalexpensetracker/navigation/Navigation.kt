package uk.ac.tees.s3603702.personalexpensetracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import uk.ac.tees.s3603702.personalexpensetracker.AddExpenseScreen
import uk.ac.tees.s3603702.personalexpensetracker.ExpenseListScreen
import androidx.navigation.compose.NavHost
import androidx. navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.s3603702.personalexpensetracker.ExpenseDao

@Composable 
fun Navigation(
    navController: NavController,
    dao: ExpenseDao
){
    val navController = rememberNavController()
    NavHost (
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(Screen.AddExpense.route){
            AddExpenseScreen(navController, dao)
        }
        composable(Screen.ExpenseList.route){
            ExpenseListScreen(dao)
        }
    }
}

sealed class Screen(val route: String ){
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")

    object AddExpense : Screen ("add")
    object ExpenseList : Screen("list")
}

