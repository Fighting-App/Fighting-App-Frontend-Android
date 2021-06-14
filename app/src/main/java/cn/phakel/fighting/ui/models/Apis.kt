package cn.phakel.fighting.ui.models

import feign.RequestLine
import feign.Param

interface Apis {
    @RequestLine("GET /banner")
    open fun banner(): BannerRequest
}