package org.sheridan.capstoneprototype.database.Medicine


import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room.databaseBuilder

@Database(entities = [MedicineEntity::class], version = 1)
abstract class MedicineDataBase: RoomDatabase() {
    abstract fun MedicineDao(): MedicineDao

    companion object {

        @Volatile
        private var INSTANCE: MedicineDataBase? = null

        fun getInstance(context: Context): MedicineDataBase {
            if (INSTANCE == null) {
                INSTANCE = databaseBuilder(
                    context,
                        MedicineDataBase::class.java,
                    "medicines.db")
                    .build()
            }
            return INSTANCE as MedicineDataBase
        }
    }
}