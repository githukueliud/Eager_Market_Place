package com.example.eagermarketplace.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.eagermarketplace.R


@Composable
fun GroceriesScreen(modifier: Modifier = Modifier) {
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


@Preview(showBackground = true)
@Composable
fun GroceriesScreenPreview() {
    GroceriesScreen()
}