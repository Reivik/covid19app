package com.reivik.covid19app.utils

import com.reivik.covid19app.data.CountryData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RestCountryApi {
    @GET("country/{name}")
    suspend fun getCountryByName(@Path("name") countryName: String): List<CountryData>
}

var retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var resCountriesApi: RestCountryApi = retrofit.create(RestCountryApi::class.java)