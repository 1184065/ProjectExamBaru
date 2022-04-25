package com.example.projectexam.data

import com.example.projectexam.BuildConfig
import com.example.projectexam.model.HomeResponse
import io.reactivex.Single

class HomeFactory(private val datasource: HomeDatasource) {

    fun getApiTopRating(page: Long): Unit =
        datasource.getApiTopRating(
        apiKey = BuildConfig.API_KEY,
        page = page
        )

    fun getApiLatest(): Single<HomeResponse> =
        datasource.getApiLatest(
            apiKey = BuildConfig.API_KEY,
        )
}