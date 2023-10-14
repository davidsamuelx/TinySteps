package com.aa.repository.resources.kids


import com.google.gson.annotations.SerializedName

data class AllStoriesResource(
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("storyphase3")
    val storyphase3: List<StoryResource?>? = null
)