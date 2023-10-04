package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class VideoResource(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("pre_id")
    val preId: Any? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    @SerializedName("VideoDescriptionAR")
    val videoDescriptionAR: String? = null,
    @SerializedName("VideoDescriptionEN")
    val videoDescriptionEN: String? = null,
    @SerializedName("VideoNameAR")
    val videoNameAR: String? = null,
    @SerializedName("VideoNameEN")
    val videoNameEN: String? = null,
    @SerializedName("Video_path")
    val videoPath: String? = null
)