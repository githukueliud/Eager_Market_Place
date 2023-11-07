package com.example.eagermarketplace.presentation.cart.components

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eagermarketplace.R


@Composable
fun CartItem(
    @DrawableRes productImage: Int,
    productName: String,
    productPrice: Int,
    onRemoveCartItemClicked: () -> Unit
) {
    val context = LocalContext.current
    val productQuantity: MutableState<Int> = remember { mutableStateOf(1) }
    val productTotalPrice = (productPrice * productQuantity.value)
    Row(
        modifier = Modifier.fillMaxWidth().padding(3.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = productImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .clip(RoundedCornerShape(6.dp))
        )
        Column {
            Text(
                text = productName,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
            Row {
                Text(
                    text = "Kes. ",
                    fontSize = 20.sp
                )
                Text(
                    text = productPrice.toString(),
                    fontSize = 20.sp
                )

            }
            Row {
                Text(
                    text = "Total Kes. ",
                    fontSize = 20.sp
                )
                Text(
                    text = productTotalPrice.toString(),
                    fontSize = 20.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedIconButton(onClick = {
                    if (productQuantity.value > 1)
                        productQuantity.value--
                    else
                        Toast.makeText(context, "Minimum product quantity is one!", Toast.LENGTH_SHORT).show()
                },
                    shape = RoundedCornerShape(6.dp)
                ) {
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
                OutlinedIconButton(
                    onClick = { productQuantity.value++ },
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = "+",
                        fontSize = 28.sp
                    )
                }
            }

        }
        Icon(
            imageVector = Icons.Outlined.Cancel,
            contentDescription = null,
            modifier = Modifier.size(30.dp)
                .clickable { onRemoveCartItemClicked() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CartItemPreview() {
    CartItem(
        productImage = R.drawable.soko_5,
        productName = "Kabej",
        productPrice = 30,
        onRemoveCartItemClicked = {}
    )
}
