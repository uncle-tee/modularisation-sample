package ng.com.dcodes.furnitureapp.domain


import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ng.com.dcodes.furnitureapp.domain.conf.FurnitureDatabase

import javax.inject.Singleton


@Module
class DomainModule {


    @Provides
    @Singleton
    fun providesContext(application: Context): FurnitureDatabase {
       return FurnitureDatabase.getInstance(application.applicationContext)
    }


    @Provides
    @Singleton
    fun providesUserDao(furnitureDatabase: FurnitureDatabase) =  furnitureDatabase.user


}