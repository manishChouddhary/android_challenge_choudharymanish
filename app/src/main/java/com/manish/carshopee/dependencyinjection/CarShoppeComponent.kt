package com.manish.carshopee.dependencyinjection

import android.content.Context
import com.manish.carshopee.CarShoppeApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(modules = [AndroidInjectionModule::class, CarShoppeModule::class])
@Singleton
interface CarShoppeComponent {
    fun inject(application: CarShoppeApplication)

    @Component.Builder
    abstract class Builder {
        abstract fun build(): CarShoppeComponent
        abstract fun appModule(module: CarShoppeModule): Builder

        @BindsInstance
        abstract fun application(context: Context): Builder
    }
}