package com.example.projectexam.presentation

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.projectexam.R
import com.example.projectexam.domain.HomeEntity
import kotlinx.android.synthetic.main.item_home.view.*

enum class Type {
    DATA,
    LOADING
}

class HomeAdapter(private var results: MutableList<HomeEntity.Result?>) :
    Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            Type.DATA.ordinal -> {
                HomeViewHolder(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(
                            R.layout.item_home,
                            parent,
                            false
                        )
                )
            }
            Type.LOADING.ordinal -> {
                LoadingViewHolder(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(
                            R.layout.item_loading,
                            parent,
                            false
                        )
                )
            }
            else -> throw RuntimeException("Illegal View Type")
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is HomeViewHolder -> {
                holder.bind(results[holder.adapterPosition])
            }
        }
    }

//        // Munculin toast nama salah satu item waktu diklik
//        holder.itemView.setOnClickListener {
//            Toast.makeText(it.context, topRatingData.name, Toast.LENGTH_SHORT).show()
//        }
//
//        holder.itemView.setOnClickListener {
//            Toast.makeText(it.context, latestRatingData.name, Toast.LENGTH_SHORT).show()
//        }

    override fun getItemCount(): Int {
        return results.count()
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            results[position] == null -> Type.LOADING.ordinal
            else -> Type.DATA.ordinal
        }
    }

    fun showLoading(){
        results.add(null)
        Handler().post {notifyItemInserted(results.count().minus(1))}
    }

    fun hideLoading(){
        results.removeAt(results.count().minus(1))
        Handler().post {notifyItemRemoved(results.count())}
    }

    fun loadMore(results: MutableList<HomeEntity.Result?>){
        this.results.addAll(results)
        Handler().post {notifyDataSetChanged()}
    }

    inner class HomeViewHolder(itemView: View) : ViewHolder(itemView) {

        fun bind(result: HomeEntity.Result?) {
            with(itemView)  {
                tv_nametop.text = result?.nametop ?: " "
                tv_rating.text = result?.rating ?: " "
                tv_namelatest.text = result?.namelatest ?: " "
                tv_released.text = result?.released ?: " "
            }
         }
      }
    inner class LoadingViewHolder(itemView: View) : ViewHolder(itemView)
    }
