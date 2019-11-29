package com.example.movie_list

import com.example.movie_list.model.Movie.MovieItem
import com.google.gson.annotations.SerializedName

data class GetMoviesResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<MovieItem>,
    @SerializedName("total_pages") val pages: Int
)