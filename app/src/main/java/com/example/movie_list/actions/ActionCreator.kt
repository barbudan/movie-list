package com.example.movie_list.actions

import com.example.movie_list.MovieListApp
import com.example.movie_list.actions.Actions.UPDATE_MOVIE_LIST
import com.example.movie_list.actions.Actions.FETCH_MOVIE_LIST
import com.example.movie_list.model.Movie
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

    fun updateMovieList(page: Int) {
        asyncDispatch(Action(UPDATE_MOVIE_LIST, page))
    }

    fun fetchMovieList(list: List<Movie>) {
        asyncDispatch(Action(FETCH_MOVIE_LIST, list))
    }

}