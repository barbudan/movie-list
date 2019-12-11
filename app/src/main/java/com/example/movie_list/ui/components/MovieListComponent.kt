package com.example.movie_list.ui.components

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.LinearLayout
import com.example.movie_list.MovieListApp
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.AppState
import com.example.movie_list.model.Movie
import com.example.movie_list.ui.activities.AppLifecycleActivity
import com.example.movie_list.ui.activities.MovieDetailActivity
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

inline fun movieListComponent(crossinline func: MovieListComponent.() -> Unit) {
    highOrderComponent(func)
}

class MovieListComponent(context: Context) : RenderableView(context) {

    protected val state: AppState
        get() = MovieListApp.redukt.state

    val movieAdapter =
        ListAdapter<Movie> { item ->
            movieViewComponent {
                defineMovie(item)
            }
        }

    override fun view() {
        state.list?.let { movieAdapter.items = it }
        linearLayout {
            size(MATCH,MATCH)
            padding(dip(8))
            orientation(LinearLayout.VERTICAL)

            listView {
                size(FILL,FILL)
                adapter(movieAdapter)
                onItemClick { av, v, pos, id ->
                    val item = state.list?.get(pos)!!
                    val intent = Intent(context, MovieDetailActivity::class.java)
                    //intent.putExtra("movie_id", item.id)
                    intent.putExtra("movie_title", item.title)
                    intent.putExtra("movie_overview", item.overview)
                    intent.putExtra("movie_date", item.releaseDate)
                    intent.putExtra("movie_backdrop", item.backdropPath)
                    context.startActivity(intent)
                }
            }
        }
    }

}