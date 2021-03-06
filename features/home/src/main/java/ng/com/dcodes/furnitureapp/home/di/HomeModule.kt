package ng.com.dcodes.furnitureapp.home.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ng.com.dcodes.home.viewmodel.HomeViewModel
import ng.com.dcodes.mobile.common.utils.ViewModelFactory
import ng.com.dcodes.mobile.common.utils.di.ViewModelKey


@Module
abstract class HomeModule{


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel



}