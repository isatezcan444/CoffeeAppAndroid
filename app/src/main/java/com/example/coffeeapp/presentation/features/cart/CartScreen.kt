package com.example.coffeeapp.presentation.features.cart

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.coffeeapp.R
import com.example.coffeeapp.data.ProductMockData
import com.example.coffeeapp.presentation.common.components.CoffeeBottomNavBar
import com.example.coffeeapp.presentation.common.components.CoffeeTopAppBar
import com.example.coffeeapp.presentation.common.theme.CoffeeAppTheme
import com.example.coffeeapp.presentation.features.cart.components.CartItemCard
import com.example.coffeeapp.presentation.features.cart.components.CartPaymentModeCard
import com.example.coffeeapp.presentation.features.cart.components.CartPaymentRow

@Composable
fun CartScreen(
    navController: NavHostController
) {
    val amount by remember { mutableStateOf(12.50) }
    val deliveryFee by remember { mutableStateOf(1.0) }
    val totalAmount = amount + deliveryFee

    Scaffold(
        topBar = {
            CoffeeTopAppBar(titleRes = R.string.top_bar_cart)
        },
        bottomBar = {
            CoffeeBottomNavBar(navController = navController)
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Text(
                    text = stringResource(R.string.cart_deliver_label),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            items(ProductMockData.cartProducts) { product ->
                CartItemCard(product = product)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.cart_payment_summary),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                CartPaymentRow(
                    label = stringResource(R.string.cart_price),
                    value = amount
                )
                CartPaymentRow(
                    label = stringResource(R.string.cart_delivery_fee),
                    value = deliveryFee
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                CartPaymentModeCard(totalAmount = totalAmount)
            }
        }
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    val navController = rememberNavController()
    CoffeeAppTheme {
        CartScreen(navController = navController)
    }
}