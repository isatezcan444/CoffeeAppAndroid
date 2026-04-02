package com.example.coffeeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.coffeeapp.presentation.features.cart.CartScreen
import com.example.coffeeapp.presentation.features.details.DetailsScreen
import com.example.coffeeapp.presentation.features.favourites.FavouritesScreen
import com.example.coffeeapp.presentation.features.home.HomeScreen
import com.example.coffeeapp.presentation.features.profile.ProfileScreen
import com.example.coffeeapp.presentation.features.welcome.WelcomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.WelcomeScreen
    ) {
        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(navController)
        }

        composable<Routes.DetailScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailScreen>()
            DetailsScreen(
                productId = args.productId,
                navController = navController
            )
        }

        composable<Routes.CartScreen> {
            CartScreen(navController)
        }

        composable<Routes.FavouritesScreen> {
            FavouritesScreen(navController)
        }

        composable<Routes.ProfileScreen> {
            ProfileScreen(navController)
        }
    }
}