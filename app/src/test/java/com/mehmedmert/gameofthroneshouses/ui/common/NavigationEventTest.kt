package com.mehmedmert.gameofthroneshouses.ui.common

import androidx.navigation.NavController
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class NavigationEventTest {
    @Mock lateinit var navController: NavController

    @Test
    fun `verify consumed only once`() {
        // given
        val navigationEvent = NavigationEvent.Back

        // when
        navigationEvent.consume(navController)
        navigationEvent.consume(navController)

        // then
        verify(navController, times(1)).popBackStack()
    }
}
