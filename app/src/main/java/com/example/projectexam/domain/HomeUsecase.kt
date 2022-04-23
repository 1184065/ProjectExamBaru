package com.example.projectexam.domain

import com.example.projectexam.domain.common.Usecase
import com.example.projectexam.domain.executor.JobExecutor
import com.example.projectexam.domain.executor.UIThread
import io.reactivex.Single

class HomeUsecase (
    private val repository: HomeRepository,
    executor: JobExecutor,
    thread: UIThread
) : Usecase<HomeEntity, HomeParam>(executor, thread) {

    override fun buildUseCaseObservable(params: HomeParam): Single<HomeEntity> =
        repository.getApiTopRating(params)

}