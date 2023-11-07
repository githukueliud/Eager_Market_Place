package com.example.eagermarketplace.presentation.aboutproduct

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eagermarketplace.R


@Composable
fun AboutProductScreen(
    modifier: Modifier = Modifier,
    productImage: Int,
    onBackClicked: () -> Unit,
    productName: String,
    productPrice: Int,
    productTotalPrice: Int,
    onAddDelivery: () -> Unit,
    deliveryFee: Int,
    productDescription: String
) {
    val productQuantity: MutableState<Int> = remember { mutableStateOf(1) }
    var isFavorite by remember {
        mutableStateOf(false)
    }
    val productTotalPrice = (productPrice * productQuantity.value) + deliveryFee
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier
        ) {
            Image(
                painter = painterResource(id = productImage),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                val iconColor = if (isFavorite) Color.Red else Color.LightGray
                Icon(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = null,
                    modifier = Modifier.clickable { onBackClicked() }
                        .size(40.dp)
                        .padding(5.dp)
                )
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    tint = iconColor,
                    modifier = Modifier.size(50.dp).padding(5.dp)
                )
            }
        }
        Card(
            modifier = Modifier.fillMaxWidth()
                .height(300.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = productName,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    OutlinedIconButton(onClick = { productQuantity.value-- }) {
                        Text(
                            text = "-",
                            fontSize = 28.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = productQuantity.value.toString(),
                        fontSize = 25.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedIconButton(onClick = { productQuantity.value++ }) {
                        Text(
                            text = "+",
                            fontSize = 28.sp
                        )
                    }
                }
            }
            Row {
                Text(
                    text = "Item Price: Kes. ",
                    fontSize = 20.sp
                )
                Text(
                    text = productPrice.toString(),
                    fontSize = 20.sp
                )

            }
//            Spacer(modifier = Modifier.height(5.dp))
//            OutlinedButton(onClick = { onAddDelivery() }) {
//                Text(
//                    text = "Include delivery",
//                    fontSize = 20.sp
//                )
//            }
            Spacer(modifier = Modifier.height(5.dp))
            Row{
                Text(
                    text = "Delivery fee: Kes. ",
                    fontSize = 20.sp
                )
                Text(
                    text = deliveryFee.toString(),
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row{
                Text(
                    text = "Total Price: Kes. ",
                    fontSize = 20.sp
                )
                Text(
                    text = productTotalPrice.toString(),
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = productDescription,
                fontSize = 20.sp
            )
        }
    }
}


@Preview
@Composable
fun AboutProductScreenPreview() {
    AboutProductScreen(
        productImage = R.drawable.soko_5,
        onBackClicked = { /*TODO*/ },
        productName = "Kabej",
        productPrice = 30,
        productTotalPrice = 30,
        onAddDelivery = { /*TODO*/ },
        deliveryFee = 50,
        productDescription = "Mzee tuma za kabej Mzee tuma za kabej Mzee tuma za kabej Mzee tuma za kabej"
    )
}
