package uk.ac.tees.s3603702.personalexpensetracker.ui.screens

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uk.ac.tees.s3603702.personalexpensetracker.Expense
import uk.ac.tees.s3603702.personalexpensetracker.ExpenseDao

@Composable
fun AddExpenseScreen(navController: NavController, dao: ExpenseDao) {
    val context = LocalContext.current
    var title by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Expense Title") }
        )
        TextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") }
        )
        Button(onClick = {
            if(title.isNotEmpty()  && amount.isNotEmpty() ){
                CoroutineScope(Dispatchers.IO).launch {
                    dao.insertExpense(
                        Expense(title = title, amount = amount.toDouble())
                    )
                }
                navController.popBackStack()
            } else {
                Toast.makeText(context, "please enter valid amount", Toast.LENGTH_SHORT ).show()
            }
        }) {
            Text("Save Expense")
        }
    }
}
