package com.aa.repository.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TEST_TABLE")
data class TestDatabaseDto(
    @SerializedName("test")
    val test: Int,
)
