package uk.ac.tees.s3603702.personalexpensetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(onLoginSuccuss: () -> Unit) {
    var email by remember {mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize().padding(25.dp),
        verticalArrangement =  Arrangement.Center
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(21.dp))
        OutlinedTextField(
            value = email,
            onValueChange =  {email = it},
            label = {Text("Email")}
        )
        Spacer(modifier = Modifier.height(11.dp))
        OutlinedTextField(
            value = password,
            onValueChange =  {password = it},
            label = {Text("Password")}
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                if (email.isNotEmpty()  && password.isNotEmpty() ){
                    onLoginSuccuss()
                }
            }
        ) {
            Text("Login")
        }
    }
}