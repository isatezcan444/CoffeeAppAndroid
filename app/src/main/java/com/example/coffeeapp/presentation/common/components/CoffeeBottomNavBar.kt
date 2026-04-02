package com.example.coffeeapp.presentation.common.components

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.coffeeapp.R
import com.example.coffeeapp.presentation.common.theme.CoffeeAppTheme
import com.example.coffeeapp.presentation.navigation.Routes

@SuppressLint("RestrictedApi")
@Composable
fun CoffeeBottomNavBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val navItems = remember {
        listOf(
            NavItem(R.string.nav_home, R.drawable.regular_outline_home, Routes.HomeScreen),
            NavItem(R.string.nav_cart, R.drawable.regular_outline_bag, Routes.CartScreen),
            NavItem(R.string.nav_fav, R.drawable.regular_outline_heart, Routes.FavouritesScreen),
            NavItem(R.string.nav_profile, R.drawable.outline_account_circle_24, Routes.ProfileScreen),
        )
    }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(100.dp)
    ) {
        navItems.forEach { item ->
            val isSelected = currentDestination?.hierarchy?.any { it.hasRoute(item.routes::class) } == true
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(item.routes) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = stringResource(item.title)
                    )
                },
                label = {
                    Text(text = stringResource(item.title))
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                )
            )
        }
    }
}

@Preview
@Composable
private fun CoffeeBottomNavBarPreview() {
    val navController = rememberNavController()
    CoffeeAppTheme {
        CoffeeBottomNavBar(navController = navController)
    }
}

data class NavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val routes: Routes
)