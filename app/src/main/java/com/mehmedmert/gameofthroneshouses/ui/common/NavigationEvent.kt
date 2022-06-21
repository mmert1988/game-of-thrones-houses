package com.mehmedmert.gameofthroneshouses.ui.common

import androidx.navigation.NavController
import androidx.navigation.NavDirections

sealed class NavigationEvent {
    private var consumed = false
    fun consume(navController: NavController) {
        if (!consumed) {
            consumed = true
            onConsume(navController)
        }
    }

    protected abstract fun onConsume(navController: NavController)

    data class ToNavDirections(val navDirections: NavDirections) : NavigationEvent() {
        override fun onConsume(navController: NavController) {
            navController.navigate(navDirections)
        }
    }

    object Back : NavigationEvent() {
        override fun onConsume(navController: NavController) {
            navController.popBackStack()
        }
    }
}

fun NavController.navigate(navigationEvent: NavigationEvent) {
    navigationEvent.consume(this)
}
