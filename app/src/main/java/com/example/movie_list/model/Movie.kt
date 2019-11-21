package com.example.movie_list.model

object Movie {

    val movies = mutableListOf<MovieItem>()

    data class MovieItem( val title: String, val releaseDate: String, val posterPath: String, val genre: String)
}