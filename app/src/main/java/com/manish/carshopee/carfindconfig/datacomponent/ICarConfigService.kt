package com.manish.carshopee.carfindconfig.datacomponent

import com.manish.carshopee.carfindconfig.datacomponent.neworkmodel.CommonResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ICarConfigService {
    @GET("/car-types/manufacturer")
    fun getCarsManufacturer(@QueryMap map: Map<String, Int>): Single<CommonResponse>

    @GET("/car-types/main-types")
    fun getMainCarType(@QueryMap map: Map<String, Int>): Single<CommonResponse>
}