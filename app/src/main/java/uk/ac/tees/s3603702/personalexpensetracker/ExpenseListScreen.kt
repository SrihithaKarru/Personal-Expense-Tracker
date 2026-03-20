package uk.ac.tees.s3603702.personalexpensetracker

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ExpenseListScreen(){
    val expenses = ExpenseRepository.expenseList
    LazyColumn {
        items(expenses ) { expense ->
            Text("${expense.title} - £${expense.amount}")
        }
    }
}