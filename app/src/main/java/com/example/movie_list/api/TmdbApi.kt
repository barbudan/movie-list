package com.example.movie_list.api

import com.example.movie_list.BuildConfig
import com.example.movie_list.model.MoviesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {

    @GET("movie/popular")
    fun getMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY, // Is it correct? Created from build.gradle
        @Query("page") page: Int
    ): Call<MoviesResponse>

    companion object {
        val api = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL) // Is it correct? Created from build.gradle
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TmdbApi::class.java)
    }

}