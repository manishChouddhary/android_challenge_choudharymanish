package com.manish.carshopee.carfindconfig.domain

import androidx.lifecycle.ViewModel
import com.manish.carshopee.carfindconfig.datacomponent.CarsRepository
import com.manish.carshopee.carfindconfig.datacomponent.ICarConfigService
import com.manish.carshopee.carfindconfig.viewcomponent.CarsViewModel
import com.manish.carshopee.dependencyinjection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module(includes = [CarRepositoryModule::class])
class DICarsConfigModule {
    @Provides
    fun provideService(retrofit: Retrofit): ICarConfigService =
        retrofit.create(ICarConfigService::class.java)
}

@Module
interface CarRepositoryModule {
    @Binds
    fun bindRepository(repository: CarsRepository): ICarsRepository

    @Binds
    @IntoMap
    @ViewModelKey(CarsViewModel::class)
    fun bindViewModel(viewModel: CarsViewModel): ViewModel
}