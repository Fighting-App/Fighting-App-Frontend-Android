package cn.phakel.fighting.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cn.phakel.fighting.Circle
import cn.phakel.fighting.R
import cn.phakel.fighting.Screen
import cn.phakel.fighting.ui.components.DailySelection
import cn.phakel.fighting.ui.components.Navigation
import cn.phakel.fighting.ui.components.Tab
import cn.phakel.fighting.ui.components.Trend
import cn.phakel.fighting.ui.models.*
import cn.phakel.fighting.ui.theme.FightingTheme
import cn.phakel.fighting.ui.viewmodels.HomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
@Composable
fun Home(navController: NavHostController) {
    val homeViewModel = HomeViewModel()
    val tabItems = listOf(
        TabItem(Icons.Filled.Home, Screen.Home),
        TabItem(Icons.Filled.DateRange, Screen.Time),
        TabItem(Icons.Filled.Notifications, Screen.Circle),
        TabItem(Icons.Filled.AccountCircle, Screen.My)
    )
    val data: List<TrendsContent> = listOf(
        TrendsContent("a", "EvanLuo42", "2021/6/14", "Helloworld", "", "a"),
        TrendsContent("a", "EvanLuo42", "2021/6/14", "Helloworld", null, "a")
    )
    val content = TrendsRequest(200, data)

    MaterialTheme() {
        Scaffold(
            topBar = { Tab(title = stringResource(id = R.string.app_name)) },
            content = {
                homeViewModel.fetchBanner()
                HomeContent(banner = homeViewModel.result, trends = content)
            },
            bottomBar = { Navigation(tabItems = tabItems, navController = navController) },
            modifier = Modifier.background(Color.Gray)
        )
    }
}

@Composable
fun HomeContent(banner: BannerRequest, trends: TrendsRequest) {
    Column(modifier = Modifier
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ) {
        DailySelection(banner = banner)

        Spacer(modifier = Modifier.height(10.dp))

        Trend(trends = trends)

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    FightingTheme {
        Home(rememberNavController())
    }
}