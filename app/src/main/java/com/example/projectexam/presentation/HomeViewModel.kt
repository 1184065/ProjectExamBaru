package com.example.projectexam.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectexam.data.HomeDatasource
import com.example.projectexam.domain.HomeEntity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val datasource: HomeDatasource
) : ViewModel(),HomeView{

    private val disposables = CompositeDisposable()
    private val observer = MutableLiveData<HomeViewState>()

    override val states: LiveData<HomeViewState>
            get() = observer

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    override fun getApiTopRating() {
        datasource.getApiTopRating()
            .map<HomeViewState>(HomeViewState::Success)
            .onErrorReturn(HomeViewState::Error)
            .toFlowable()
            .startWith(HomeViewState.Loading)
            .subscribe(observer::postValue)
            .let(disposables::add)
        }
    }