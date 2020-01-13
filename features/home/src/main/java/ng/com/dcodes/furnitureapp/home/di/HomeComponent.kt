package ng.com.dcodes.home.di


import dagger.Component
import dagger.Subcomponent
import ng.com.dcodes.common.scopes.Activity
import ng.com.dcodes.core.di.CoreComponent
import ng.com.dcodes.domain.conf.FurnitureDatabase
import ng.com.dcodes.home.ui.HomeFragment
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