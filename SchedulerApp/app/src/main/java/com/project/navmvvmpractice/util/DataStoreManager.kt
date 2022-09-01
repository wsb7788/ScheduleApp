package com.project.navmvvmpractice.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject



val Context.dataStore: DataStore<Preferences> by preferencesDataStore("Settings")

class DataStoreManager @Inject constructor(@ApplicationContext context: Context) {

    companion object{
        val ID = stringPreferencesKey("id")
    }



    private val settingDataStore = context.dataStore

    suspend fun saveId(id: String){
        settingDataStore.edit {
            it[ID] = id
        }
    }

    suspend fun getId():String{
        return settingDataStore.data.map {
            it[ID]
        }.first() ?: "NO ID"

    }




}