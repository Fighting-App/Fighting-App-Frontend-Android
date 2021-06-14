package cn.phakel.fighting.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.phakel.fighting.ui.models.Apis
import cn.phakel.fighting.ui.models.BannerRequest
import feign.Feign
import feign.gson.GsonDecoder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel: ViewModel() {
    var result: BannerRequest = BannerRequest(1, "a")

    fun fetchBanner() {
        viewModelScope.launch {
            result = banner()
        }
    }

    suspend fun banner(): BannerRequest {
        val api: Apis = Feign.builder()
            .decoder(GsonDecoder())
            .target(Apis::class.java, "https://api.xxx.com")
        return withContext(Dispatchers.IO) {
            api.banner()
        }
    }
}