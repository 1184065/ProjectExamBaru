package com.example.projectexam.presentation

import com.example.projectexam.domain.HomeEntity
import com.example.projectexam.domain.HomeParam
import com.example.projectexam.domain.HomeUsecase
import com.example.projectexam.domain.common.DefaultObserver

class HomePresenter(
    private val view: HomeView,
    private val usecase: HomeUsecase) {

    fun getApiTopRating(){
        view.onShowLoading()
        usecase.execute(
            GetApiTopRatingUsecase(),
            HomeParam()
        )
    }

    fun getApiLatest(){
        view.onShowLoading()
        usecase.execute(
            GetApiLatestUsecase(),
            HomeParam()
        )
    }

    fun loadMore(page: Long){
        usecase.execute(
            LoadMoreUsecase(),
            HomeParam(page = page)
        )
    }

    fun onDetach(){
        usecase.dispose()
    }

    inner class GetApiTopRatingUsecase : DefaultObserver<HomeEntity>() {

        override fun onSuccess(entity: HomeEntity){
            view.onHideLoading()
            view.onSuccess(entity)
        }

        override fun onError(exception: Throwable) {
            view.onHideLoading()
            view.onError(exception)
        }
    }

    inner class GetApiLatestUsecase : DefaultObserver<HomeEntity>() {

        override fun onSuccess(entity: HomeEntity){
            view.onHideLoading()
            view.onSuccess(entity)
        }

        override fun onError(exception: Throwable) {
            view.onHideLoading()
            view.onError(exception)
        }
    }

    inner class LoadMoreUsecase : DefaultObserver<HomeEntity>(){

        override fun onSuccess(entity: HomeEntity){
            view.onPaginationSuccess(entity)
        }

        override fun onError(exception: Throwable){
            view.onPaginationError(exception)
        }
    }
}