package com.example.movie_list.ui.activities

import android.content.Intent
import android.os.Bundle
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie.MovieItem
import com.example.movie_list.model.Movie.movies
import com.example.movie_list.ui.components.MainActivityComponent
import com.github.raulccabreu.redukt.states.StateListener

class MainActivity : MainActivityComponent() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movies.add(MovieItem("title1","2010","poster1","comedy1"))
        movies.add(MovieItem("title2","2011","poster2","comedy2"))
        movies.add(MovieItem("title3","2012","poster3","comedy3"))
        movies.add(MovieItem("title4","2013","poster4","comedy4"))
        movies.add(MovieItem("title5", "2041", "poster5", "comedy5"))
        movies.add(MovieItem("title6","2016","poster6","comedy6"))
        movies.add(MovieItem("title7","2015","poster7","comedy7"))

        setContentView(getView())
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        if (newState.list != oldState.list) return true
        return false
    }

    override fun onChanged(state: AppState) {
        if(state.list!=null) {
            val intent = Intent(applicationContext, MovieListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}
