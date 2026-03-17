package uk.ac.tees.s3603702.personalexpensetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(25.dp)
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
        Button(onClick = {}) {
            Text("Add Expenses")
        }
    }
}