package com.mehmedmert.gameofthroneshouses.ui.houseDetails

data class HouseDetailsUiState(
    val name: String = "",
    val region: String = "",
    val words: String = "",
    val titles: List<String> = listOf(),
    val seats: List<String> = listOf(),

    val loading: Boolean = false,
    val userMessage: String = "",
)
