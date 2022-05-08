package com.example.paymentproject

import java.util.regex.Pattern

class HomeViewModel {


    private val emailRegex =  "^(.+)@(.+)\$"

    fun checkEmailValid(email: String):Boolean {
        return Pattern.matches(emailRegex, email)
    }

    fun emailErrorMessage(email: String):String{
        return "Email $email is invalid"
    }

}
