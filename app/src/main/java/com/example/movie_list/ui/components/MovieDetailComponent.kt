package com.example.movie_list.ui.components

import android.content.Context
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.Movie
import trikita.anvil.Anvil
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

inline fun movieDetailComponent(crossinline func: MovieDetailComponent.() -> Unit) {
    highOrderComponent(func)
}

class MovieDetailComponent(context: Context) : RenderableView(context) {

    var moviePoster: String = ""
    var movieTitle: String = ""
    var movieOverview: String = ""
    var movieDate: String = ""
    var movieBackdrop: String = ""
    var movieList: List<Movie> = emptyList()

    override fun view() {
        linearLayout {
            size(MATCH,MATCH)
            orientation(LinearLayout.VERTICAL)
            //padding(dip(8))
            //gravity(CENTER)
            imageView {
                // TODO Fix image size issue. The size just obbeys the hardcoded width/height from layout
                // and not the one given by url.
                size(WRAP, WRAP)
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/original${movieBackdrop}")
                    .into(Anvil.currentView())
            }
            imageView {
                // TODO Fix image size issue. The size just obbeys the hardcoded width/height from layout
                // and not the one given by url.
                size(342, WRAP)
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w342${moviePoster}")
                    .into(Anvil.currentView())
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
                text(movieOverview)
                textSize(56f)
                gravity(CENTER_HORIZONTAL)
            }
        }
    }

    fun fillIntent(backdrop: String, poster: String, title: String, date: String, overview: String) {
        movieBackdrop = backdrop
        moviePoster = poster
        movieTitle = title
        movieDate = date
        movieOverview = overview
    }

    fun fillList(list: List<Movie>) {
        movieList = list
    }

}