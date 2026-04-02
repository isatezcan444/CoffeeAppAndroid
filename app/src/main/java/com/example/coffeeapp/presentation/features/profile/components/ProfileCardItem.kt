package com.example.coffeeapp.presentation.features.profile.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeeapp.presentation.common.theme.CoffeeAppTheme
import com.example.coffeeapp.presentation.navigation.Routes

@Composable
fun ProfileCardItem(
    name: String,
    icon: ImageVector,
    navController: NavController,
    route: Routes? = null,
    isSpacer: Boolean = true,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                if (route != null) {
                    navController.navigate(route)
                }
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(28.dp)
        )

        Spacer(
            modifier = Modifier.width(18.dp)
        )

        Text(
            text = name,
            fontSize = 18.sp
        )
    }

    if (isSpacer) {
        Spacer(
            modifier = Modifier.height(12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileCardItemPreview() {
    val navController = rememberNavController()
    CoffeeAppTheme {
        ProfileCardItem(name = "Cart", icon = Icons.Default.ShoppingCart, navController = navController, route = Routes.CartScreen)
    }
}