package com.mehmedmert.gameofthroneshouses.data.model

data class House(
    val url: String,
    val name: String,
    val region: String,
    val words: String,
    val titles: List<String>,
    val seats: List<String>,
    val currentLord: String,
)
