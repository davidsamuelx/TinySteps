package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class AllAnimalGameResource(
    @SerializedName("images_data")
    val imagesData: List<GameDataResource?>? = null
)