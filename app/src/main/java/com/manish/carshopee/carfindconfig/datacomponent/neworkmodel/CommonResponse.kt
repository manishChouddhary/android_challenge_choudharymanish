package com.manish.carshopee.carfindconfig.datacomponent.neworkmodel

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class CommonResponse(
    @Json(name = "page")
    val page: Int,
    @Json(name = "pageSize")
    val pageSize: Int,
    @Json(name = "totalPageCount")
    val totalPageCount: Int,
    @Json(name = "wkda")
    val mapValues: Map<String, String?>
)