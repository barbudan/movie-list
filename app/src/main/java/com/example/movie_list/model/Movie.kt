package com.example.movie_list.model

import com.google.gson.annotations.SerializedName

data class Movie(@SerializedName("id") val id: String,
                 @SerializedName("title") val title: String,
                 @SerializedName("overview") val overview: String,
                 @SerializedName("release_date") val releaseDate: String,
                 @SerializedName("poster_path") val posterPath: String,
                 @SerializedName("backdrop_path") val backdropPath: String)

