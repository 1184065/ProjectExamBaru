package com.example.projectexam.presentation

import androidx.lifecycle.LiveData
import com.example.projectexam.domain.HomeEntity

interface HomeView {

    fun onShowLoading()
    fun onHideLoading()

    fun onSuccess(entity: HomeEntity)
    fun onError(error: Throwable)

    fun onPaginationSuccess(entity: HomeEntity)
    fun onPaginationError(error: Throwable)
    fun getApiTopRating()
    fun getApiLatest()
    val states: LiveData<HomeViewState>
}