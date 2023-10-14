package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class StoryResource(
    @SerializedName("Admin_id")
    val adminId: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("PathVideo")
    val pathVideo: String? = null,
    @SerializedName("PhaseThree_id")
    val phaseThreeId: Any? = null,
    @SerializedName("Title")
    val title: String? = null
)