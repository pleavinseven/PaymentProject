package com.example.paymentproject.ui.model

import android.text.TextUtils
import android.util.Patterns

class EmailState: TextFieldState(
    validator = ::checkEmailValid,
    errorMessage = ::emailErrorMessage
) {
}

fun checkEmailValid(email: String):Boolean {
    return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun emailErrorMessage(email: String):String{
    return "Email $email is invalid"
}