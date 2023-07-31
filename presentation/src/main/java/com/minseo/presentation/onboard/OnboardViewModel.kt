package com.minseo.presentation.onboard

import androidx.lifecycle.ViewModel
import com.minseo.data.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class OnboardViewModel @Inject constructor(
    private val dataStore: DataStoreManager
): ViewModel() {

}