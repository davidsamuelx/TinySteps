package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class Music(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("ImgPath")
    val imgPath: String? = null,
    @SerializedName("music_path")
    val musicPath: String? = null,
    @SerializedName("MusicType")
    val musicType: String? = null,
    @SerializedName("pre_id")
    val preId: Any? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
)