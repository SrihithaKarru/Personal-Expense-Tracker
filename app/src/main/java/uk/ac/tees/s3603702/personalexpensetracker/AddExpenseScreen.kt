package uk.ac.tees.s3603702.personalexpensetracker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddExpenseScreen(navController: NavController ) {
    var title by remember { mutableStateOf("")  }
    var amount by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp ) ) {
        TextField(
            value =  title,
            onValueChange =  {title = it},
            label = {Text("Expense Title")}
        )
        TextField(
            value =  amount,
            onValueChange =  {amount= it},
            label = { Text("Amount")}
        )
        Button(onClick = {
            val expense = Expense(title, (amount.toDoubleOrNull() ?: 0.0).toString())
            ExpenseRepository.expenseList.add(expense )
            navController.navigate("list")
        }) {
            Text("save Expense")
        }
    }
}