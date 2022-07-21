package com.example.paymentproject.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.paymentproject.R


@Composable
fun Username(
    email: String,
    error: String?,
    onEmailChanged: (String) -> Unit,
    onImeAction: () -> Unit
) {
    Column {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.username_label)) },
            value = email,
            onValueChange = { onEmailChanged(it) },
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.LightGray,
                focusedIndicatorColor = Color.Blue
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    onImeAction()
                }
            ),
            isError = error != null
        )
        error?.let {
            ErrorField(it)
        }
    }
}

@Composable
fun ErrorField(error: String) {
    Text(
        text = error,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(color = MaterialTheme.colors.error)
    )

}


@Composable
fun MainTextField(
    label: String,
    value: String,
    error: String?,
    onValueChanged: (String) -> Unit,
    onImeAction: () -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    trailingIcon: @Composable (() -> Unit )? = null,
    leadingIcon: @Composable (() -> Unit )? = null

){
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = label) },
        value = value,
        onValueChange = { onValueChanged(it) },
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.LightGray,
            focusedIndicatorColor = Color.Blue
        ),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = error != null
    )
    error?.let {
        ErrorField(it)
    }
}

@Composable
fun LoginButton(enabled: Boolean) {
    Button(
        onClick = { }, modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.White
        ),
        enabled = enabled

    ) {
        Text(text = stringResource(id = R.string.login_button))
    }
}

@Composable
fun NavigateToSignUp(navController: NavController) {
    Text(
        modifier = Modifier.clickable(onClick = {
            navController.navigate("signup"){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }),
        text = stringResource(id = R.string.signup_button), color = Color.Blue
    )
}

@Composable
fun NavigateToLogin(navController: NavController) {
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

@Composable
fun TermsAndConditions() {
}

@Composable
fun GoogleLogin(){

}