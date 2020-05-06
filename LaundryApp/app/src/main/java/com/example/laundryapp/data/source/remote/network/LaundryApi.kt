package com.example.laundryapp.data.source.remote.network

interface LaundryApi{

    fun getLaundries()

    fun getLaundriesByBrand()

    fun getLaundriesByOwner()

    fun getLaundriesByPH()

    fun getLaundriesByKind()

    fun delLaundry()

    fun saveLaundry()
}