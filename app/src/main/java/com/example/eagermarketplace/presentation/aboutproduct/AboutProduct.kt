package com.example.eagermarketplace.presentation.aboutproduct

import androidx.annotation.DrawableRes

data class AboutProduct (
    val productName: String = "",
    val category: String = "",
    val price: Int = 0,
    val location: String,
    val deliveryFee: Int = 0,
    val productDescription: String = "",
    val totalPrice: Int = 0,
    val productQuantity: Int = 0,
    @DrawableRes val productImage: Int
)