package com.example.movie_list.reducers

import android.util.Log
import com.example.movie_list.actions.Actions
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.example.movie_list.model.Movie.MovieItem
import com.github.raulccabreu.redukt.actions.Reduce
import com.github.raulccabreu.redukt.reducers.BaseAnnotatedReducer

class AppStateReducer : BaseAnnotatedReducer<AppState>() {

    @Reduce(Actions.LIST_MOVIES)
    fun listMovies(state: AppState, newList: List<MovieItem>): AppState {
        return state.copy(list = newList)
    }

    @Reduce(Actions.SHOW_MOVIE)
    fun showMovie(state: AppState, newList: List<MovieItem>): AppState {
        return state.copy(list = newList)
    }

    @Reduce(Actions.POPULATE_MOVIE_LIST)
    fun populateMovieList(state: AppState, newList: List<MovieItem>): AppState {
        return state.copy(list = newList)
    }

}