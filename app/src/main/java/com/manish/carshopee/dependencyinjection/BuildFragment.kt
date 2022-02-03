package com.manish.carshopee.dependencyinjection

import com.manish.carshopee.carfindconfig.domain.DICarsConfigModule
import com.manish.carshopee.carfindconfig.viewcomponent.CarManufacturerFragment
import com.manish.carshopee.main.viewcomponent.MainConfigFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface BuildFragment {
    @FragmentScope
    @ContributesAndroidInjector(modules = [DICarsConfigModule::class])
    fun buildCarsFragment(): CarManufacturerFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun buildMainConfigFragment(): MainConfigFragment
}