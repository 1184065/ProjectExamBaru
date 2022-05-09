package com.example.projectexam.di.scope

import androidx.lifecycle.ViewModel
import com.example.projectexam.presentation.LatestGameHomeView
import com.example.projectexam.presentation.TopRatingHomeView
import com.example.projectexam.presentation.viewmodel.LatestGameViewModel
import dagger.MapKey
import kotlin.reflect.KClass


@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
