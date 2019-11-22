package com.example.movie_list

import android.view.View
import android.widget.LinearLayout
import android.content.Intent

import trikita.anvil.DSL.*
import trikita.anvil.RenderableAdapter
import trikita.anvil.RenderableView

import com.example.movie_list.model.Movie.MovieItem
import com.example.movie_list.model.Movie.movies


object MovieAdapter {

    var movieAdapter = RenderableAdapter.withItems(movies) { pos, movie ->
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
}