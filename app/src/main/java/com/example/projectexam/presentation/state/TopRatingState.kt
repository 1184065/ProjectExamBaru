package com.example.projectexam.presentation.state

sealed class TopRatingState {

    object Loading : TopRatingState()

    data class Success(val response: TopRatingState) : TopRatingState()
    data class Error(val error: Throwable) : TopRatingState()
}
