package ng.com.dcodes.home.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ng.com.dcodes.common.viewmodelUtils.ViewModelFactory
import ng.com.dcodes.domain.conf.FurnitureDatabase
import ng.com.dcodes.home.viewmodel.HomeViewModel


@Module
abstract class HomeModule{


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel



}