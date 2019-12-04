package com.example.movie_list.reducers

import android.util.Log
import com.example.movie_list.actions.Actions
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.example.movie_list.model.payloads.ShowMoviePayload
import com.github.raulccabreu.redukt.actions.Reduce
import com.github.raulccabreu.redukt.reducers.BaseAnnotatedReducer
import java.util.Collections.copy

class AppStateReducer : BaseAnnotatedReducer<AppState>() {

    @Reduce(Actions.LIST_MOVIES)
    fun listMovies(state: AppState, newList: List<Movie>): AppState {
        return state.copy(list = newList, isMovieClicked = false)
    }

    @Reduce(Actions.SHOW_MOVIE)
    fun showMovie(state: AppState, payload: Boolean): AppState {
        return state.copy(list = state.list, isMovieClicked = true)
    }

    @Reduce(Actions.POPULATE_MOVIE_LIST)
    fun populateMovieList(state: AppState, newList: List<Movie>): AppState {
        return state.copy(list = newList, isMovieClicked = false)
    }

}