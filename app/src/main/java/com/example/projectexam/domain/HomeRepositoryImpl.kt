package com.example.projectexam.domain

import com.example.projectexam.data.HomeFactory
import com.example.projectexam.domain.HomeEntity.Result
import io.reactivex.Single


class HomeRepositoryImpl(
    private val factory: HomeFactory
) : HomeRepository {

    override fun getApiTopRating(param: HomeParam): Single<HomeEntity> =
        factory.getApiTopRating(param.page).map { response ->
            HomeEntity(
                page = response.page ?: -1L,
                totalPages = response.totalPages ?: -1L,
                results = response.results?.map { result ->
                    Result(
                        name = result.name ?: "Untitled",
                        slug = result.slug ?: "No Description"
                    )
                }?.toMutableList() ?: mutableListOf()
            )
          }
        }

//results = response.results?.map { result ->
//    Result(
//        name = result.name ?: "Untitled",
//        slug = result.slug ?: "No Description"
//    )


