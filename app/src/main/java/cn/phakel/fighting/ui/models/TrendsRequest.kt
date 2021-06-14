package cn.phakel.fighting.ui.models

data class TrendsRequest(
    val code: Int,
    val data: List<TrendsContent>
)

data class TrendsContent(
    val title: String,
    val user: String,
    val time: String,
    val content: String,
    val img: String,
    val avartar: String
)
