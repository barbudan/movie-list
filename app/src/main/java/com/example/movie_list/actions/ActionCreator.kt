package com.example.movie_list.actions

import com.example.movie_list.MovieListApp
import com.example.movie_list.actions.Actions.LIST_MOVIES
import com.example.movie_list.model.Movie.MovieItem
import com.github.raulccabreu.redukt.actions.Action

class ActionCreator private constructor() {

    private object Holder {
        val INSTANCE  = ActionCreator()
    }

    companion object {
        val instance: ActionCreator by lazy { Holder.INSTANCE }
    }

    private fun asyncDispatch(action: Action<*>) {
        MovieListApp.redukt.dispatch(action, true)
    }

    fun listMovies(list: List<MovieItem>) {
        asyncDispatch(Action(LIST_MOVIES, list))
    }

}