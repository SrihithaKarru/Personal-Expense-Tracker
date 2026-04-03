package uk.ac.tees.s3603702.personalexpensetracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
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
import androidx.navigation. NavController
import uk.ac.tees.s3603702.personalexpensetracker.Expense
import uk.ac.tees.s3603702.personalexpensetracker.ExpenseDao

@Composable
 fun ExpenseListScreen(navController: NavController, dao: ExpenseDao) {
     var showDialog by remember {mutableStateOf(false )   }
     var expenses by remember { mutableStateOf(listOf<Expense>() )  }

    LaunchedEffect(true ) {
        expenses = dao.getALLExpenses()
    }
    LazyColumn {
        items(expenses ) { expense ->
            var showDialog by remember { mutableStateOf(false)  }
            Column(modifier = Modifier.padding(16.dp) ) {

                Text(text = expense.title )
                Text(text = "£${expense.amount}")
                Row{
                    // edit button
                    Button(onClick ={
                        navController.navigate("edit/${expense.id}")
                    }) {
                        Text("Edit")
                    }
                    Spacer(modifier = Modifier.width(10.dp) )
                    //Delete button
                    Button(onClick =  {
                        showDialog = true
                    }) {
                        Text("Delete")
                    }
                }
                // Delete Confirmation
                if(showDialog ){
                    AlertDialog(
                        onDismissRequest =  {showDialog = false},
                        confirmButton =  {
                            Button(onClick =  {
                                CoroutineScope(Dispatchers.IO).launch {
                                    dao.deleteExpense(expense )
                                }
                                showDialog = false
                            }) {
                                Text("Yes")
                            }
                        },
                        dismissButton =  @Composable {
                            Button(onClick =  { showDialog = false }) {
                                Text("No")
                            }
                        },
                        title = { Text("Delete Expense") },
                        text = {Text("Are You Sure")}

                    )
                }
            }
        }
    }
}