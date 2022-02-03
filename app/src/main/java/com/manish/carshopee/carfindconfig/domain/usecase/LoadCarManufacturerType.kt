package com.manish.carshopee.carfindconfig.domain.usecase

import com.manish.carshopee.carfindconfig.datacomponent.neworkmodel.CommonResponse
import com.manish.carshopee.carfindconfig.domain.ICarsRepository
import com.manish.carshopee.carfindconfig.domain.model.PagedData
import com.manish.carshopee.component.Resource
import io.reactivex.Single
import javax.inject.Inject

class LoadCarManufacturerType @Inject constructor(private val repository: ICarsRepository) {
    fun getManufacturer(): Single<Resource<PagedData>> {
        return repository.getCarsManufacturer().map(::mapResponse)
    }

    private fun mapResponse(resource: Resource<CommonResponse>): Resource<PagedData> {
        return when (resource) {
            is Resource.Success -> {
                val data = resource.data.mapValues.map { entry ->
                    PagedData.MValues(
                        entry.key,
                        entry.value ?: ""
                    )
                }
                Resource.Success(
                    PagedData(
                        resource.data.page <= resource.data.totalPageCount,
                        resource.data.page,
                        data
                    )
                )
            }
            is Resource.Error -> {
                Resource.Error(resource.message)
            }
            else -> Resource.Error()
        }
    }
}