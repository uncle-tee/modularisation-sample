package ng.com.dcodes.furnitureapp.core

import android.app.Application
import timber.log.Timber


class FurnitureApp : Application() {
    val coreComponent by lazy {

    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.e("Project is starting up")
    }
}