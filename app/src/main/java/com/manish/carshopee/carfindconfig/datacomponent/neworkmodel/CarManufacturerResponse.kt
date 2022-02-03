package com.manish.carshopee.carfindconfig.datacomponent.neworkmodel

data class CarManufacturerResponse(
    val page: Int,
    val pageSize: Int,
    val totalPageCount: Int,
    val wkda: Map<String,String>
)