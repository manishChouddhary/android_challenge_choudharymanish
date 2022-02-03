package com.manish.carshopee.carfindconfig.datacomponent

import com.manish.carshopee.carfindconfig.datacomponent.neworkmodel.CommonResponse
import com.manish.carshopee.carfindconfig.domain.ICarsRepository
import com.manish.carshopee.component.Resource
import io.reactivex.Single
import javax.inject.Inject

class CarsRepository @Inject constructor(
    private val carsService: ICarConfigService
) : ICarsRepository {
    override fun getCarsManufacturer(): Single<Resource<CommonResponse>> {
        return carsService.getCarsManufacturer(mapOf("page" to 0, "pageSize" to 15))
            .map {
                if (it.mapValues.isEmpty())
                    return@map Resource.Error()
                return@map Resource.Success(it)
            }
            .onErrorReturn {
                return@onErrorReturn Resource.Error(it.message)
            }
    }

    override fun getMainCarType() {

    }
}