package com.example.projectexam.data

import com.example.projectexam.BuildConfig
import com.example.projectexam.BuildConfig.API_KEY
import com.example.projectexam.model.HomeResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface HomeDatasource {
    @GET("games?key=${API_KEY}&page_size=10&ordering=-rating&platforms=4&page=1")
    fun getApiTopRating(
        @Query("api_key")
        apiKey: String,

        @Query("page")
        page: Long
    ): Single<HomeResponse>
}
