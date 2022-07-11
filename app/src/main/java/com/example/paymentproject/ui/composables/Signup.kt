package com.example.paymentproject.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paymentproject.R
import com.example.paymentproject.ui.model.EmailState
import com.example.paymentproject.ui.model.PasswordState

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
            // title
            Text(
                text = stringResource(R.string.signup_title),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.signup_title_sub),
                fontSize = 18.sp,
            )

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

            NavigateToLogin(navController)
        }
    }
}
