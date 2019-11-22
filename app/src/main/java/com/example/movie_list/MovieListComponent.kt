package com.example.movie_list

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.content.Intent

import trikita.anvil.DSL.linearLayout
import trikita.anvil.RenderableView
import trikita.anvil.DSL.*

import com.example.movie_list.MovieAdapter.movieAdapter
import com.example.movie_list.model.Movie.movies


object MovieListComponent {

    fun showMoviesList(c: Context): View {
        return object : RenderableView(c) {
            override fun view() {
                movieAdapter.notifyDataSetChanged()
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
    }

}