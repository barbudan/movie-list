package com.example.movie_list.ui.components

import androidx.appcompat.app.AppCompatActivity
import com.example.movie_list.MovieListApp
import com.example.movie_list.model.AppState
import com.github.raulccabreu.redukt.states.StateListener

abstract class AppActivityLifecycleComponent : AppCompatActivity(), StateListener<AppState> {

    protected val state: AppState
        get() = MovieListApp.redukt.state

    override fun onStart() {
        super.onStart()
        MovieListApp.redukt.listeners.add(this)
        onChanged(state)
    }

    override fun onStop() {
        super.onStop()
        MovieListApp.redukt.listeners.remove(this)
    }

}