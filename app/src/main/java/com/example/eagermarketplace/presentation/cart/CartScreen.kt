package com.example.eagermarketplace.presentation.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.eagermarketplace.R


@Composable
fun CartScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                //Image(painter = , contentDescription = )
            }
        }
    }
}