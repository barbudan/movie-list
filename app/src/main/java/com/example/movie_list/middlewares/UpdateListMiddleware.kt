package com.example.movie_list.middlewares

import android.util.Log
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.actions.Actions
import com.example.movie_list.api.TmdbApi.Companion.api
import com.github.raulccabreu.redukt.middlewares.BaseAnnotatedMiddleware
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.example.movie_list.model.MoviesResponse
import com.github.raulccabreu.redukt.actions.Action
import com.github.raulccabreu.redukt.middlewares.BeforeAction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateListMiddleware : BaseAnnotatedMiddleware<AppState>() {

    @BeforeAction(Actions.UPDATE_MOVIE_LIST)
    fun getListFromApi(state: AppState, action: Action<*>) {
        api.getMovies(page = 1)
            .enqueue(object : Callback<MoviesResponse> {
                override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            ActionCreator.instance.fetchMovieList(responseBody.movies)
                            Log.d("Middleware", "onResponse -> Movie List: ${responseBody.movies}")
                        } else {
                            Log.d("Middleware", "onResponse -> Failed to get response")
                        }
                    }
                }

                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    Log.e("Middleware", "onFailure", t)
                }
            })
    }

    @BeforeAction(Actions.LOAD_NEXT_PAGE)
    fun getNextPageFromApi(state: AppState, action: Action<*>) {
        api.getMovies(page = action.payload as Int)
            .enqueue(object : Callback<MoviesResponse> {
                override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            ActionCreator.instance.fetchNextPage(responseBody.movies)
                            Log.d("Middleware", "onResponse -> Movie List: ${responseBody.movies}")
                        } else {
                            Log.d("Middleware", "onResponse -> Failed to get response")
                        }
                    }
                }

                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    Log.e("Middleware", "onFailure", t)
                }
            })
    }

}