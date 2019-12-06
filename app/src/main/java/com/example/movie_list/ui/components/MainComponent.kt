package com.example.movie_list.ui.components

import android.content.Context
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.Movie
import com.example.movie_list.model.payloads.ChangePagePayload
import trikita.anvil.RenderableView
import trikita.anvil.DSL.*

inline fun mainComponent(crossinline func: MainComponent.() -> Unit) {
    highOrderComponent(func)
}

class MainComponent(context: Context) : RenderableView(context) {

    var tempList: List<Movie> = emptyList()

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
                    text("Update List")
                    textSize(56f)
                    onClick {
                        val movies = mutableListOf<Movie>()
                        (1..10).forEach {
                            movies.add(Movie(
                                "title${(1..12).shuffled().first()}",
                                "2010","poster${(1..12).shuffled().first()}",
                                "comedy${(1..12).shuffled().first()}")
                            )
                        }
                        tempList = movies
                        ActionCreator.instance.updateMovieList(movies)
                        Toast.makeText(context, "Your List has been Updated", Toast.LENGTH_SHORT).show()
                    }
                }
                button {
                    size(WRAP, WRAP)
                    text("List movies")
                    textSize(56f)
                    onClick {
                        if(tempList.isEmpty()) {
                            ActionCreator.instance.listMovies(ChangePagePayload(tempList, false))
                            Toast.makeText(
                                context,
                                "Your List is not populated yet, please update it",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            ActionCreator.instance.listMovies(ChangePagePayload(tempList, true))
                        }
                    }
                }
            }
        }
    }

}