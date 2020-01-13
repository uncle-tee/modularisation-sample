package ng.com.dcodes.core.di

import android.app.Application
import dagger.Binds
import dagger.Module
import ng.com.dcodes.furnitureapp.core.FurnitureApp
import javax.inject.Singleton

@Module
abstract class CoreModule {

    @Binds
    @Singleton
    abstract fun bindApplication(application: FurnitureApp): Application

}