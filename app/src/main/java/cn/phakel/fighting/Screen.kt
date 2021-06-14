package cn.phakel.fighting

import androidx.annotation.StringRes

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home : Screen("home", R.string.app_name)
    object Time : Screen("time", R.string.app_nav_item_time)
    object Circle : Screen("circle", R.string.app_nav_item_circle)
    object My : Screen("my", R.string.app_nav_item_my)
}