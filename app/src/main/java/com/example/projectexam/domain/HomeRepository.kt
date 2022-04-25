package com.example.projectexam.domain

import io.reactivex.Single

interface HomeRepository {
    fun getApiTopRating(param: HomeParam): Single<HomeEntity>
    fun getApiLatest(param: HomeParam): Single<HomeEntity>
}