package ng.com.dcodes.furnitureapp.wishlist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ng.com.dcodes.furnitureapp.wishlist.viewmodel.WishListViewModel
import ng.com.dcodes.mobile.common.utils.ViewModelFactory
import ng.com.dcodes.mobile.common.utils.di.ViewModelKey



@Module
abstract class WishlistModule {



    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(WishListViewModel::class)
    abstract fun bindHomeViewModel(viewModel: WishListViewModel): ViewModel
}