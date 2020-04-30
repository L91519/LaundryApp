package com.example.laundryapp.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.laundryapp.data.model.LaundryModel

@Database(entities = [LaundryModel::class], version = 1, exportSchema = false)

@TypeConverters(ListTypeConverter::class)
abstract class LaundryDataBase : RoomDatabase() {
    abstract fun laundryDao(): LaundryDao
}