package uk.ac.tees.s3603702.personalexpensetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {
        Text(
            text = "Dashboard",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(21.dp))
        Text(
            text = "Welcome to Personal Expense Tracker"
        )
        Spacer(modifier = Modifier.height(21.dp))
        Text(
            text = "Total Expenses: £0"
        )
        Spacer(modifier = Modifier.height(21.dp))
        Button(onClick = {
            navController.navigate("add")
        }) {
            Text("Add Expenses")
        }
        Button(onClick = {
            navController.navigate("list")
        }) {
            Text("View Expenses")
        }
    }
}