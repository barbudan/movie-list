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
        Log.i("Testando", "Aaa2a")
        setContentView(getView(this))
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        if (newState.listMoviesRequest != oldState.listMoviesRequest) return true
        if (newState.movieClicked != oldState.movieClicked) return true
        return false
    }

    override fun onChanged(state: AppState) {
        state.movieClicked?.let {
            if(!state.movieClicked) {
                Log.i("Testando", "Aaaa")
                finish()
            }
        }
    }

    fun getView(c: Context): View {
        return object : RenderableView(c) {
            override fun view(){
                movieDetailComponent {
                    fillIntent(
                        poster = intent.getStringExtra("movie_poster"),
                        title = intent.getStringExtra("movie_title"),
                        date = intent.getStringExtra("movie_date"),
                        genre = intent.getStringExtra("movie_genre")
                    )
                    state.list?.let { fillList(it) }
                }
            }
        }
    }

}
