package com.example.movie_list.activities

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

        movies.add(MovieItem("0", "title0","blablabla","2010","www", "aaa"))
        movies.add(MovieItem("1","title1","blablabla","2011", "www", "aaa"))
        movies.add(MovieItem("2","title2","blablabla","2012", "www", "aaa"))
        movies.add(MovieItem("3","title3","blablabla","2013", "www", "aaa"))
        movies.add(MovieItem("4", "title4", "blablabla", "2014", "www", "aaa"))
        movies.add(MovieItem("5","title5","blablabla","2015", "www", "aaa"))
        movies.add(MovieItem("6","title6","blablabla","2016", "www", "aaa"))

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
