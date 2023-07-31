package com.minseo.presentation.intro

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Modifier

@Composable
fun IntroRoute (
    navigateToOnBoarding: () -> Unit,
    navigateToMain: () -> Unit,
    viewModel: IntroViewModel = hiltViewModel()
) {
    val showOnBoarding by viewModel.showOnBoarding.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SplashLogo {
            if (showOnBoarding) navigateToOnBoarding
            else navigateToMain
        }
    }
}

@Composable
fun SplashLogo(
    navigateToMain: () -> Unit
) {

}