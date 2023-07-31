package com.minseo.presentation.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.minseo.presentation.navigation.NavigationDestination

object MainDestination: NavigationDestination {
    override val route: String
        get() = "main_route"
}

fun NavGraphBuilder.mainGraph(){
    composable(route = MainDestination.route) {
        MainRoute()
    }
}