package ng.com.dcodes.furnitureapp.domain.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ng.com.dcodes.domain.entities.User


@Dao
interface UserDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insert(user: User)


    @Query("SELECT * FROM user ORDER BY id ASC limit 1 ")
     fun findLatest(): LiveData<User>
}