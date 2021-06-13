package cn.phakel.fighting.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import cn.phakel.fighting.R
import cn.phakel.fighting.ui.components.Navigation
import cn.phakel.fighting.ui.components.Tab
import cn.phakel.fighting.ui.models.TabItem
import cn.phakel.fighting.ui.theme.FightingTheme

@Composable
fun Home() {
    val tabItems = listOf(
        TabItem(stringResource(id = R.string.app_name), Icons.Filled.Home),
        TabItem(stringResource(id = R.string.app_nav_item_time), Icons.Filled.DateRange),
        TabItem(stringResource(id = R.string.app_nav_item_circle), Icons.Filled.Notifications),
        TabItem(stringResource(id = R.string.app_nav_item_my), Icons.Filled.AccountCircle)
    )

    Column {
        Tab(title = stringResource(id = R.string.app_name))
        Navigation(tabItems = tabItems)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    FightingTheme {
        Home()
    }
}