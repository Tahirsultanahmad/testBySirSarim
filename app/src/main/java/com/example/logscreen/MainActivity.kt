package com.example.logscreen

import TableForm
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TableForm(
                viewModel,
                onSignInClick = { Log.d("btn1", "SignIn Button is Clicked!") },

                onSignUpClick = { Log.d("btn2", "SignUp Button is Clicked!") }
            )

        }
        val newData = listOf(
            TableItem("John", "123456"),
            TableItem("Jane", "789012"),
            TableItem("Alice", "345678"),
            TableItem("Ali", "1234"),
            TableItem("Asif", "1222")
        )
        viewModel.updateTableData(newData)
    }
}
