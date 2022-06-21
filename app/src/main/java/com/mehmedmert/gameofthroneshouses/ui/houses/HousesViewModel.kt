package com.mehmedmert.gameofthroneshouses.ui.houses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehmedmert.gameofthroneshouses.data.model.House
import com.mehmedmert.gameofthroneshouses.data.model.NetworkResult
import com.mehmedmert.gameofthroneshouses.data.repositories.HousesRepository
import com.mehmedmert.gameofthroneshouses.ui.common.NavigationEvent
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
class HousesViewModel @Inject constructor(
    private val housesRepository: HousesRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HousesUiState())
    val uiState: StateFlow<HousesUiState> = _uiState.asStateFlow()

    private val _navigationEvent = MutableLiveData<NavigationEvent>()
    val navigationEvent: LiveData<NavigationEvent> = _navigationEvent

    private var fetchJob: Job? = null

    fun fetchHouses() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                when (val housesResult = housesRepository.getHouses()) {
                    is NetworkResult.Success -> {
                        _uiState.update { it.copy(houses = housesResult.data) }
                    }
                    is NetworkResult.Error -> {
                        _uiState.update { it.copy(userMessage = housesResult.message) }
                    }
                }
            } catch (ioe: IOException) {
                _uiState.update { it.copy(userMessage = ioe.localizedMessage ?: "") }
            }
        }
    }

    fun onHouseClicked(house: House) {
        val navDirections = HousesFragmentDirections.toHouseDetailsFragment(house.id)
        _navigationEvent.postValue(NavigationEvent.ToNavDirections(navDirections))
    }
}
