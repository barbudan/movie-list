package com.example.movie_list.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.example.movie_list.MovieListApp
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie.MovieItem
import com.example.movie_list.model.Movie.movies
import com.github.raulccabreu.redukt.states.StateListener
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

class MainActivity : AppCompatActivity(), StateListener<AppState> {

    protected val state: AppState
        get() = MovieListApp.redukt.state

    override fun onStart() {
        super.onStart()
        MovieListApp.redukt.listeners.add(this)
        onChanged(state)
    }

    override fun onStop() {
        super.onStop()
        MovieListApp.redukt.listeners.remove(this)
    }

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

    fun getView(): View {
        return object : RenderableView(this) {
            override fun view() {
                linearLayout {
                    size(MATCH, MATCH)
                    padding(dip(8))
                    orientation(LinearLayout.VERTICAL)
                    gravity(CENTER)
                    textView {
                        size(WRAP,WRAP)
                        text("Hello! Click on the button below to show our movies list!")
                        textSize(64f)
                        gravity(CENTER_HORIZONTAL)
                    }
                    button {
                        size(WRAP,WRAP)
                        text("List movies")
                        textSize(56f)
                        onClick {
                            ActionCreator.instance.listMovies(movies)
                        }
                    }
                }
            }
        }
    }
}
