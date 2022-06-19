package com.mehmedmert.gameofthroneshouses.network.services

import com.mehmedmert.gameofthroneshouses.network.model.HouseApiModel
import retrofit2.Response
import retrofit2.http.GET

interface IceAndFireApiService {
    @GET("houses")
    suspend fun getHouses() : Response<List<HouseApiModel>>

    @GET("houses/{id}")
    suspend fun getHouse(id: String) : Response<HouseApiModel>
}
