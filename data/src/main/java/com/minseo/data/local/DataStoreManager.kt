package com.minseo.data.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.minseo.data.local.Keys.APP_VISIT_DATE
import com.minseo.data.local.Keys.DEVICE_TOKEN
import com.minseo.data.local.Keys.INTRODUCE_COMMENTS
import com.minseo.data.local.Keys.SHOW_ON_BOARDING
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


private const val APP_NAME="self"
private val Context.dataStore by preferencesDataStore(APP_NAME)

//Preference Keys
object Keys {
    val INTRODUCE_COMMENTS = booleanPreferencesKey("introduce_comments")
    val SHOW_ON_BOARDING = booleanPreferencesKey("onBoarding")
    val DEVICE_TOKEN = stringPreferencesKey("device_token")
    val APP_VISIT_DATE = intPreferencesKey("visitDate")
}

class DataStoreManager @Inject constructor(@ApplicationContext appContext: Context) {

    private val settingsDataStore = appContext.dataStore

    val appDeviceToken: Flow<String> = settingsDataStore.data.map { pref ->
        pref[DEVICE_TOKEN] ?: ""
    }

    suspend fun updateDeviceToken(token: String) {
        settingsDataStore.edit { pref ->
            pref[DEVICE_TOKEN] = token
        }
    }

    val appVisitDate: Flow<Int> = settingsDataStore.data.map { pref->
        pref[APP_VISIT_DATE] ?: 0
    }

    suspend fun updateAppVisitDate(date:Int) {
        settingsDataStore.edit { pref->
            pref[APP_VISIT_DATE] = date
        }
    }

    val showOnBoarding: Flow<Boolean> = settingsDataStore.data.map { it[SHOW_ON_BOARDING] ?: true }

    suspend fun updateShowOnBoarding() {
        settingsDataStore.edit { pref ->
            pref[SHOW_ON_BOARDING] = false
        }
    }

    val introduceComments: Flow<Boolean> = settingsDataStore.data.map {
        it[INTRODUCE_COMMENTS] ?: true
    }

}