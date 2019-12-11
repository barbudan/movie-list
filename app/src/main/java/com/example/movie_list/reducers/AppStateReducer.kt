package com.example.movie_list.reducers

import com.example.movie_list.actions.Actions
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.github.raulccabreu.redukt.actions.Reduce
import com.github.raulccabreu.redukt.reducers.BaseAnnotatedReducer

class AppStateReducer : BaseAnnotatedReducer<AppState>() {

    // Is it still necessary? As this Action is going to be intercepted by middleware.
    /*@Reduce(Actions.UPDATE_MOVIE_LIST)
    fun updateMovieList(state: AppState, newList: List<Movie>): AppState {
        return state.copy(list = newList)
    }*/

    // I know this name is bad because of the other action.
    // It's just a placeholder name until I fully understand the process behind middleware
    @Reduce(Actions.UPDATE_MOVIE_LIST2)
    fun updateMovieList2(state: AppState, newList: List<Movie>): AppState {
        return state.copy(list = newList)
    }

}