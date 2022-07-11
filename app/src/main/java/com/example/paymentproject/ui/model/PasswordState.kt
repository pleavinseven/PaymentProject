package com.example.paymentproject.ui.model

class PasswordState: TextFieldState(
    validator = ::checkPasswordValid,
    errorMessage = {passwordErrorMessage()}
)

fun checkPasswordValid(password: String):Boolean {
    password.let {
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$"
        val passwordMatcher = Regex(passwordPattern)

        return passwordMatcher.find(password) != null
    }
}

fun passwordErrorMessage() = "password must contain upper and lowercase letters, at least one number and a minimum of 8 characters"
