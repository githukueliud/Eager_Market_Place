package com.example.eagermarketplace.presentation.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eagermarketplace.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Product(
    modifier: Modifier = Modifier,
    productImage: Int,
    price: Int,
    productName: String,
    onAddToCartClicked: () -> Unit,
    containerColor: Color,
    contentColor: Color
) {
    Card(
        modifier = Modifier
            .height(330.dp)
            .width(190.dp)
    ){
        var isFavorite by remember {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ){
                val iconColor = if (isFavorite) Color.Red else Color.LightGray
                Box(
                    modifier = Modifier.padding(end = 5.dp)
                        .size(20.dp)
                        .clickable {
                            isFavorite != isFavorite
                        }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = iconColor
                    )
                }
            }
            Image(
                painter = painterResource(id = productImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
                    .width(180.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Text(
                text = "Kes. $price",
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 3.dp, top = 4.dp)
            )
            Text(
                text = "$productName",
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 3.dp),
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
//            Text(
//                text = "Quantity: $productQuantity",
//                fontWeight = FontWeight.ExtraLight,
//                fontSize = 16.sp,
//                textAlign = TextAlign.Start,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 3.dp),
//            )
            Button(
                onClick = onAddToCartClicked,
                modifier = Modifier
                    .height(30.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = containerColor,
                    contentColor = contentColor
                ),
            ) {
                Text(
                    text = "Add to Cart",
                    fontSize = 10.sp,

                )
            }
        }
    }
}

@Preview()
@Composable
fun ProductPreview() {
    Product(
        productImage = R.drawable.soko_5,
        price = 30,
        productName = "Nyanya",
        onAddToCartClicked = { /*TODO*/ },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )
}