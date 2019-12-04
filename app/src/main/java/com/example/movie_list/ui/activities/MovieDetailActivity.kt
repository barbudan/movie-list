package com.example.movie_list.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.example.movie_list.model.AppState
import com.example.movie_list.ui.components.MovieDetailActivityComponent
import trikita.anvil.DSL.linearLayout
import trikita.anvil.RenderableView
import trikita.anvil.DSL.*

class MovieDetailActivity : MovieDetailActivityComponent() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView())
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        if (newState.isMovieClicked != oldState.isMovieClicked) return true
        return false
    }

    override fun onChanged(state: AppState) {
        if(!state.isMovieClicked!!) {
            finish()
        }
    }

}
