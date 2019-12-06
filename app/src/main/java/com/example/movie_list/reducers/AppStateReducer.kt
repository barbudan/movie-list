package com.example.movie_list.reducers

import com.example.movie_list.actions.Actions
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.example.movie_list.model.payloads.ListRequestPayload
import com.github.raulccabreu.redukt.actions.Reduce
import com.github.raulccabreu.redukt.reducers.BaseAnnotatedReducer

class AppStateReducer : BaseAnnotatedReducer<AppState>() {

    @Reduce(Actions.LIST_MOVIES)
    fun listMovies(state: AppState, payload: ListRequestPayload): AppState {
        return state.copy(list = payload.list, movieClicked = false, listMoviesRequest = payload.request)
    }

    @Reduce(Actions.SHOW_MOVIE)
    fun showMovie(state: AppState, payload: Boolean): AppState {
        return state.copy(list = state.list, movieClicked = true, listMoviesRequest = true)
    }

    @Reduce(Actions.UPDATE_MOVIE_LIST)
    fun updateMovieList(state: AppState, newList: List<Movie>): AppState {
        return state.copy(list = newList, movieClicked = false, listMoviesRequest = null)
    }

}