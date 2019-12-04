package com.example.movie_list.actions

import com.example.movie_list.MovieListApp
import com.example.movie_list.actions.Actions.LIST_MOVIES
import com.example.movie_list.actions.Actions.POPULATE_MOVIE_LIST
import com.example.movie_list.actions.Actions.SHOW_MOVIE
import com.example.movie_list.model.Movie
import com.example.movie_list.model.payloads.PopulateMoviePayload
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

    fun listMovies(list: List<Movie>) {
        asyncDispatch(Action(LIST_MOVIES, list))
    }

    fun showMovie() {
        asyncDispatch(Action(SHOW_MOVIE, true))
    }

    fun populateMovieList(list: List<Movie>) {
        asyncDispatch(Action(POPULATE_MOVIE_LIST, list))
    }
}