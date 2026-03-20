package uk.ac.tees.s3603702.personalexpensetracker.navigation

sealed class Screen(val route: String ){
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")

    object AddExpense : Screen ("add")
    object ExpenseList : Screen ("list")
}