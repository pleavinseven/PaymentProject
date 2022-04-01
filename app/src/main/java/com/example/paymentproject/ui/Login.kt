package com.example.paymentproject.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.paymentproject.R

@Preview(showSystemUi = true)
@Composable
fun LoginPage(){
    Column( modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Title()
        Username()
        Password()
        SignInButton()
    }
}

@Composable
fun Title() {
    Text(
        text = stringResource(R.string.login_title),
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun Username() {
    val emailState = remember{ mutableStateOf(TextFieldValue())}
    TextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = stringResource(R.string.username_label))},
        value = emailState.value,
        onValueChange = { emailState.value = it },
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Blue
        )
    )
}

@Composable
fun Password() {
    val passwordState = remember{ mutableStateOf(TextFieldValue())}
    val showPassword = remember { mutableStateOf(false)}
    TextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = stringResource(R.string.password_label))},
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = if(showPassword.value) {
            VisualTransformation.None
        } else{
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (showPassword.value){
                IconButton(onClick = { showPassword.value = false }) {
                    Icon(Icons.Filled.Visibility, contentDescription = "" )
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
fun SignInButton() {
    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(id = R.string.login_button))
    }
}