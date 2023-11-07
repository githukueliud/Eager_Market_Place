package com.example.eagermarketplace.presentation.cart


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eagermarketplace.R
import com.example.eagermarketplace.presentation.cart.components.CartItemComponent


@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
) {


    val cartItems = listOf(
        CartItem(
            productImage = R.drawable.soko_5,
            productName = "Cabbage",
            productPrice = 30
        ),
        CartItem(
            productImage = R.drawable.soko_1,
            productName = "Cabbage",
            productPrice = 30
        ),
        CartItem(
            productImage = R.drawable.soko_6,
            productName = "Cabbage",
            productPrice = 30
        )
    )


    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(cartItems) {cartItem ->
            CartItemComponent(
                productImage = cartItem.productImage,
                productName = cartItem.productName,
                productPrice =cartItem.productPrice
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    val cartItems = listOf(
        CartItemComponent(
            productImage = R.drawable.soko_5,
            productName = "Cabbage",
            productPrice = 30
        ),
        CartItemComponent(
            productImage = R.drawable.soko_1,
            productName = "Cabbage",
            productPrice = 30
        ),
        CartItemComponent(
            productImage = R.drawable.soko_6,
            productName = "Cabbage",
            productPrice = 30
        )
    )
    CartScreen()
}