package com.example.eagermarketplace.presentation.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eagermarketplace.R


@Composable
fun Product(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    productImage: Int,
    price: Int,
    productName: String,
    onAddToCartClicked: () -> Unit,
    productQuantity: Int?
) {
    Card(
        modifier = Modifier
            .height(160.dp)
            .width(100.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ){
                Image(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 2.dp, top = 2.dp),

                )
            }
            Image(
                painter = painterResource(id = productImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(50.dp)
                    .width(80.dp)
            )
            Text(
                text = "Ksh. $price",
                fontSize = 12.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 3.dp)
            )
            Text(
                text = "$productName",
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 3.dp),
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "$productQuantity",
                fontWeight = FontWeight.ExtraLight,
                fontSize = 10.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 3.dp),
            )
            Button(
                onClick = onAddToCartClicked,
                modifier = Modifier
                    .height(30.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Add to Cart",
                    fontSize = 10.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductPreview() {
    Product(
        isFavorite = true,
        productImage = R.drawable.soko_5,
        price = 30,
        productName = "Nyanya",
        onAddToCartClicked = { /*TODO*/ },
        productQuantity = 4
    )
}