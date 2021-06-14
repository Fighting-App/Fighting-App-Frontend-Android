package cn.phakel.fighting.ui.components

import android.widget.Space
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.phakel.fighting.R
import cn.phakel.fighting.ui.models.TabItem
import cn.phakel.fighting.ui.models.TrendsContent
import cn.phakel.fighting.ui.models.TrendsRequest
import cn.phakel.fighting.ui.theme.FightingTheme
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun Trend(trends: TrendsRequest) {
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
                                    .clip(shape = RoundedCornerShape(50))
                                    .border(
                                        width = 2.dp,
                                        color = Color.White,
                                        shape = RoundedCornerShape(50)
                                    ))
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

@Preview(showBackground = true)
@Composable
fun TrendsPreview() {
    val data: List<TrendsContent> = listOf(
        TrendsContent("a", "EvanLuo42", "2021/6/14", "Helloworld", "", "a"),
        TrendsContent("a", "EvanLuo42", "2021/6/14", "Helloworld", "", "a")
    )
    val content = TrendsRequest(200, data)

    FightingTheme {
        Trend(trends = content)
    }
}