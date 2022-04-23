package com.example.projectexam.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.projectexam.R
import com.example.projectexam.domain.HomeEntity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter

    private var adapter: HomeAdapter? = null
    private var isLoading: Boolean = false
    private var currentPage: Long = -1L
//    lateinit var viewModelFactory: ViewModelProvider.Factory
//
//   private val viewModel: HomeView by lazy {
//       ViewModelProviders
//           .of( this, viewModelFactory)
//           .get(HomeViewModel::class.java)
//   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_home)
                presenter.getApiTopRating()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    override fun onShowLoading() {
        pb_home.visibility = View.VISIBLE
    }

    override fun onHideLoading() {
        pb_home.visibility = View.GONE
        rv_home.visibility = View.VISIBLE
    }

    override fun onSuccess(entity: HomeEntity) {
        adapter = HomeAdapter(entity.results.toMutableList())
        rv_home.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
        rv_home.adapter = adapter

        currentPage = entity.page
        rv_home.addOnScrollListener(object : OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int){
                super.onScrolled(recyclerView, dx, dy)
                if(currentPage > entity.totalPages || isLoading) return

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount

                if(visibleItemCount.plus(firstVisibleItemPosition)> totalItemCount){
                    adapter?.showLoading()
                    isLoading = true
                    currentPage++
                    presenter.loadMore(currentPage)
                }
            }
        })
    }

    override fun onError(error: Throwable) {
        Log.e(HomeActivity::class.java.simpleName, "${error.printStackTrace()}")
    }

    override fun onPaginationSuccess(entity: HomeEntity) {
        currentPage = entity.page
        hideLoading()
        adapter?. loadMore(entity.results.toMutableList())
    }

    override fun onPaginationError(error: Throwable) {
        Log.e(HomeActivity::class.java.simpleName, "${error.printStackTrace()}")
        currentPage--
        hideLoading()
    }

    private fun hideLoading(){
        adapter?.hideLoading()
        isLoading = false
    }
}


//                    viewModel.states.observe(this, Observer { state ->
//                        when (state){
//                            is HomeViewState.Loading -> pb_home.visibility = View.VISIBLE
//                            is HomeViewState.Success ->{
//                                pb_home.visibility = View.GONE
//                                rv_home.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
//                                rv_home.adapter = state.response.results?.let { HomeAdapter(it) }
//                            }
//                            is Error -> {
//                                pb_home.visibility = View.GONE
//                                Log.e(HomeActivity::class.java.simpleName, "${state.printStackTrace()}")
//                            }
//                        }
//                    })
//                    viewModel.getApiTopRating()
