package com.example.paymentproject.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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
import com.example.paymentproject.ui.model.RepeatPasswordState

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
                .background(Color.White)
                .verticalScroll(rememberScrollState()),
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
            Spacer(modifier = Modifier.height(15.dp))
            GoogleLogin(text = "Sign up with Google")
            Text(
                text = stringResource(R.string.signup_title_sub),
                fontSize = 18.sp,
            )

            // email

            val localFocusManager = LocalFocusManager.current
            val emailState = remember { EmailState() }
            MainTextField(
                label = stringResource(R.string.username_label),
                value = emailState.text,
                error = emailState.error,
                onValueChanged = {
                    emailState.text = it
                    emailState.validate()
                },
                onImeAction = {
                    localFocusManager.clearFocus()
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
                leadingIcon = {
                    Icon(Icons.Filled.Mail, contentDescription = "email")
                }
            )

            // create password
            val passwordState = remember { PasswordState() }
            val showPassword = remember { mutableStateOf(false) }
            MainTextField(
                label = stringResource(R.string.password_label),
                value = passwordState.text,
                error = passwordState.error,
                onValueChanged = {
                    passwordState.text = it
                    passwordState.validate()
                },
                onImeAction = {
                    localFocusManager.clearFocus()
                },
                visualTransformation = if (showPassword.value) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next,
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
                            Icon(Icons.Filled.Visibility, contentDescription = "hide password")
                        }
                    } else {
                        IconButton(onClick = { showPassword.value = true }) {
                            Icon(Icons.Filled.VisibilityOff, contentDescription = "show password")
                        }
                    }
                }
            )
            val repeatPasswordState = remember { RepeatPasswordState() }
            val showRepeatPassword = remember { mutableStateOf(false) }

            MainTextField(
                label = stringResource(R.string.repeat_password_label),
                value = repeatPasswordState.text,
                error = repeatPasswordState.error,
                onValueChanged = {
                    repeatPasswordState.text = it
                    repeatPasswordState.validate()
                },
                onImeAction = {
                    localFocusManager.clearFocus()
                },
                visualTransformation = if (showRepeatPassword.value) {
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
                    if (showRepeatPassword.value) {
                        IconButton(onClick = { showRepeatPassword.value = false }) {
                            Icon(Icons.Filled.Visibility, contentDescription = "hide password")
                        }
                    } else {
                        IconButton(onClick = { showRepeatPassword.value = true }) {
                            Icon(Icons.Filled.VisibilityOff, contentDescription = "show password")
                        }
                    }
                },
                isError = passwordState.text != repeatPasswordState.text
            )
            TermsAndConditions()
            LoginButton(
                enabled = emailState.isValid() && passwordState.isValid(),
                R.string.signup_button
            )
            Navigate(navController, "login", R.string.login_nav_button)
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}
