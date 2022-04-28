package com.example.projectexam.domain.repository

import com.example.projectexam.data.factory.HomeFactory
import com.example.projectexam.domain.HomeParam
import com.example.projectexam.domain.entity.TopRatingEntity
import io.reactivex.Single

class TopRatingRepositoryImpl(
    private val factory: HomeFactory
) : TopRatingRepository {

    override fun getApiTopRating(param: HomeParam): Single<TopRatingEntity> =
        factory.getApiTopRating(param.page).map { response ->
            TopRatingEntity(
                results = response.results?.map { result ->
                   Result(
                       backgroundImage = result.backgroundImage ?: " ",
                        name = result.name ?: " ",
                        rating = result.rating ?: " ",
                    )
                }?.toMutableList() ?: mutableListOf()
            )
          }
        }