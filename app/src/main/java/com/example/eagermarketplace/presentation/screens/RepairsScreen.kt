package com.example.eagermarketplace.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.eagermarketplace.R


@Composable
fun RepairsScreen() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.soko_5),
            contentDescription = null
        )
        Text(text = "This is a test description. This is a test description. This is a test description.")
        Text(text = "This is a test description. This is a test description. This is a test description.")
        Text(text = "This is a test description. This is a test description. This is a test description.")
        Text(text = "This is a test description. This is a test description. This is a test description.")
        Text(text = "This is a test description. This is a test description. This is a test description.")
    }
}
