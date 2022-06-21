package com.mehmedmert.gameofthroneshouses.ui.houseDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehmedmert.gameofthroneshouses.data.model.NetworkResult
import com.mehmedmert.gameofthroneshouses.data.repositories.HousesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HouseDetailsViewModel @Inject constructor(
    private val housesRepository: HousesRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HouseDetailsUiState())
    val uiState: StateFlow<HouseDetailsUiState> = _uiState.asStateFlow()

    private var fetchJob: Job? = null

    fun fetchHouseDetails(id: String) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                when (val houseResult = housesRepository.getHouse(id)) {
                    is NetworkResult.Success -> {
                        _uiState.update {
                            it.copy(
                                name = houseResult.data.name,
                                region = houseResult.data.region,
                                words = houseResult.data.words,
                                titles = houseResult.data.titles,
                                seats = houseResult.data.seats
                            )
                        }
                    }
                    is NetworkResult.Error -> {
                        _uiState.update { it.copy(userMessage = houseResult.message) }
                    }
                }
            } catch (ioe: IOException) {
                _uiState.update { it.copy(userMessage = ioe.localizedMessage ?: "") }
            }
        }
    }
}
