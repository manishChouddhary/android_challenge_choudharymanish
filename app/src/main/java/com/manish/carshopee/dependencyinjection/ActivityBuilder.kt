package com.manish.carshopee.dependencyinjection

import com.manish.carshopee.main.viewcomponent.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}