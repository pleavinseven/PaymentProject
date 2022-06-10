package com.example.paymentproject.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.paymentproject.R

@Preview(showSystemUi = true)
@Composable
fun SignupPage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SignupTitle()
    }
}

@Composable
fun SignupTitle(){
    Text(
        text = stringResource(R.string.signup_title),
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = stringResource(R.string.signup_title_sub),
        fontSize = 18.sp,
    )
}
