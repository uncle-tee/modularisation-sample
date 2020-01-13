package ng.com.dcodes.furnitureapp.domain.conf

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ng.com.dcodes.domain.entities.User
import ng.com.dcodes.furnitureapp.domain.dao.UserDao


@Database(
    entities = [
        User::class
    ], version = 1, exportSchema = false
)
abstract class FurnitureDatabase : RoomDatabase() {

    abstract val user: UserDao

    companion object {
        private const val FURNITURE_APP_DATABASE = "furniture_app_data_base"
        @Volatile
        private var INSTANCE: FurnitureDatabase? = null

        fun getInstance(context: Context): FurnitureDatabase {
            synchronized(this) {
                var instance: FurnitureDatabase? = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FurnitureDatabase::class.java,
                        FURNITURE_APP_DATABASE
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}