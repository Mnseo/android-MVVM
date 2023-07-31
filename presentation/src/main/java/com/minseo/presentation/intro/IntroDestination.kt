package com.minseo.presentation.intro

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.minseo.presentation.navigation.NavigationDestination

object IntroDestination: NavigationDestination {
    override val route: String
        get() = "intro_route"
}

fun NavGraphBuilder.introGraph(
    navigateToOnBoarding: () -> Unit,
    navigateToMain: () -> Unit
) {
    composable(route = IntroDestination.route) {
        IntroRoute(
            navigateToOnBoarding = navigateToOnBoarding,
            navigateToMain = navigateToMain
        )
    }
}
