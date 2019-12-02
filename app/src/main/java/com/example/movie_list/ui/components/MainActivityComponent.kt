package com.example.movie_list.ui.components

import android.view.View
import android.widget.LinearLayout
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.Movie.movies
import trikita.anvil.RenderableView
import trikita.anvil.DSL.*

abstract class MainActivityComponent : AppActivityLifecycleComponent() {

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