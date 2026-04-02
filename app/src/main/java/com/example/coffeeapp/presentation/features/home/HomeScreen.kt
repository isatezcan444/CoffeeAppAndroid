package com.example.coffeeapp.presentation.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeeapp.R
import com.example.coffeeapp.data.ProductMockData
import com.example.coffeeapp.data.UserMockData
import com.example.coffeeapp.presentation.common.components.CoffeeBottomNavBar
import com.example.coffeeapp.presentation.common.theme.CoffeeAppTheme
import com.example.coffeeapp.presentation.features.home.components.ProductsGrid
import com.example.coffeeapp.presentation.features.home.components.HomeScreenCategories
import com.example.coffeeapp.presentation.features.home.components.HomeSearchBar

@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            CoffeeBottomNavBar(navController = navController)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f / 3f)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF303030),
                            Color(0xFF1F1F1F),
                            Color(0xFF121212)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            ProductsGrid(
                products = ProductMockData.products,
                navController = navController,
                contentPadding = innerPadding
            ) {
                Text(
                    text = stringResource(R.string.location),
                    fontSize = 14.sp,
                    color = Color.Gray,
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = UserMockData.location,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = stringResource(R.string.cd_change_location),
                        tint = Color.White
                    )
                }

                Spacer(
                    modifier = Modifier.height(30.dp)
                )

                HomeSearchBar()

                Spacer(
                    modifier = Modifier.height(25.dp)
                )

                Image(
                    painter = painterResource(R.drawable.banner_1),
                    contentDescription = stringResource(R.string.cd_home_banner)
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                HomeScreenCategories()
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    val navController = rememberNavController()
    CoffeeAppTheme {
        HomeScreen(navController = navController)
    }
}