package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class ImageDIfferenceGameResource(
    @SerializedName("diffOfTwoImages")
    val diffOfTwoImages: List<DiffOfTwoImageResource?>? = null
)