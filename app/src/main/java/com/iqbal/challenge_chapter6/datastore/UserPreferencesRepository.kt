package com.iqbal.challenge_chapter6.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_pref")

class UserPreferencesRepository(private val context: Context)  {



    val username = stringPreferencesKey("username")
    val password = stringPreferencesKey("password")
    val login = booleanPreferencesKey("login")


//    Untuk Save Data

    suspend fun saveData(name : String, password : String){
        context.dataStore.edit {
            it[this.username] = name
            it[this.password] = password
        }
    }


//  Read Data Name From DataStore

    val userName: Flow<String> = context.dataStore.data
        .map {
            it[username] ?: ""
        }
    val userPassword: Flow<String> = context.dataStore.data
        .map {
            it[password] ?: ""
        }

    suspend fun  deletData(){
        context.dataStore.edit {
            it.clear()
        }
    }

}