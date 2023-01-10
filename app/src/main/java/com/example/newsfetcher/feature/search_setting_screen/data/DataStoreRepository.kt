package com.example.newsfetcher.feature.search_setting_screen.data

import android.content.Context
import android.util.Log
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


const val PREFERENCE_NAME = "PREFERENCE_NAME"
const val MY_NAME = "MY_NAME"
const val NONE = "NONE"


class DataStoreRepository(context: Context) {

    private object PreferenceKeys {
        val name = preferencesKey<String>(MY_NAME)
    }

    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = PREFERENCE_NAME
    )

    suspend fun saveToDataStore(name: String){
        dataStore.edit { preference ->
            preference[PreferenceKeys.name] = name
        }
    }

    val readFromDataStore: Flow<String> = dataStore.data
        .catch { exception ->
            if(exception is IOException){
                Log.d("DataStore", exception.message.toString())
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }
        .map { preference ->
            val myName = preference[PreferenceKeys.name] ?: NONE
            myName
        }

}