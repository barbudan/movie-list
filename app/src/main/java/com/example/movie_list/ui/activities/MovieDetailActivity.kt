package com.example.movie_list.ui.activities

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.movie_list.model.AppState
import com.example.movie_list.ui.components.MovieDetailComponent
import com.example.movie_list.ui.components.mainComponent
import com.example.movie_list.ui.components.movieDetailComponent
import trikita.anvil.RenderableView

class MovieDetailActivity : AppLifecycleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView(this))
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        if (newState != oldState) return true
        return false
    }

    override fun onChanged(state: AppState) {
        // Should i put something in here? Is blank enough?
    }

    fun getView(c: Context): View {
        return object : RenderableView(c) {
            override fun view(){
                movieDetailComponent {
                    fillIntent(
                        backdrop = intent.getStringExtra("movie_backdrop"),
                        title = intent.getStringExtra("movie_title"),
                        date = intent.getStringExtra("movie_date"),
                        overview = intent.getStringExtra("movie_overview")
                    )
                    state.list?.let { fillList(it) }
                }
            }
        }
    }

}
