package com.example.movie_list.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

class MovieListActivity : MovieListActivityComponent() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieAdapter.items = movies
        setContentView(listComponent.showItemList(this) { movieListView() } )
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        if (newState.list != oldState.list) {
            return true
        }
        return false
    }

    override fun onChanged(state: AppState) {
        if(state.list?.get(position)?.change!!) {
            val item = state.list?.get(position)
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("movie_title", item.title)
            intent.putExtra("movie_date", item.releaseDate)
            intent.putExtra("movie_poster", item.posterPath)
            intent.putExtra("movie_genre", item.genre)
            intent.putExtra("movie_genre", item.change)
            this.startActivity(intent)
        }
    }

}
