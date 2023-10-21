package com.example.eagermarketplace.presentation.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eagermarketplace.R


@Composable
fun DailyNeeds(
    modifier: Modifier = Modifier,
    imageId: Int,
    itemPrice: Int,
    itemName: String,
    itemQuantity: String
) {
    var isFavorite by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxHeight().padding(start = 20.dp),
                verticalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    contentScale = ContentScale.Crop,
                )
            }
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Ksh. $itemPrice"
                )
                Text(
                    text = "$itemName",
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "$itemQuantity",
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 12.sp
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(3.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                val iconColor = if (isFavorite) Color.Red else Color.LightGray
                Box(
                    modifier = Modifier
                        .size(25.dp)
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
                Card(
                    modifier = Modifier
                        .size(25.dp)
                        .clip(RoundedCornerShape(50)),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        Text(text = "+")
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun DailyNeedsPreview() {
    DailyNeeds(
        imageId = R.drawable.soko_5,
        itemPrice = 50,
        itemName = "Kabej",
        itemQuantity = "1Kg"
    )
}