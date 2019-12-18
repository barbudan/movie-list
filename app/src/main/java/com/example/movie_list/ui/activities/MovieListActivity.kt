package com.example.movie_list.ui.activities

import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.movie_list.model.AppState
import com.example.movie_list.ui.components.movieListComponent
import trikita.anvil.RenderableView

class MovieListActivity : AppLifecycleActivity() {

    var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView(this))
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        return newState != oldState
    }

    override fun onChanged(state: AppState) {
        page++
    }

    fun getView(context: Context): View {
        return object : RenderableView(context) {
            override fun view() {
                movieListComponent {
                    refreshListPage(page)
                }
            }
        }
    }

}
