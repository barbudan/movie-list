package com.example.movie_list

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.content.Intent

import trikita.anvil.DSL.linearLayout
import trikita.anvil.RenderableView
import trikita.anvil.DSL.*

import com.example.movie_list.model.Movie.movies

import com.example.movie_list.model.Movie.MovieItem

object MovieListComponent {


    //val movieAdapter = ListAdapter<MovieItem> { item -> listComponent.showItem(item) }

    /*init {
        movieAdapter.items = movies
    }*/

    /*fun MovieListView(c: Context): View {
        return object : RenderableView(c) {
            override fun view() {
                linearLayout {
                    size(MATCH,MATCH)
                    padding(dip(8))
                    orientation(LinearLayout.VERTICAL)

                    listView {
                        size(FILL,FILL)
                        adapter(movieAdapter)
                        onItemClick { av, v, pos, id ->
                            val intent = Intent(c, MovieDetailActivity::class.java)
                            intent.putExtra("movie_title", movies[pos].title)
                            intent.putExtra("movie_date", movies[pos].releaseDate)
                            intent.putExtra("movie_poster", movies[pos].posterPath)
                            intent.putExtra("movie_genre", movies[pos].genre)
                            c.startActivity(intent)
                        }
                    }
                }
            }
        }
    }*/

    fun showMovie(movie: MovieItem) {
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