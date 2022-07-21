package com.example.paymentproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.paymentproject.ui.composables.LoginPage
import com.example.paymentproject.ui.composables.SignupPage
import com.example.paymentproject.ui.theme.PaymentProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            PaymentProjectTheme {
                Tiply()
            }
        }
    }

    @Composable
    fun Tiply(){
        val navController = rememberNavController()
        
        NavHost(navController = navController, startDestination = "login", builder= {
            composable("login", content = { LoginPage(navController = navController) })
            composable("signup", content = { SignupPage(navController = navController) })
        })
    }
}
