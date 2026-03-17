package uk.ac.tees.s3603702.personalexpensetracker.ui.screens

import android.window.SplashScreen
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigateToLogin: () -> Unit){
    LaunchedEffect(Unit ) {
        delay(2000)
        onNavigateToLogin()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Personal Expense Tracker",
            fontSize = 30.sp
        )
    }
}
