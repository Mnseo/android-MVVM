package com.minseo.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minseo.data.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
) : ViewModel() {
    private val todayDate = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

    init {
        //방문 일자 초기화
        viewModelScope.launch {
            dataStoreManager.appVisitDate
                .map {
                    if (it != todayDate) {
                        dataStoreManager.updateAppVisitDate(todayDate)
                    }
                }

        }
    }

    fun saveUserInfo(id: String) {
        viewModelScope.launch {

        }
    }
}