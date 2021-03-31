package org.sheridan.capstoneprototype.database.Medicine

/*
StudentDao.kt
 */

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedicineDao{
    @Query("SELECT * FROM medicines")
    fun getAll(): List<MedicineEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(medicine: MedicineEntity)

    @Query("DELETE FROM medicines")
    fun deleteAll()


}