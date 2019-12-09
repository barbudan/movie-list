package com.example.movie_list.reducers

import android.util.Log
import com.example.movie_list.actions.Actions
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.example.movie_list.model.payloads.ListRequestPayload
import com.github.raulccabreu.redukt.actions.Reduce
import com.github.raulccabreu.redukt.reducers.BaseAnnotatedReducer

class AppStateReducer : BaseAnnotatedReducer<AppState>() {

    /*@Reduce(Actions.UPDATE_MOVIE_LIST)
    fun updateMovieList(state: AppState, newList: List<Movie>): AppState {
        Log.i("Teste", "Oi")
        return state.copy(list = newList)
    }*/

    // I know this name is bad because of the other action.
    // It's just a placeholder name until I fully understand the process behind middleware
    @Reduce(Actions.UPDATE_MOVIE_LIST2)
    fun updateMovieList2(state: AppState, newList: List<Movie>): AppState {
        return state.copy(list = newList)
    }

}