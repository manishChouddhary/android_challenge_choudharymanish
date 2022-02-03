package com.manish.carshopee.carfindconfig.domain.model

data class PagedData(
    val nextPageAvailable:Boolean,
    val currentPage: Int,
    val data: List<MValues>
) {
    data class MValues(
        val key: String,
        val value: String
    )
}
