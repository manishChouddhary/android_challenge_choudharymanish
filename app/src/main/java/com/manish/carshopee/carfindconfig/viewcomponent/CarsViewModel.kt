package com.manish.carshopee.carfindconfig.viewcomponent

import androidx.lifecycle.MutableLiveData
import com.manish.carshopee.carfindconfig.domain.model.PagedData
import com.manish.carshopee.carfindconfig.domain.usecase.LoadCarManufacturerType
import com.manish.carshopee.carfindconfig.domain.usecase.LoadMainCarType
import com.manish.carshopee.component.BaseViewModel
import com.manish.carshopee.component.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CarsViewModel @Inject constructor(
    private val manufacturer: LoadCarManufacturerType,
    private val mainCarType: LoadMainCarType
) : BaseViewModel() {
    val manufacturerLiveData by lazy { MutableLiveData<Resource<PagedData>>() }
    fun getCarsManufaturer() {
        compositeDisposable.add(
            manufacturer.getManufacturer()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    manufacturerLiveData.postValue(it)
                }, {
                    manufacturerLiveData.postValue(Resource.Error(it.message))
                })
        )
    }

}