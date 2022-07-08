package com.example.paymentproject.ui.model

class PasswordState: TextFieldState(
    validator = ::checkPasswordValid,
    errorMessage = {passwordErrorMessage()}
) {
}

fun checkPasswordValid(password: String):Boolean {
    return true // database call goes here
}

fun passwordErrorMessage() = "password incorrect"
