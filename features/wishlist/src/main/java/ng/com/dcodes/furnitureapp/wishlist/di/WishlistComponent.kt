package ng.com.dcodes.furnitureapp.wishlist.di

import dagger.Component
import ng.com.dcodes.core.di.CoreComponent
import ng.com.dcodes.furnitureapp.wishlist.presenter.WishlistFragment
import ng.com.dcodes.mobile.common.utils.di.scopes.Activity


@Component(dependencies = [
    CoreComponent::class
], modules = [
    WishlistModule::class
])
@Activity
interface WishlistComponent {

    @Component.Factory
    interface  Factory{
        fun create(component: CoreComponent):WishlistComponent
    }

    fun inject(wishlistFragment: WishlistFragment)
}