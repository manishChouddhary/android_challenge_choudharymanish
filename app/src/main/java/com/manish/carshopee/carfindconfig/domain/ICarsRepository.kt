package com.manish.carshopee.carfindconfig.domain

import com.manish.carshopee.carfindconfig.datacomponent.neworkmodel.CommonResponse
import com.manish.carshopee.component.Resource
import io.reactivex.Single

interface ICarsRepository {
    fun getCarsManufacturer(): Single<Resource<CommonResponse>>
    fun getMainCarType()
}