package com.example.eagermarketplace.presentation.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eagermarketplace.R
import com.example.eagermarketplace.presentation.homescreen.components.CategoriesCard


@Composable
fun HomeScreen(

) {
//    val categoryItems = listOf(
//        CategoriesCard(
//            categoryImage = R.drawable.soko_5,
//            categoryName = "Groceries"
//        ),
//        CategoriesCard(
//            categoryImage = R.drawable.repairs,
//            categoryName = "Repairs"
//        ),
//        CategoriesCard(
//            categoryImage = R.drawable.delivery,
//            categoryName = "Gas Delivery"
//        ),
//        CategoriesCard(
//            categoryImage = R.drawable.fastfoods,
//            categoryName = "Fast food"
//        )
//    )
    Column(
        modifier  = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            CategoriesCard(
                categoryImage = R.drawable.soko_5,
                categoryName = "Groceries"
            )
            Spacer(modifier = Modifier.width(10.dp))
            CategoriesCard(
                categoryImage = R.drawable.repairs,
                categoryName = "Repairs"
            )
            Spacer(modifier = Modifier.width(10.dp))
            CategoriesCard(
                categoryImage = R.drawable.delivery,
                categoryName = "Gas Delivery"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

