package com.eharoldreyes.freelancemovies.model.dto

data class ListResponse<T> (
    val page: Int,
    val results: List<T>,
    val total_pages: Int,
    val total_results: Int
)