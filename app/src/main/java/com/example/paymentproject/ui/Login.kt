package com.example.paymentproject.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.paymentproject.HomeViewModel
import com.example.paymentproject.R

val viewModel = HomeViewModel()
val email = ""

@Preview(showSystemUi = true)
@Composable
fun LoginPage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Title()
        Username()
        Password()
        LoginButton()
        SignUpButton()
    }
}

@Composable
fun Title() {
    Text(
        text = stringResource(R.string.login_title),
        fontSize = 80.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun Username() {
    val emailState = remember { mutableStateOf(TextFieldValue()) }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = stringResource(R.string.username_label)) },
        value = emailState.value,
        onValueChange = { emailState.value = it },
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.LightGray,
            focusedIndicatorColor = Color.Blue
        )
    )
}

@Composable
fun Password() {
    val passwordState = remember { mutableStateOf(TextFieldValue()) }
    val showPassword = remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = stringResource(R.string.password_label)) },
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.LightGray,
            focusedIndicatorColor = Color.Blue
        ),
        visualTransformation = if (showPassword.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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
}

@Composable
fun LoginButton() {
    Button(
        onClick = { viewModel.checkEmailValid(email) }, modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.White
        )
    ) {
        Text(text = stringResource(id = R.string.login_button))
    }
}

@Composable
fun SignUpButton() {
    Text(modifier = Modifier
        .clickable(enabled = true) {

        }, text = stringResource(id = R.string.signup_button), color = Color.Blue
    )
}