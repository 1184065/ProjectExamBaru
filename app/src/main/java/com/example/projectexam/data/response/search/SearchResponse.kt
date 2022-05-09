package com.example.projectexam.data.response.search

import com.google.gson.annotations.SerializedName

data class SearchGame(
    @SerializedName("results")
    val results: List<Search>? = emptyList()
)

data class Search(

    @SerializedName("name")
    val name: String? = null,
)