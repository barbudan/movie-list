package com.example.movie_list.ui.components

import android.content.Context
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.Movie
import trikita.anvil.Anvil
import trikita.anvil.BaseDSL
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

inline fun movieDetailComponent(crossinline func: MovieDetailComponent.() -> Unit) {
    highOrderComponent(func)
}

class MovieDetailComponent(context: Context) : RenderableView(context) {

    var movieTitle: String = ""
    var movieOverview: String = ""
    var movieDate: String = ""
    var movieBackdrop: String = ""
    var movieList: List<Movie> = emptyList()
    val BACKDROPID = 100
    val TITLEID = 102
    val DATEID = 103
    val OVERVIEWID = 104

    override fun view() {
        relativeLayout {
            size(MATCH,MATCH)
            imageView {
                id(BACKDROPID)
                BaseDSL.alignParentTop()
                size(FILL, WRAP)
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w780${movieBackdrop}")
                    .into(Anvil.currentView())
            }
            textView {
                id(TITLEID)
                below(BACKDROPID)
                size(WRAP,WRAP)
                text(movieTitle)
                textSize(72f)
                centerInParent()
            }
            textView {
                id(DATEID)
                below(TITLEID)
                size(WRAP,WRAP)
                text(movieDate)
                textSize(48f)
                centerInParent()
            }
            textView {
                id(OVERVIEWID)
                size(WRAP,WRAP)
                margin(8,24,8,8)
                below(DATEID)
                text(movieOverview)
                textSize(56f)
            }
        }
    }

    fun fillIntent(backdrop: String, title: String, date: String, overview: String) {
        movieBackdrop = backdrop
        movieTitle = title
        movieDate = date
        movieOverview = overview
    }

    fun fillList(list: List<Movie>) {
        movieList = list
    }

}