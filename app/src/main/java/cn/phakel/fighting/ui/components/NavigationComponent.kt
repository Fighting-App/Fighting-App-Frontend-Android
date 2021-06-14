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
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cn.phakel.fighting.Circle
import cn.phakel.fighting.Screen
import cn.phakel.fighting.ui.Home
import cn.phakel.fighting.ui.My
import cn.phakel.fighting.ui.Time
import cn.phakel.fighting.ui.models.TabItem
import cn.phakel.fighting.ui.theme.FightingTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun Navigation(tabItems: List<TabItem>, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Home(navController = navController) }
        composable("time") { Time(navController = navController) }
        composable("circle") { Circle(navController = navController) }
        composable("my") { My(navController = navController) }
    }

        BottomNavigation {
        tabItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.itemIcon, contentDescription = null) },
                label = { Text(stringResource(id = item.screen.resourceId)) },
                selected = currentRoute == item.screen.route,
                    onClick = {
                        navController.navigate(route = item.screen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                        }
                    }
            )
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    val tabItems = listOf(
        TabItem(Icons.Filled.Home, Screen.Home),
        TabItem(Icons.Filled.DateRange, Screen.Time),
        TabItem(Icons.Filled.Notifications, Screen.Circle),
        TabItem(Icons.Filled.AccountCircle, Screen.My)
    )

    val navController = rememberNavController()

    FightingTheme {
        Navigation(tabItems, navController)
    }
}
