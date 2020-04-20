package com.example.laundryapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "People")
data class PersonModel(
    @ColumnInfo(name = "name")
    val name: String,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "owner")
    val owner: String,

    @ColumnInfo(name = "address")
    val address: String
)