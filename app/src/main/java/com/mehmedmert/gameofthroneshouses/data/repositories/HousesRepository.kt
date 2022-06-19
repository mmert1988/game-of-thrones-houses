package com.mehmedmert.gameofthroneshouses.data.repositories

import com.mehmedmert.gameofthroneshouses.data.model.House
import com.mehmedmert.gameofthroneshouses.data.model.NetworkResult
import com.mehmedmert.gameofthroneshouses.network.services.IceAndFireApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class HousesRepository(
    private val iceAndFireApiService: IceAndFireApiService,
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun getHouses(): NetworkResult<List<House>> = withContext(ioDispatcher) {
        val housesResponse = iceAndFireApiService.getHouses()
        val housesResponseBody = housesResponse.body()
        if (housesResponse.isSuccessful && housesResponseBody != null) {
            NetworkResult.Success(HouseMapper.map(housesResponseBody))
        } else {
            NetworkResult.Error("Failed to fetch houses")
        }
    }

    suspend fun getHouse(id: String): NetworkResult<House> = withContext(ioDispatcher) {
        val houseResponse = iceAndFireApiService.getHouse(id)
        val houseResponseBody = houseResponse.body()
        if (houseResponse.isSuccessful && houseResponseBody != null) {
            NetworkResult.Success(HouseMapper.map(houseResponseBody))
        } else {
            NetworkResult.Error("Failed to fetch house with id=$id")
        }
    }
}
