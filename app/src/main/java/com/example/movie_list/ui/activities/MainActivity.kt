package com.example.movie_list.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie.MovieItem
import com.example.movie_list.model.Movie.movies
import com.example.movie_list.ui.components.MainActivityComponent
import com.github.raulccabreu.redukt.states.StateListener

class MainActivity : MainActivityComponent() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView())
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        if (newState.list != oldState.list) return true
        return false
    }

    override fun onChanged(state: AppState) {
        state.list?.let {
            val intent = Intent(applicationContext, MovieListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}
