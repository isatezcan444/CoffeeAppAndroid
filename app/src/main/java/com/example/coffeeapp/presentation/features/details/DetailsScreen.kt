package com.example.coffeeapp.presentation.features.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeeapp.R
import com.example.coffeeapp.data.ProductMockData
import com.example.coffeeapp.presentation.common.components.AppMessageDialog
import com.example.coffeeapp.presentation.common.components.CoffeeTopAppBar
import com.example.coffeeapp.presentation.common.theme.CoffeeAppTheme
import com.example.coffeeapp.presentation.features.details.components.DetailsContent
import com.example.coffeeapp.presentation.features.details.components.DetailsScreenBottomBar

@Composable
fun DetailsScreen(
    productId: Int,
    navController: NavController
) {
    var showCartDialog by remember { mutableStateOf(false) }

    val selectedProduct = ProductMockData.products.find { it.id == productId }
    if (selectedProduct == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Product not found!",
                color = MaterialTheme.colorScheme.error
            )
        }
        return
    }

    Scaffold(
        topBar = {
            CoffeeTopAppBar(
                titleRes = R.string.top_bar_details,
                onBackClick = { navController.navigateUp() },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(R.drawable.regular_outline_heart),
                            contentDescription = stringResource(R.string.cd_add_to_fav),
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            )
        },
        bottomBar = {
            DetailsScreenBottomBar(
                price = selectedProduct.price,
                onAddToCartClick = { showCartDialog = true }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = innerPadding
        ) {
            item {
                DetailsContent(
                    product = selectedProduct,
                    innerPadding = PaddingValues(0.dp)
                )
            }
        }

        if (showCartDialog) {
            AppMessageDialog(
                show = true,
                title = stringResource(R.string.msg_added_to_cart_title),
                message = stringResource(R.string.msg_added_to_cart_desc),
                onDismiss = { showCartDialog = false }
            )
        }
    }
}

@Preview
@Composable
private fun DetailsScreenPreview() {
    val navController = rememberNavController()
    CoffeeAppTheme {
        DetailsScreen(productId = 1, navController = navController)
    }
}