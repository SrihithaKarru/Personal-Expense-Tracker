package uk.ac.tees.s3603702.personalexpensetracker

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ExpenseListScreen(dao: ExpenseDao) {
    var expenses by remember { mutableStateOf(listOf<Expense>() )  }
    LaunchedEffect(true ) {
        expenses = dao.getALLExpenses()
    }
    LazyColumn {
        items(expenses ) { expense ->
            Row {
                Text("${expense.title}-£${expense.amount}")
                Spacer(modifier = Modifier.width(10.dp ) )
                Button(onClick =  {
                    CoroutineScope(Dispatchers.IO ).launch {
                        dao.deleteExpense(expense)
                    }
                }) {
                  Text("Delete")
                }
            }
        }
    }
}