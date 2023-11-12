package com.example.eagermarketplace.presentation.homescreen.components


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eagermarketplace.R


@Composable
fun CategoriesCard(
    modifier: Modifier = Modifier,
    @DrawableRes categoryImage: Int,
    categoryName: String
) {
    Card(
        modifier = Modifier
            .height(80.dp)
            .width(80.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = categoryImage),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = categoryName,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
    }
}

@Preview
@Composable
fun CategoriesCardPreview() {
    CategoriesCard(categoryImage = R.drawable.soko_5, categoryName = "Groceries")
}