package com.example.movie_list.ui.components

import android.content.Context
import android.widget.LinearLayout
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.payloads.ListRequestPayload
import com.example.movie_list.model.Movie
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

inline fun movieDetailComponent(crossinline func: MovieDetailComponent.() -> Unit) {
    highOrderComponent(func)
}

class MovieDetailComponent(context: Context) : RenderableView(context) {

    var moviePoster: String = ""
    var movieTitle: String = ""
    var movieDate: String = ""
    var movieGenre: String = ""
    var movieList: List<Movie> = emptyList()

    override fun view() {
        linearLayout {
            size(MATCH,MATCH)
            orientation(LinearLayout.VERTICAL)
            padding(dip(8))
            gravity(CENTER)
            textView {
                size(WRAP,WRAP)
                text(moviePoster)
                textSize(56f)
                gravity(CENTER_HORIZONTAL)
            }
            textView {
                size(WRAP,WRAP)
                text(movieTitle)
                textSize(56f)
                gravity(CENTER_HORIZONTAL)
            }
            textView {
                size(WRAP,WRAP)
                text(movieDate)
                textSize(56f)
                gravity(CENTER_HORIZONTAL)
            }
            textView {
                size(WRAP,WRAP)
                text(movieGenre)
                textSize(56f)
                gravity(CENTER_HORIZONTAL)
            }
        }
    }

    fun fillIntent(poster: String, title: String, date: String, genre: String) {
        moviePoster = poster
        movieTitle = title
        movieDate = date
        movieGenre = genre
    }

    fun fillList(list: List<Movie>) {
        movieList = list
    }

}