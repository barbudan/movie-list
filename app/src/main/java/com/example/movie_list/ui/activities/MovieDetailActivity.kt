package com.example.movie_list.ui.activities

import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.movie_list.model.AppState
import com.example.movie_list.ui.components.movieDetailComponent
import trikita.anvil.RenderableView

class MovieDetailActivity : AppLifecycleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView(this))
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        return newState != oldState
    }

    override fun onChanged(state: AppState) { }

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
