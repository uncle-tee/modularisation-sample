package ng.com.dcodes.core.di


import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ng.com.dcodes.furnitureapp.domain.DomainModule
import ng.com.dcodes.furnitureapp.domain.conf.FurnitureDatabase
import ng.com.dcodes.furnitureapp.domain.dao.UserDao
import ng.com.dcodes.furnitureapp.network.di.NetworkModule
import ng.com.dcodes.mobile.common.di.CommonModule
//import ng.com.dcodes.common.di.CommonModule
//import ng.com.dcodes.domain.conf.FurnitureDatabase
//import ng.com.dcodes.domain.dao.UserDao
//import ng.com.dcodes.domain.di.DomainModule
//import ng.com.dcodes.network.Catalogue.CatalogueRemote
//import ng.com.dcodes.network.di.NetworkModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    CommonModule::class,
    NetworkModule::class,
    DomainModule::class
])
interface CoreComponent{

    @Component.Factory
    interface  Factory{
        fun create(@BindsInstance context: Context): CoreComponent

    }


//    fun prividesCatalogueNetwork(): CatalogueRemote
//
//
    fun providesFurnitureDatabase(): FurnitureDatabase

    fun providesUserDao(): UserDao



}