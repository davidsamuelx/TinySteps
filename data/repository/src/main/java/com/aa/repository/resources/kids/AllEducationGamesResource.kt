package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class AllEducationGamesResource(
    @SerializedName("images_data")
    val imagesData: List<ImagesData?>? = null
)