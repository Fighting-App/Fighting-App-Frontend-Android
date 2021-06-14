package cn.phakel.fighting.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.phakel.fighting.R
import cn.phakel.fighting.ui.models.BannerRequest
import cn.phakel.fighting.ui.models.TrendsRequest
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun Trend(trends: TrendsRequest) {
    Text(
        "开发动态",
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    )
    Spacer(modifier = Modifier.height(10.dp))

    if(trends.code == 200) {
        Column() {
            trends.data.forEach { trend ->
                Card() {
                    Column(modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            if(trend.img != null) {
                                Image(painter = /*rememberCoilPainter(request = trend.avartar)*/ painterResource(
                                    id = R.drawable.a
                                ), contentDescription = null, modifier = Modifier
                                    .width(50.dp)
                                    .height(20.dp)
                                    .clip(shape = CircleShape))
                            }

                            Spacer(modifier = Modifier.width(20.dp))

                            Column() {
                                Text(text = trend.user, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                Text(text = trend.time)
                            }
                        }

                        Text(text = trend.content)

                        Image(painter = /*rememberCoilPainter(request = trend.img)*/ painterResource(id = R.drawable.a), contentDescription = null)
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun DailySelection(banner: BannerRequest) {
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
}