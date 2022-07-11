package com.example.paymentproject.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paymentproject.R
import com.example.paymentproject.ui.model.EmailState
import com.example.paymentproject.ui.model.PasswordState
import com.example.paymentproject.ui.model.emailErrorMessage

@Composable
fun SignupPage(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painterResource(R.drawable.signup_image),
                "cartoon of two men filling out a form",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            SignupTitle()

            // placeholder fields
            val localFocusManager = LocalFocusManager.current
            val emailState = remember { EmailState() }
            Username(emailState.text, emailState.error,
                onEmailChanged = {
                    emailState.text = it
                    emailState.validate()
                },
                onImeAction = {
                    localFocusManager.moveFocus(FocusDirection.Down)
                }
            )

            val passwordState = remember { PasswordState() }
            Password(passwordState.text, passwordState.error,
                onPasswordChanged = {
                    passwordState.text = it
                    passwordState.validate()
                }, onImeAction = {
                    localFocusManager.clearFocus()
                }
            )


            LoginNavButton(navController)
        }
    }
}

@Composable
fun SignupTitle(){
    Text(
        text = stringResource(R.string.signup_title),
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = stringResource(R.string.signup_title_sub),
        fontSize = 18.sp,
    )
}

@Composable
fun LoginNavButton(navController: NavController) {
    Text(
        modifier = Modifier.clickable(onClick = {
            navController.navigate("login"){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }),
        text = stringResource(id = R.string.login_nav_button), color = Color.Blue
    )
}