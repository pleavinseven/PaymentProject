package com.example.paymentproject.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paymentproject.R
import com.example.paymentproject.ui.model.EmailState
import com.example.paymentproject.ui.model.PasswordState



@Composable
fun LoginPage(navController: NavController) {
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
            // title
            Text(
                text = stringResource(id = R.string.login_title),
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold
            )
            Image(
                painterResource(R.drawable.login_image),
                "cartoon people transferring money via app",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            // login email
            val localFocusManager = LocalFocusManager.current
            val emailState = remember { EmailState() }
            MainTextField(
                label = stringResource(R.string.username_label),
                value = emailState.text,
                error = emailState.error,
                onValueChanged = { emailState.text = it
                    emailState.validate() },
                onImeAction = {
                    localFocusManager.clearFocus()
                    //                if(emailState.isValid() && passwordState.isValid())
                    //                    login(emailState.text, passwordState.text)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
                leadingIcon = {
                    Icon(Icons.Filled.Mail, contentDescription = "email")
                }
            )
            // login password
            val passwordState = remember { PasswordState() }
            val showPassword = remember { mutableStateOf(false) }
            MainTextField(
                label = stringResource(R.string.password_label),
                value = passwordState.text,
                error = passwordState.error,
                onValueChanged = { passwordState.text = it
                    passwordState.validate() },
                onImeAction = {
                    localFocusManager.clearFocus()
                    //                if(emailState.isValid() && passwordState.isValid())
                    //                    login(emailState.text, passwordState.text)
                },
                visualTransformation = if (showPassword.value) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
                leadingIcon = {
                    if (passwordState.isValid()) {
                        Icon(Icons.Filled.LockOpen, contentDescription = "open lock")
                    } else {
                        Icon(Icons.Filled.Lock, contentDescription = "closed lock")
                    }
                },
                trailingIcon = {
                    if (showPassword.value) {
                        IconButton(onClick = { showPassword.value = false }) {
                            Icon(Icons.Filled.Visibility, contentDescription = "")
                        }
                    } else {
                        IconButton(onClick = { showPassword.value = true }) {
                            Icon(Icons.Filled.VisibilityOff, contentDescription = "")
                        }
                    }
                }
            )
            LoginButton(enabled = emailState.isValid() && passwordState.isValid())
            NavigateToSignUp(navController)
        }
    }
}