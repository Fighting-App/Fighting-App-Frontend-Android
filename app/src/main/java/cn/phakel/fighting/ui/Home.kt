package cn.phakel.fighting.ui

import android.os.Handler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.phakel.fighting.R
import cn.phakel.fighting.ui.components.Navigation
import cn.phakel.fighting.ui.components.Tab
import cn.phakel.fighting.ui.components.Trend
import cn.phakel.fighting.ui.models.*
import cn.phakel.fighting.ui.theme.FightingTheme
import cn.phakel.fighting.ui.theme.Gray189
import cn.phakel.fighting.ui.viewmodels.HomeViewModel
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.gson.Gson
import feign.Feign
import feign.gson.GsonEncoder
import okhttp3.Request
import okhttp3.OkHttpClient
import feign.gson.GsonDecoder
import java.util.concurrent.Callable


@ExperimentalPagerApi
@Composable
fun Home() {
    val homeViewModel = HomeViewModel()
    val tabItems = listOf(
        TabItem(stringResource(id = R.string.app_name), Icons.Filled.Home),
        TabItem(stringResource(id = R.string.app_nav_item_time), Icons.Filled.DateRange),
        TabItem(stringResource(id = R.string.app_nav_item_circle), Icons.Filled.Notifications),
        TabItem(stringResource(id = R.string.app_nav_item_my), Icons.Filled.AccountCircle)
    )
    val data: List<TrendsContent> = listOf(
        TrendsContent("a", "EvanLuo42", "2021/6/14", "Helloworld", "", "a"),
        TrendsContent("a", "EvanLuo42", "2021/6/14", "Helloworld", "", "a")
    )
    val content = TrendsRequest(200, data)


    MaterialTheme() {
        Scaffold(
            topBar = { Tab(title = stringResource(id = R.string.app_name)) },
            content = {
                homeViewModel.fetchBanner()
                HomeContent(banner = homeViewModel.result, trends = content)
            },
            bottomBar = { Navigation(tabItems = tabItems) },
            modifier = Modifier.background(Color.Gray)
        )
    }
}

@Composable
fun HomeContent(banner: BannerRequest, trends: TrendsRequest) {
    Column(modifier = Modifier
        .padding(16.dp)
        .verticalScroll(rememberScrollState())) {
        Text(
            stringResource(id = R.string.app_daily_selection),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        if(banner.code == 200) {
            Image(
                painter = rememberCoilPainter(request = banner.url),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .height(200.dp)
                    .fillMaxWidth()
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.a),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .height(240.dp)
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "开发动态",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Trend(trends = trends)
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    FightingTheme {
        Home()
    }
}