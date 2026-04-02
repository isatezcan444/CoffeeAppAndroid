package com.example.coffeeapp.presentation.features.favourites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.coffeeapp.R
import com.example.coffeeapp.data.ProductMockData
import com.example.coffeeapp.presentation.common.components.CoffeeBottomNavBar
import com.example.coffeeapp.presentation.common.components.CoffeeTopAppBar
import com.example.coffeeapp.presentation.common.theme.CoffeeAppTheme
import com.example.coffeeapp.presentation.features.favourites.components.FavouriteItemCard

@Composable
fun FavouritesScreen(
    navController: NavHostController
) {
    var favouriteItems by remember { mutableStateOf(ProductMockData.favouriteProducts) }

    Scaffold(
        topBar = {
            CoffeeTopAppBar(titleRes = R.string.top_bar_favourites)
        },
        bottomBar = {
            CoffeeBottomNavBar(navController = navController)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            items(
                items = favouriteItems,
                key = { product -> product.id }
            ) { product ->
                FavouriteItemCard(
                    product = product,
                    onRemove = {
                        favouriteItems = favouriteItems - product
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun FavouritesScreenPreview() {
    val navController = rememberNavController()
    CoffeeAppTheme {
        FavouritesScreen(navController = navController)
    }
}