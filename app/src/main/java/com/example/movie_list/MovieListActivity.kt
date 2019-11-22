package com.example.movie_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import trikita.anvil.RenderableView

import com.example.movie_list.MovieAdapter.movieAdapter
import com.example.movie_list.MovieListComponent

class MovieListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MovieListComponent.showMoviesList(this))
    }

}
