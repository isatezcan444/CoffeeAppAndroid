package com.example.coffeeapp.presentation.common.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeeapp.R
import com.example.coffeeapp.presentation.common.theme.CoffeeAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeTopAppBar(
    @StringRes titleRes: Int,
    onBackClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit = { },
    ) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(titleRes),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            if (onBackClick != null) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        painter = painterResource(R.drawable.regular_outline_arrow_left),
                        contentDescription = stringResource(R.string.cd_back)
                    )
                }
            }
        },
        actions = actions
    )
}

@Preview
@Composable
private fun CoffeeTopAppBarPreview() {
    CoffeeAppTheme {
        CoffeeTopAppBar(titleRes = R.string.top_bar_profile)
    }
}