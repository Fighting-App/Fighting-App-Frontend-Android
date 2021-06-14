package cn.phakel.fighting.ui

import android.util.JsonReader
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import cn.phakel.fighting.ui.models.BannerRequest
import cn.phakel.fighting.ui.models.TabItem
import cn.phakel.fighting.ui.theme.FightingTheme
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.gson.Gson
import okhttp3.Request
import okhttp3.OkHttpClient
import org.json.JSONObject


@ExperimentalPagerApi
@Composable
fun Home() {
    val tabItems = listOf(
        TabItem(stringResource(id = R.string.app_name), Icons.Filled.Home),
        TabItem(stringResource(id = R.string.app_nav_item_time), Icons.Filled.DateRange),
        TabItem(stringResource(id = R.string.app_nav_item_circle), Icons.Filled.Notifications),
        TabItem(stringResource(id = R.string.app_nav_item_my), Icons.Filled.AccountCircle)
    )

    MaterialTheme() {
        Scaffold(
            topBar = { Tab(title = stringResource(id = R.string.app_name)) },
            content = { HomeContent(getBanner()) },
            bottomBar = { Navigation(tabItems = tabItems) }
        )
    }
}

@Composable
fun HomeContent(banner: BannerRequest) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            stringResource(id = R.string.app_daily_selection),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        if(banner != null) {
            Image(
                painter = rememberCoilPainter(request = banner.url),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .height(240.dp)
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
    }
}

fun getBanner(): BannerRequest {
    val okHttpClient = OkHttpClient()

    val req = Request.Builder()
        .url("")
        .build()

    val data = okHttpClient
        .newCall(req)
        .execute()
        .body()
        ?.string()

    return Gson().fromJson(data, BannerRequest::class.java)
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    FightingTheme {
        Home()
    }
}