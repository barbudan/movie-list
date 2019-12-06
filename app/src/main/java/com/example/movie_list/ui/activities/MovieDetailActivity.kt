package com.example.movie_list.ui.activities

import android.os.Bundle
import com.example.movie_list.model.AppState
import com.example.movie_list.ui.components.MovieDetailActivityComponent

class MovieDetailActivity : MovieDetailActivityComponent() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView())
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        if (newState.listMoviesRequest != oldState.listMoviesRequest) return true
        if (newState.movieClicked != oldState.movieClicked) return true
        return false
    }

    override fun onChanged(state: AppState) {
        state.listMoviesRequest?.let {
            if(!state.listMoviesRequest) {
                finish()
            }
        }
    }

}
