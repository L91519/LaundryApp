package com.example.laundryapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Laundries",
    foreignKeys = [ForeignKey(
        entity = PersonModel::class,
        parentColumns = arrayOf("userNum"),
        childColumns = arrayOf("ownerNum")
    )]
)
data class LaundryModel(
    @ColumnInfo(name = "brand")
    val brand: String,

    @ColumnInfo(name = "kind")
    val kind: String,

    @ColumnInfo(name = "etc")
    val etc: String,

    @ColumnInfo(name = "owner")
    val owner: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0
)