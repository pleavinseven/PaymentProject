package com.example.paymentproject.ui

import android.text.TextUtils
import android.util.Patterns

class PasswordState: TextFieldState(
    validator = ::checkPasswordValid,
    errorMessage = {passwordErrorMessage()}
) {
}

fun checkPasswordValid(password: String):Boolean {
    return password.length >= 8
}

fun passwordErrorMessage() = "password must be 8 characters or greater"
