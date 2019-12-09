package com.example.movie_list.middlewares

import android.content.Context
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.actions.Actions
import com.github.raulccabreu.redukt.middlewares.BaseAnnotatedMiddleware
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.github.raulccabreu.redukt.actions.Action
import com.github.raulccabreu.redukt.middlewares.BeforeAction

class UpdateListMiddleware : BaseAnnotatedMiddleware<AppState>() {

    @BeforeAction(Actions.UPDATE_MOVIE_LIST)
    fun getListFromApi(state: AppState, action: Action<*>) {
        var movies = mutableListOf<Movie>()
        (1..10).forEach {
            movies.add(
                Movie(
                    "id${(1..12).shuffled().first()}",
                    "title${(1..12).shuffled().first()}",
                    "overview${(1..12).shuffled().first()}",
                    "201${(1..9).shuffled().first()}",
                    "poster${(1..12).shuffled().first()}",
                    "backdrop${(1..12).shuffled().first()}")
            )
        }
        ActionCreator.instance.updateMovieList2(movies)
    }

}