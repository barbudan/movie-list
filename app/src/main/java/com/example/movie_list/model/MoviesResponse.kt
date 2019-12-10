package com.example.movie_list.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse (
    @SerializedName("results") val movies: List<Movie>
)