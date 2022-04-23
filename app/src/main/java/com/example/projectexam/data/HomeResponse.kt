package com.example.projectexam.model

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("page")
    val page: Long? = -1L,
    @SerializedName("total_Pages")
    val totalPages: Long? = -1L,

    @SerializedName("results")
    val results: List<Result>? = emptyList()
)

data class Result(
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("slug")
    val slug: String? = null
)
