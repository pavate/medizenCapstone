package org.sheridan.capstoneprototype.database.User


import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room.databaseBuilder

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            if (INSTANCE == null) {
                INSTANCE = databaseBuilder(
                    context,
                    UserDatabase::class.java,
                    "users.db")
                    .build()
            }
            return INSTANCE as UserDatabase
        }
    }
}