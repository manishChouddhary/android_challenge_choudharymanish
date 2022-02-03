package com.manish.carshopee

import android.app.Application
import com.manish.carshopee.dependencyinjection.CarShoppeModule
import com.manish.carshopee.dependencyinjection.DaggerCarShoppeComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class CarShoppeApplication: Application(),HasAndroidInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> =
        activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        val diComponent = DaggerCarShoppeComponent.builder()
            .appModule(CarShoppeModule(this))
            .application(applicationContext)
            .build()
        diComponent.inject(this)
    }
}