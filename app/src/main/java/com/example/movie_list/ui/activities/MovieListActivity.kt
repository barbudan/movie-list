package com.example.movie_list.ui.activities

import android.os.Bundle
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.example.movie_list.ui.components.ListComponent
import com.example.movie_list.ui.components.movieListComponent

class MovieListActivity : AppLifecycleActivity() {
    
    val listComponent = ListComponent<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(listComponent.showItemList(this) {
            movieListComponent {}
        })
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        return newState != oldState
    }

    override fun onChanged(state: AppState) { }

}
