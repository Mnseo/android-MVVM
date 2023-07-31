package com.minseo.presentation.onboard

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun OnboardRoute(
    navigateToMain:() -> Unit,
    viewModel: OnboardViewModel = hiltViewModel()
) {

}