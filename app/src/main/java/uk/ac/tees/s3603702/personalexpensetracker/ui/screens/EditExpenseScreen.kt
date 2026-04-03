package uk.ac.tees.s3603702.personalexpensetracker.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx. compose.ui.unit.dp
import androidx. compose. material3.Text
import androidx. compose. foundation. layout. Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import uk.ac.tees.s3603702.personalexpensetracker.Expense
import uk.ac.tees.s3603702.personalexpensetracker.ExpenseDao

@Composable
fun EditExpenseScreen(
    navController: NavController, dao: ExpenseDao, expenseID: Int
) {
    val context = LocalContext.current

    var title by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    // Load existing data
    LaunchedEffect(Unit) {
        val expense = dao.getExpenseByID(expenseID)
        title = expense.  title
        amount = expense.amount.toString()
    }
    Column(modifier = Modifier.padding(16.dp) ) {
        Text("Edit Expense")
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = title, onValueChange = {amount = it}, label = {Text("Title")})
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = amount, onValueChange = {amount = it}, label= {Text("Amount")})
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            if (title.isNotEmpty() && amount.isNotEmpty()){
                CoroutineScope(Dispatchers.IO).launch {
                    val expenseId = 0
                    val amountValue = 0.0
                    dao.updateExpense(
                        Expense(id = expenseId, title = title, amount = amountValue)
                    )
                }
                navController.popBackStack()
            } else{
                Toast.makeText(context, "Fill all fields", Toast.LENGTH_SHORT ).show()
            }
        }) {
            Text("Update")
        }
    }
}
