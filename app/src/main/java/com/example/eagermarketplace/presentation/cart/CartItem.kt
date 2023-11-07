package com.example.eagermarketplace.presentation.cart

import androidx.annotation.DrawableRes

data class CartItem(
    @DrawableRes val productImage: Int,
    val productName: String,
    val productPrice: Int,
)
