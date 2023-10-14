package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class AllAchievementsResource(
    @SerializedName("recordList")
    val recordList: List<RecordResource?>? = null
)