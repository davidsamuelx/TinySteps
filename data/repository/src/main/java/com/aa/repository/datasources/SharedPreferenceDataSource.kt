package com.aa.repository.datasources

interface SharedPreferenceDataSource {

    fun saveUserToken(token:String)
    fun getUserToken(): String?

}