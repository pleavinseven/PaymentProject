package com.example.paymentproject.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.paymentproject.R

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
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = error != null

) {
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
        singleLine = true,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = isError
    )
    error?.let {
        ErrorField(it)
    }
}

@Composable
fun LoginButton(enabled: Boolean, text: Int) {
    Button(
        onClick = { }, modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.White
        ),
        enabled = enabled

    ) {
        Text(text = stringResource(id = text))
    }
}

@Composable
fun Navigate(navController: NavController, destination: String, text: Int) {
    Text(
        modifier = Modifier.clickable(onClick = {
            navController.navigate(destination) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }),
        text = stringResource(id = text), color = Color.Blue
    )
}

@Composable
fun TermsAndConditions() {
}

@Composable
fun GoogleLogin(text: String){
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black,
        ),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "google login",
            Modifier.padding(5.dp)
        )
        Text(text = text)
    }
}