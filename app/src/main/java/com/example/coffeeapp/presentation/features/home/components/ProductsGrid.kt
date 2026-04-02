package com.example.coffeeapp.presentation.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeeapp.data.ProductMockData
import com.example.coffeeapp.domain.model.Product
import com.example.coffeeapp.presentation.common.theme.CoffeeAppTheme

@Composable
fun ProductsGrid(
    products: List<Product>,
    navController: NavController,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    topContent: @Composable () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .statusBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = contentPadding
    ) {
        item {
            topContent()
        }

        items(products.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ProductCard(
                    product = rowItems[0],
                    navController = navController,
                    modifier = Modifier.weight(1f),
                )

                if (rowItems.size == 2) {
                    ProductCard(
                        product = rowItems[1],
                        navController = navController,
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    Spacer(
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsGridPreview() {
    val navController = rememberNavController()
    CoffeeAppTheme {
        ProductsGrid(products = ProductMockData.products, navController = navController, contentPadding = PaddingValues(0.dp),{ },)
    }
}