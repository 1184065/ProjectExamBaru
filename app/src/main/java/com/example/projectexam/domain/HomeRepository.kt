package com.example.projectexam.domain

import io.reactivex.Single

interface HomeRepository {
    fun getApiTopRating(param: HomeParam): Single<HomeEntity>
}