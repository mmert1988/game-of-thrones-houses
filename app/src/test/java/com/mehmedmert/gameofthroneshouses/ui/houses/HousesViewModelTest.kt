package com.mehmedmert.gameofthroneshouses.ui.houses

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mehmedmert.gameofthroneshouses.data.model.House
import com.mehmedmert.gameofthroneshouses.data.repositories.HousesRepository
import com.mehmedmert.gameofthroneshouses.ui.common.NavigationEvent
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HousesViewModelTest {

    @Mock
    private lateinit var housesRepository: HousesRepository

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `onHouseClicked triggers navigationEvent`() {
        // given
        val housesViewModel = HousesViewModel(housesRepository)
        val house = House("testId", "name", "region", "words", emptyList(), emptyList(), "currentLord")

        // when
        housesViewModel.onHouseClicked(house)

        // then
        val expected = NavigationEvent.ToNavDirections(HousesFragmentDirections.toHouseDetailsFragment("testId"))
        Assert.assertEquals(expected, housesViewModel.navigationEvent.value)
    }
}
