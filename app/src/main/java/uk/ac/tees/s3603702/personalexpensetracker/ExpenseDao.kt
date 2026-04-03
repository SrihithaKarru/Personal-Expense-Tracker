package uk.ac.tees.s3603702.personalexpensetracker

import androidx.room.*

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insertExpense(expense: Expense)
    @Query("SELECT * FROM expenses")
    suspend fun getALLExpenses(): List<Expense>
    @Delete
    suspend fun deleteExpense(expense: Expense)
    @Update
    suspend fun updateExpense(expense: Expense )
    @Query("SELECT * FROM expenses  WHERE id = :id")
    suspend fun getExpenseByID(id: Int ): Expense
}