package com.aa.local

import android.content.SharedPreferences
import com.aa.repository.datasources.SharedPreferenceDataSource
import javax.inject.Inject

class SharedPrefImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
): SharedPreferenceDataSource {
}