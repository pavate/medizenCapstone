package org.sheridan.capstoneprototype.database.User

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @ColumnInfo(name = "name")
    var fullName: String,

    @ColumnInfo(name = "email")
    var userEmail: String,

    @ColumnInfo(name = "age")
    var age: Int,

    @ColumnInfo(name = "password")
    var userPassword: String


)