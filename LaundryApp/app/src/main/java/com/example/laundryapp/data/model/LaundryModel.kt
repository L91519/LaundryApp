package com.example.laundryapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Laundries")
data class LaundryModel(
    @ColumnInfo(name = "phoneNum")
    val phoneNum: String,

    @ColumnInfo(name = "address")
    val address: String,

    @ColumnInfo(name = "owner")
    val owner: String,

    @ColumnInfo(name = "brand")
    val brand: String,

    @ColumnInfo(name = "kind")
    val kind: String,

    @ColumnInfo(name = "etc")
    val etc: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0
) : Serializable