package uk.ac.tees.s3603702.personalexpensetracker

import androidx.compose.runtime.mutableStateListOf

object ExpenseRepository {
    val expenseList = mutableStateListOf<Expense >()
}