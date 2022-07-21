package com.example.paymentproject.ui.model

class PasswordState : TextFieldState(
    validator = ::checkPasswordValid,
    errorMessage = { passwordErrorMessage() }
)

fun checkPasswordValid(password: String): Boolean {
    password.let {
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$"
        val passwordMatcher = Regex(passwordPattern)

        return passwordMatcher.find(password) != null
    }
}

fun passwordErrorMessage() = "min. 8 char, both upper & lowercase letters and numbers."

class RepeatPasswordState : TextFieldState(
    errorMessage = { repeatPasswordErrorMessage() }
)

fun repeatPasswordErrorMessage() = "password does not match"

