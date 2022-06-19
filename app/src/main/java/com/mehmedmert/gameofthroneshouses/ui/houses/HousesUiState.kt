package com.mehmedmert.gameofthroneshouses.ui.houses

import com.mehmedmert.gameofthroneshouses.data.model.House

data class HousesUiState(
    val houses: List<House> = listOf(),
    val userMessage: String = ""
)
