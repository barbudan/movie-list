package com.example.movie_list.ui.components

import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.Movie.MovieItem
import com.example.movie_list.model.Movie.movies
import trikita.anvil.DSL.*

abstract class MovieListActivityComponent : AppActivityLifecycleComponent() {

    var position: Int = 0
    val listComponent = ListComponent<MovieItem>()
    val movieAdapter =
        ListAdapter<MovieItem> { item ->
            listComponent.showItem(item) {
                movieView(
                    item
                )
            }
        }

    fun movieView(movie: MovieItem) {
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
                        textView {
                            size(WRAP, WRAP)
                            text(movie.change.toString())
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
                    movies[pos].change = true
                    position = pos
                    ActionCreator.instance.showMovie(movies)
                }
            }
        }
    }

}