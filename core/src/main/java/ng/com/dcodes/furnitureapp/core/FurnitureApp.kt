package ng.com.dcodes.furnitureapp.core

import android.app.Application
import ng.com.dcodes.core.di.DaggerCoreComponent
import timber.log.Timber


class FurnitureApp : Application() {
    val coreComponent by lazy {
        DaggerCoreComponent
            .factory()
            .create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.e("Project is starting up")
    }
}