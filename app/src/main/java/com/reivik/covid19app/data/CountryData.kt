package com.reivik.covid19app.data

data class CountryData(
    val Active: Int,
    val City: String,
    val CityCode: String,
    val Confirmed: Int,
    val Country: String,
    val CountryCode: String,
    val Date: String,
    val Deaths: Int,
    val ID: String,
    val Lat: String,
    val Lon: String,
    val Province: String,
    val Recovered: Int
)