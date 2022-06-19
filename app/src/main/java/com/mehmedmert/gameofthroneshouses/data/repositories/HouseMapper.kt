package com.mehmedmert.gameofthroneshouses.data.repositories

import com.mehmedmert.gameofthroneshouses.data.model.House
import com.mehmedmert.gameofthroneshouses.network.model.HouseApiModel

object HouseMapper {
    fun map(houseApiModelList: List<HouseApiModel>): List<House> = houseApiModelList.map {
        map(it)
    }

    fun map(houseApiModel: HouseApiModel): House = House(
        url = houseApiModel.url,
        name = houseApiModel.name,
        region = houseApiModel.region,
        words = houseApiModel.words,
        titles = houseApiModel.titles,
        seats = houseApiModel.seats,
        currentLord = houseApiModel.currentLord,
    )
}
