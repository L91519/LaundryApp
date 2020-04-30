package com.example.laundryapp.data.source.local.db

import androidx.room.Dao
import androidx.room.Query
import com.example.laundryapp.data.model.LaundryModel

@Dao
interface LaundryDao {

    @Query("SELECT * FROM Laundries")
    fun getLaundries(): MutableList<LaundryModel>

    @Query("SELECT * FROM Laundries WHERE brand = :brand")
    fun getLaundriesByBrand(brand: String): MutableList<LaundryModel>

    @Query("SELECT * FROM Laundries WHERE brand = :kind")
    fun getLaundriesByKind(kind: String): MutableList<LaundryModel>

    @Query("SELECT * FROM Laundries WHERE brand = :owner")
    fun getLaundriesByOwner(owner: String): MutableList<LaundryModel>

    @Query("SELECT * FROM Laundries WHERE brand = :ph")
    fun getLaundriesByPH(ph: String): MutableList<LaundryModel>
}