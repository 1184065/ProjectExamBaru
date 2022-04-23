package com.example.projectexam.di.module

import com.example.projectexam.data.HomeDatasource
import com.example.projectexam.data.HomeFactory
import com.example.projectexam.di.scope.Presentation
import com.example.projectexam.domain.HomeRepository
import com.example.projectexam.domain.HomeRepositoryImpl
import com.example.projectexam.domain.HomeUsecase
import com.example.projectexam.domain.executor.JobExecutor
import com.example.projectexam.domain.executor.UIThread
import com.example.projectexam.presentation.HomeActivity
import com.example.projectexam.presentation.HomePresenter
import com.example.projectexam.presentation.HomeView
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class HomeModule {
    @Module
    companion object{

        @JvmStatic
        @Presentation
        @Provides
        fun providesHomeDataSource(retrofit: Retrofit): HomeDatasource =
            retrofit.create(HomeDatasource::class.java)

        @JvmStatic
        @Presentation
        @Provides
        fun providesFactory(datasource: HomeDatasource): HomeFactory =
            HomeFactory(datasource)

        @JvmStatic
        @Presentation
        @Provides
        fun providesRepository(factory: HomeFactory): HomeRepositoryImpl =
            HomeRepositoryImpl(factory)

        @JvmStatic
        @Presentation
        @Provides
        fun providesUsecase(
            repository: HomeRepository,
            executor: JobExecutor,
            thread: UIThread
        ): HomeUsecase = HomeUsecase(repository, executor, thread)

        @JvmStatic
        @Presentation
        @Provides
        fun providesPresenter(
            view: HomeView,
            usecase: HomeUsecase
        ):HomePresenter = HomePresenter(view, usecase)
    }

    @Binds
    abstract fun bindRepository(repositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    abstract fun bindView(activity: HomeActivity): HomeView

//    @Binds
//    @IntoMap
//    @ViewModelKey(HomeViewModel::class)
//    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}