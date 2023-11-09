package com.example.eagermarketplace.presentation.user_profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AddImageComponent(
    modifier: Modifier = Modifier,
    onEditImageClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(50))
            .clickable { onEditImageClicked() },
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Icon(
                imageVector = Icons.Outlined.CameraAlt,
                contentDescription = null,
                modifier = Modifier.size(30.dp),
                tint = Color.DarkGray
            )
            Text(
                text = "Add Image"
            )
//            Icon(
//                imageVector = Icons.Default.Edit,
//                contentDescription = null,
//                modifier = Modifier.fillMaxWidth()
//                    .size(18.dp)
//                    .padding(start = 75.dp)
//            )
        }
    }
}


@Preview
@Composable
fun AddImageComponentPreview() {
    AddImageComponent(onEditImageClicked = {})
}