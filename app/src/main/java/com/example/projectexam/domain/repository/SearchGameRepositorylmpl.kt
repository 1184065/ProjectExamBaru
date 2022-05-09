package com.example.projectexam.domain.repository

import com.example.projectexam.data.factory.HomeFactory
import com.example.projectexam.domain.HomeParam
import com.example.projectexam.domain.entity.SearchGameEntity
import com.example.projectexam.domain.entity.TopRatingEntity
import io.reactivex.Single

class SearchGameRepositoryImpl(
    private val factory: HomeFactory
) : SearchGameRepository {

    override fun getSearch(param: HomeParam): Single<SearchGameEntity> =
        factory.getSearch().map { response ->
            SearchGameEntity(
                results = response.results?.map { result ->
                    SearchGameEntity.Result(
                        backgroundImage = result.backgroundImage ?: " ",
                        name = result.name ?: " ",
                    )
                }?.toMutableList() ?: mutableListOf()
            )
        }
}