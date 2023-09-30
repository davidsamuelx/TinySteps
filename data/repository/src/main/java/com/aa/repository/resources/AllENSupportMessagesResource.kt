package com.aa.repository.resources


import com.google.gson.annotations.SerializedName

data class AllENSupportMessagesResource(
    @SerializedName("Records")
    val records: List<ENRecordResource?>? = null
)