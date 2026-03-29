package uk.ac.tees.s3603702.personalexpensetracker
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val amount: Double
)
