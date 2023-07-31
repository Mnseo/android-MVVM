package com.minseo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.minseo.presentation.intro.IntroDestination
import com.minseo.presentation.main.MainDestination
import com.minseo.presentation.onboard.OnboardDestination

@Composable
fun NavHost(
    navController: NavController,
    modifier: Modifier = Modifier,
    startDestination: String = IntroDestination.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        //Navigation Graph
        introGraph(
            navigateToOnBoarding = {
                navController.navigate(OnboardDestination.route) {
                    popUpTo(IntroDestination.route) {inclusive = true}
                }
            }
        )
        onboardingGraph(
            navigateToMain = {
                navController.navigate(MainDestination.route) {
                    popUpTo(OnboardDestination.route) {inclusive = true}
                }
            },
        )


    }
}