package com.example.paymentproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.paymentproject.ui.LoginPage
import com.example.paymentproject.ui.SignupPage
import com.example.paymentproject.ui.theme.PaymentProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaymentProjectTheme {
                LoginPage()
            }
        }
    }
}
