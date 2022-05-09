package com.example.projectexam.domain.repository

import com.example.projectexam.domain.HomeParam
import com.example.projectexam.domain.entity.SearchGameEntity
import io.reactivex.Single

interface SearchGameRepository {
    fun getApiTopRating(param: HomeParam): Single<SearchGameEntity>
}