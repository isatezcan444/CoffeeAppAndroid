package com.example.coffeeapp.data

import com.example.coffeeapp.R
import com.example.coffeeapp.domain.model.Product

object ProductMockData {
    val products = listOf(
        Product(id = 1, name = "Cappuccino", description = "With chocolate", price = 4.20, imageRes = R.drawable.coffee_1),
        Product(id = 2, name = "Espresso", description = "Strong and rich", price = 3.80, imageRes = R.drawable.coffee_2),
        Product(id = 3, name = "Latte", description = "Smooth and creamy", price = 4.50, imageRes = R.drawable.coffee_3),
        Product(id = 4, name = "Mocha", description = "With cocoa flavor", price = 4.70, imageRes = R.drawable.coffee_4),
        Product(id = 5, name = "Macchiato", description = "Bold and milky", price = 4.60, imageRes = R.drawable.coffee_5),
        Product(id = 6, name = "Flat White", description = "Velvety smooth", price = 4.40, imageRes = R.drawable.coffee_6),
        Product(id = 7, name = "Iced Mocha", description = "Refreshing and rich", price = 4.70, imageRes = R.drawable.coffee_4)
    )

    val product = products.first()
    val cartProducts = products.take(3)
    val favouriteProducts = products.take(3)
}