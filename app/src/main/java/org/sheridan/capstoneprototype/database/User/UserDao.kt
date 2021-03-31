package org.sheridan.capstoneprototype.database.User

/*
StudentDao.kt
 */

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao{
    @Query("SELECT * FROM users")
    fun getAll(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: UserEntity)

    @Query("DELETE FROM users")
    fun deleteAll()


}