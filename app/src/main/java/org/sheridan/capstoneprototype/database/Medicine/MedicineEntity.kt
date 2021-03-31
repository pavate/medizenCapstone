package org.sheridan.capstoneprototype.database.Medicine

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicines")
data class MedicineEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @ColumnInfo(name = "medname")
    var fullName: String,

    @ColumnInfo(name = "dosage")
    var userDosage: Int,

    @ColumnInfo(name = "frequency")
    var userfrequency: Int,

    @ColumnInfo(name = "quantity")
    var userQuantity: Int,

    @ColumnInfo(name = "description")
    var medDescription: String


)