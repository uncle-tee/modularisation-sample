package ng.com.dcodes.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 1L,
    @ColumnInfo(name = "name")
    val name: String
)
