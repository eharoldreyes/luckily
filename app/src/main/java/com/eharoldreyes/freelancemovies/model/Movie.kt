package com.eharoldreyes.freelancemovies.model

data class Movie(
    val id: Int,
    val title: String?,
    val poster_path: String,
    val original_language: String?,
    val original_title: String?,
    val overview: String? = null,
    val popularity: Int,
    val vote_average: Int,
    val vote_count: Int
)