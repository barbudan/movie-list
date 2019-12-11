package com.example.movie_list.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.example.movie_list.ui.components.ListAdapter
import com.example.movie_list.ui.components.ListComponent
import com.example.movie_list.ui.components.movieListComponent
import com.example.movie_list.ui.components.movieViewComponent
import trikita.anvil.DSL.*

class MovieListActivity : AppLifecycleActivity() {
    
    val listComponent = ListComponent<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(listComponent.showItemList(this) {
            movieListComponent {}
        })
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        if (newState != oldState) return true
        return false
    }

    override fun onChanged(state: AppState) {
        // Should i put something in here? Is blank enough?
    }

}
