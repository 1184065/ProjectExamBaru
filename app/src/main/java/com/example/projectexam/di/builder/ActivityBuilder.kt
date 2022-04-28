package com.example.projectexam.di.builder

import com.example.projectexam.di.module.HomeModule
import com.example.projectexam.di.scope.Presentation
import com.example.projectexam.presentation.activity.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {


    @Presentation
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}