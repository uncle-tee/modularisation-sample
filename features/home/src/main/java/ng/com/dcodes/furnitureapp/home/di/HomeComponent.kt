package ng.com.dcodes.furnitureapp.home.di


import dagger.Component
import dagger.Subcomponent
import ng.com.dcodes.core.di.CoreComponent
import ng.com.dcodes.home.ui.HomeFragment
import ng.com.dcodes.mobile.common.utils.di.scopes.Activity
import javax.inject.Singleton


@Activity
@Component(dependencies = [CoreComponent::class], modules = [
    HomeModule::class
])
interface HomeComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): HomeComponent
    }


    fun inject(fragment: HomeFragment)

}