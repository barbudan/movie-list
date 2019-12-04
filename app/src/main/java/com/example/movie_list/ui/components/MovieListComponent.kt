package com.example.movie_list.ui.components

import android.content.Context
import android.widget.LinearLayout
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.Movie
import com.example.movie_list.ui.activities.AppLifecycleActivity
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

/*inline fun movieListComponent(crossinline func: MovieListComponent.() -> Unit) {
    highOrderComponent(func)
}

class MovieListComponent(c: Context) : RenderableView(c) {


    var position = 0
    val listComponent = ListComponent<Movie>()
    val movieAdapter =
        ListAdapter<Movie> { item ->
            listComponent.showItem(item) {
                movieView(item)
            }
        }

    override fun view() {
        movieView()
    }

    fun movieView(movie: Movie) {
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

    fun movieListView() {
        linearLayout {
            size(MATCH,MATCH)
            padding(dip(8))
            orientation(LinearLayout.VERTICAL)

            listView {
                size(FILL,FILL)
                adapter(movieAdapter)
                onItemClick { av, v, pos, id ->
                    position = pos
                    ActionCreator.instance.showMovie()
                }
            }
        }
    }

}*/