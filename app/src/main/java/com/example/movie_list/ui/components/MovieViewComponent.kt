package com.example.movie_list.ui.components

import android.content.Context
import android.widget.LinearLayout
import com.example.movie_list.model.Movie
import trikita.anvil.RenderableView
import trikita.anvil.DSL.*

inline fun movieViewComponent(crossinline func: MovieViewComponent.() -> Unit) {
    highOrderComponent(func)
}

class MovieViewComponent(context: Context) : RenderableView(context) {

    lateinit var movie: Movie

    override fun view() {
        linearLayout {
            size(FILL,WRAP)
            padding(dip(8))
            orientation(LinearLayout.VERTICAL)
            linearLayout {
                size(FILL, WRAP)
                padding(dip(8))
                orientation(LinearLayout.VERTICAL)
                linearLayout {
                    orientation(LinearLayout.HORIZONTAL)
                    size(WRAP, WRAP)
                    textView {
                        size(WRAP, WRAP)
                        text(movie.posterPath)
                        textSize(64f)
                    }
                    linearLayout {
                        orientation(LinearLayout.VERTICAL)
                        size(WRAP,WRAP)
                        margin(100,0,0,0)
                        textView {
                            size(WRAP, WRAP)
                            text(movie.title)
                            textSize(64f)
                        }
                        textView {
                            size(WRAP, WRAP)
                            text(movie.releaseDate)
                            textSize(48f)
                        }
                        textView {
                            size(WRAP, WRAP)
                            text(movie.genre)
                            textSize(48f)
                        }
                    }
                }
            }
        }
    }

    fun defineMovie(mov: Movie) {
        movie = mov
    }

}