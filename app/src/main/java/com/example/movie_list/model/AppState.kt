package com.example.movie_list.model

import com.example.movie_list.model.Movie.MovieItem

data class AppState (
    val list: List<MovieItem>? = null
)