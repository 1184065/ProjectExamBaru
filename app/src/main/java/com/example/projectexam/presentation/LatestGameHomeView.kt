package com.example.projectexam.presentation

import androidx.lifecycle.LiveData
import com.example.projectexam.domain.entity.LatestGameEntity
import com.example.projectexam.domain.entity.TopRatingEntity
import com.example.projectexam.presentation.state.LatestGameState
import com.example.projectexam.presentation.state.TopRatingState

interface LatestGameHomeView {

    fun onShowLoading()
    fun onHideLoading()

    fun onSuccess(entity: LatestGameEntity)
    fun onError(error: Throwable)

    fun onPaginationSuccess(entity: LatestGameEntity)
    fun onPaginationError(error: Throwable)
    fun getApiLatest()
    val states: LiveData<TopRatingState>
}