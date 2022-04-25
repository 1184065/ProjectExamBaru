package com.example.projectexam.domain

data class HomeEntity(
    val page: Long,
    val totalPages: Long,
    val results: MutableList<Result>){

    data class Result(
        val nametop: String,
        val rating: String,
        val namelatest: String,
        val released: String,

    )
}
