package com.example.movie_list.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.movie_list.MovieListApp
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.AppState

import trikita.anvil.DSL.*
import trikita.anvil.DSL.linearLayout

import com.example.movie_list.model.Movie.MovieItem
import com.example.movie_list.model.Movie.movies
import com.example.movie_list.ui.components.ListAdapter
import com.example.movie_list.ui.components.ListComponent
import com.example.movie_list.ui.components.MovieListActivityComponent
import com.github.raulccabreu.redukt.states.StateListener

class MovieListActivity : MovieListActivityComponent(), StateListener<AppState> {

    protected val state: AppState
        get() = MovieListApp.redukt.state

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieAdapter.items = movies
        setContentView(listComponent.showItemList(this) { movieListView() } )
    }

    override fun onStart() {
        super.onStart()
        MovieListApp.redukt.listeners.add(this)
        onChanged(state)
    }

    override fun onStop() {
        super.onStop()
        MovieListApp.redukt.listeners.remove(this)
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        if (newState.movie != oldState.movie) return true
        return false
    }

    override fun onChanged(state: AppState) {
        if(state.movie!=null) {
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("movie_title", state.movie.title)
            intent.putExtra("movie_date", state.movie.releaseDate)
            intent.putExtra("movie_poster", state.movie.posterPath)
            intent.putExtra("movie_genre", state.movie.genre)
            this.startActivity(intent)
        }
    }

}
