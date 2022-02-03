package com.manish.carshopee.dependencyinjection

import androidx.lifecycle.ViewModel
import com.manish.carshopee.main.viewcomponent.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ActivityViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}