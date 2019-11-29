package com.example.movie_list.reducers

import com.example.movie_list.actions.Actions
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie.MovieItem
import com.github.raulccabreu.redukt.actions.Reduce
import com.github.raulccabreu.redukt.reducers.BaseAnnotatedReducer

class AppStateReducer : BaseAnnotatedReducer<AppState>() {

    @Reduce(Actions.LIST_MOVIES)
    fun listMovies(state: AppState, newList: List<MovieItem>): AppState {
        return state.copy(list = newList, movie = null)
    }

}