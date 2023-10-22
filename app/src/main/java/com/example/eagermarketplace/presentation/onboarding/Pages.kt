package com.example.eagermarketplace.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.eagermarketplace.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)


val pages = listOf(
    Page(
        title = "Shop at the comfort of your room",
        description = "Reduce the time wasted on shopping and tiring interactions",
        image = R.drawable.soko_5
    ),
    Page(
        title = "Ask for deliveries to your doorstep",
        description = "Customers don't need the hustle of moving around with items",
        image = R.drawable.delivery
    ),
    Page(
        title = "Improve sales through our marketing",
        description = "Our online market helps improve your sales due to more reach",
        image = R.drawable.improve_sales
    )
)
