package com.example.projectexam.presentation

import com.example.projectexam.model.HomeResponse

sealed class HomeViewState {

    object Loading : HomeViewState()

    data class Success(val response: HomeResponse) : HomeViewState()
    data class Error (val error : Throwable) : HomeViewState()
}
