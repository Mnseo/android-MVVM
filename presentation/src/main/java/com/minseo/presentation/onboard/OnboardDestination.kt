package com.minseo.presentation.onboard

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.minseo.presentation.navigation.NavigationDestination

object OnboardDestination: NavigationDestination {
    override val route: String
        get() = "onboard_route"
}

//fun NavGraphBuilder.onboardGraph(
//    navigateToMain:() ->Unit
//) {
//    composable(route = OnboardDestination.route) {
//        OnboardRoute(
//            navigateToMain = navigateToMain
//        )
//    }
//}