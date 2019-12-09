package com.example.movie_list.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {

    @GET("movie/popular")
    fun getMovies(
        @Query("api_key") apiKey: String = "3b43af9015e86d58c442d1bb532c1eb2",
        @Query("page") page: Int
    ): Call<Any> // Temporary

    companion object {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TmdbApi::class.java)

        fun getPopularMovies() {

        }
    }

}