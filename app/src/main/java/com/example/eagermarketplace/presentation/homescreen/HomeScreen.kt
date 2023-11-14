package com.example.eagermarketplace.presentation.homescreen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eagermarketplace.R
import com.example.eagermarketplace.presentation.homescreen.components.CategoriesCard
import com.example.eagermarketplace.presentation.homescreen.components.DailyNeeds
import com.example.eagermarketplace.presentation.homescreen.components.Product


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(

) {
    var searchQuery by remember { mutableStateOf("") }
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
        modifier  = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.soko_5),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(6.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextField(
                value = searchQuery,
                onValueChange = {searchQuery = it},
                trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null)},
                label = { Text(text = "Search products") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
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
                categoryName = "Delivery"
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .height(30.dp)
                    .width(170.dp),
                shape = RoundedCornerShape(3.dp)
            ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "NEW PRODUCTS",
                        fontSize = 20.sp
                    )
                }
            }
            Text(
                text = "SEE ALL",
                fontSize = 20.sp,
                color = Color.Red
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Product(
                productImage = R.drawable.soko_5,
                price = 30,
                productName = "Nyanya",
                onAddToCartClicked = { /*TODO*/ },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.width(2.dp))
            Product(
                productImage = R.drawable.soko_5,
                price = 30,
                productName = "Nyanya",
                onAddToCartClicked = { /*TODO*/ },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black,
                    contentColor = Color.Blue
                ),
                modifier = Modifier
                    .height(30.dp)
                    .width(170.dp),
                shape = RoundedCornerShape(3.dp)
            ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "DAILY NEEDS",
                        fontSize = 20.sp
                    )
                }
            }
            Text(
                text = "SEE ALL",
                fontSize = 20.sp,
                color = Color.Red
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            DailyNeeds(
                imageId = R.drawable.soko_5,
                itemPrice = 50,
                itemName = "Kabej",
                itemQuantity = "1Kg"
            )
            Spacer(modifier = Modifier.height(5.dp))
            DailyNeeds(
                imageId = R.drawable.soko_5,
                itemPrice = 50,
                itemName = "Kabej",
                itemQuantity = "1Kg"
            )
            Spacer(modifier = Modifier.height(5.dp))
            DailyNeeds(
                imageId = R.drawable.soko_5,
                itemPrice = 50,
                itemName = "Kabej",
                itemQuantity = "1Kg"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

