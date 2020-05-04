package com.example.laundryapp.data.source.local.db

import androidx.room.TypeConverter
import com.example.laundryapp.data.model.LaundryModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListTypeConverter {
    @TypeConverter
    fun stringToList(value: String): MutableList<LaundryModel> {
        val listType = object : TypeToken<MutableList<LaundryModel>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun listToString(list: List<LaundryModel>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

}