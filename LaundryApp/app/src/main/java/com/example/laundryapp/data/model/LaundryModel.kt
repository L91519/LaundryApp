package com.example.laundryapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Laundries")
data class LaundryModel(
    @ColumnInfo(name = "phoneNum")
    val phoneNum: String? = null,

    @ColumnInfo(name = "address")
    val address: String? = null,

    @ColumnInfo(name = "owner")
    val owner: String? = null,

    @ColumnInfo(name = "brand")
    val brand: String? = null,

    @ColumnInfo(name = "kind")
    val kind: String? = null,

    @ColumnInfo(name = "price")
    val price: String? = null,

    @ColumnInfo(name = "etc")
    val etc: String? = null,

    @ColumnInfo(name = "status")
    val isDone: Boolean? = null,

    @ColumnInfo(name = "data")
    val date: String? = null,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0

)