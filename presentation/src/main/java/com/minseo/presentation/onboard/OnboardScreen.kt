package com.minseo.presentation.onboard

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import java.lang.reflect.Modifier


@Composable
fun OnboardRoute(
    navigateToMain:() -> Unit,
    viewModel: OnboardViewModel = hiltViewModel()
) {
    val onBoardingList by viewModel.onBoardingList.collectAsState()
    Box(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
//            .background(MainColor)
    ) {
        OnBoardPager(onBoardingList) {
            viewModel.updateOnBoarding()
            navigateToMain()
        }
    }
}

@Composable
fun OnBoardPager(
    list: List<OnBoardingInfo>,
    navigateToMain: () -> Unit
) {
//    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Column (
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Spacer(modifier = androidx.compose.ui.Modifier.height(80.dp))

    }
}