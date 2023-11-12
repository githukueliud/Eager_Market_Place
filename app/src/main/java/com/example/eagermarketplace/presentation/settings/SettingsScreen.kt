package com.example.eagermarketplace.presentation.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccessibilityNew
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eagermarketplace.R


@Composable
fun SettingsScreen() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.delivery),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Eliud Githuku",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Edit personal details")
                }
            }
            Icon(
                imageVector = Icons.Default.NavigateNext,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(40.dp)
            )
        }
        Text(
            text = "Orders",
            fontSize = 25.sp,
            modifier = Modifier.padding(start = 10.dp),
            fontWeight = FontWeight.SemiBold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.Blue),
                    colorFilter = ColorFilter.tint(Color.LightGray)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "All Orders",
                    fontSize = 20.sp
                )
            }
            Icon(
                imageVector = Icons.Default.NavigateNext,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.DarkGray),
                    colorFilter = ColorFilter.tint(Color.LightGray)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Track Order",
                    fontSize = 20.sp
                )
            }
            Icon(
                imageVector = Icons.Default.NavigateNext,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    imageVector = Icons.Default.Payments,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.DarkGray),
                    colorFilter = ColorFilter.tint(Color.LightGray)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Billing And Addresses",
                    fontSize = 20.sp
                )
            }
            Icon(
                imageVector = Icons.Default.NavigateNext,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Notifications",
            fontSize = 25.sp,
            modifier = Modifier.padding(start = 10.dp),
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.Green),
                    colorFilter = ColorFilter.tint(Color.LightGray)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Notifications",
                    fontSize = 24.sp
                )
            }
            Icon(
                imageVector = Icons.Default.NavigateNext,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Regional",
            fontSize = 25.sp,
            modifier = Modifier.padding(start = 10.dp),
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    imageVector = Icons.Outlined.AccessibilityNew,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.Blue),
                    colorFilter = ColorFilter.tint(Color.LightGray)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Language",
                    fontSize = 24.sp
                )
            }
            Icon(
                imageVector = Icons.Default.NavigateNext,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    imageVector = Icons.Outlined.Logout,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.Red),
                    colorFilter = ColorFilter.tint(Color.LightGray)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Logout",
                    fontSize = 24.sp
                )
            }
            Icon(
                imageVector = Icons.Default.NavigateNext,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}