package com.minseo.presentation.onboard

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minseo.data.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class OnboardViewModel @Inject constructor(
    private val dataStore: DataStoreManager
): ViewModel() {
    private val _onBoardingList: MutableStateFlow<List<OnBoardingInfo>> = MutableStateFlow(
        OnBoardingInfo.values().asList()
    )
    val onBoardingList: StateFlow<List<OnBoardingInfo>> get() = _onBoardingList.asStateFlow()

    fun updateOnBoarding() {
        viewModelScope.launch {
            dataStore.updateShowOnBoarding()
        }
    }
}

enum class OnBoardingInfo(
    @StringRes val titleRes: Int,
    @StringRes val subTitleRes: Int,
    @StringRes val imageRes: Int? = null
) {

}