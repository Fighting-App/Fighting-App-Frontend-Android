package cn.phakel.fighting.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.phakel.fighting.ui.theme.FightingTheme

@Composable
fun Tab(title: String) {
    TopAppBar(content = {
        Spacer(modifier = Modifier.size(15.dp))
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
    })
}

@Preview(showBackground = true)
@Composable
fun TabPreview() {
    FightingTheme {
        Tab(title = "Test")
    }
}