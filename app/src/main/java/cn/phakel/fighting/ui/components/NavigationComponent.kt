package cn.phakel.fighting.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import cn.phakel.fighting.R
import cn.phakel.fighting.ui.models.TabItem
import cn.phakel.fighting.ui.theme.FightingTheme

@Composable
fun Navigation(tabItems: List<TabItem>) {
    var selectedItem = 0

    BottomNavigation {
        tabItems.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(item.itemIcon, contentDescription = null) },
                label = { Text(item.itemName) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    val tabItems = listOf(
        TabItem(stringResource(id = R.string.app_name), Icons.Filled.Home),
        TabItem(stringResource(id = R.string.app_nav_item_time), Icons.Filled.DateRange),
        TabItem(stringResource(id = R.string.app_nav_item_circle), Icons.Filled.Notifications),
        TabItem(stringResource(id = R.string.app_nav_item_my), Icons.Filled.AccountCircle)
    )

    FightingTheme {
        Navigation(tabItems)
    }
}
