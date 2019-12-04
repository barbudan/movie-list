package com.example.movie_list.ui.components

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.Movie
import com.example.movie_list.ui.activities.AppLifecycleActivity
import trikita.anvil.Anvil
import trikita.anvil.DSL
import trikita.anvil.RenderableView
import trikita.anvil.DSL.*

inline fun mainComponent(crossinline func: MainComponent.() -> Unit) {
    highOrderComponent(func)
}

class MainComponent(context: Context) : RenderableView(context) {

    val movies = mutableListOf<Movie>()

    override fun view() {
        linearLayout {
            size(MATCH, MATCH)
            padding(dip(8))
            orientation(LinearLayout.VERTICAL)
            gravity(CENTER)
            textView {
                size(WRAP, WRAP)
                text("Hello! Click on the button below to show our movies list!")
                textSize(64f)
                gravity(CENTER_HORIZONTAL)
            }
            linearLayout {
                size(WRAP, WRAP)
                orientation(LinearLayout.HORIZONTAL)
                gravity(CENTER)
                button {
                    size(WRAP, WRAP)
                    text("Populate List")
                    textSize(56f)
                    onClick {
                        (1..10).forEach {
                            movies.add(Movie(
                                "title${(1..12).shuffled().first()}",
                                "2010","poster${(1..12).shuffled().first()}",
                                "comedy${(1..12).shuffled().first()}")
                            )
                        }
                        //it.isEnabled = false
                        ActionCreator.instance.populateMovieList(movies)
                    }
                }
                button {
                    size(WRAP, WRAP)
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