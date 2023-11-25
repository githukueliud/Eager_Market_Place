package com.example.eagermarketplace.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.eagermarketplace.R

data class Product (
    val name: String,
    @DrawableRes val image: Int,
    val price: Int,
    val description: String
)

object ProductDataSource {
    val products = listOf(
        Product(
            name = "Cabbage",
            image = R.drawable.soko_5,
            price = 30,
            description = "This is a test description. This is a test description. This is a test description. This is a test description. This is a test description. This is a test description."
        ),
        Product(
            name = "Cabbage",
            image = R.drawable.soko_5,
            price = 30,
            description = "This is a test description. This is a test description. This is a test description. This is a test description. This is a test description. This is a test description."
        ),
        Product(
            name = "Cabbage",
            image = R.drawable.soko_5,
            price = 30,
            description = "This is a test description. This is a test description. This is a test description. This is a test description. This is a test description. This is a test description."
        ),
        Product(
            name = "Cabbage",
            image = R.drawable.soko_5,
            price = 30,
            description = "This is a test description. This is a test description. This is a test description. This is a test description. This is a test description. This is a test description."
        ),
        Product(
            name = "Cabbage",
            image = R.drawable.soko_5,
            price = 30,
            description = "This is a test description. This is a test description. This is a test description. This is a test description. This is a test description. This is a test description."
        ),
        Product(
            name = "Cabbage",
            image = R.drawable.soko_5,
            price = 30,
            description = "This is a test description. This is a test description. This is a test description. This is a test description. This is a test description. This is a test description."
        ),
        Product(
            name = "Cabbage",
            image = R.drawable.soko_5,
            price = 30,
            description = "This is a test description. This is a test description. This is a test description. This is a test description. This is a test description. This is a test description."
        ),
        Product(
            name = "Cabbage",
            image = R.drawable.soko_5,
            price = 30,
            description = "This is a test description. This is a test description. This is a test description. This is a test description. This is a test description. This is a test description."
        ),
        Product(
            name = "Cabbage",
            image = R.drawable.soko_5,
            price = 30,
            description = "This is a test description. This is a test description. This is a test description. This is a test description. This is a test description. This is a test description."
        ),
        Product(
            name = "Cabbage",
            image = R.drawable.soko_5,
            price = 30,
            description = "This is a test description. This is a test description. This is a test description. This is a test description. This is a test description. This is a test description."
        )
    )
}