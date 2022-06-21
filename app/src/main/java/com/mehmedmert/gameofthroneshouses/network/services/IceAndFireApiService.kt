package com.mehmedmert.gameofthroneshouses.network.services

import com.mehmedmert.gameofthroneshouses.network.model.HouseApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IceAndFireApiService {
    @GET("houses")
    suspend fun getHouses() : Response<List<HouseApiModel>>

    @GET("houses/{id}")
    suspend fun getHouse(@Path("id") id: String) : Response<HouseApiModel>
}
