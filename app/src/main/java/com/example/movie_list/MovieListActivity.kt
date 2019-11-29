package com.example.movie_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.movie_list.actions.ActionCreator
import com.example.movie_list.model.AppState

import trikita.anvil.DSL.*
import trikita.anvil.DSL.linearLayout

import com.example.movie_list.model.Movie.MovieItem
import com.example.movie_list.model.Movie.movies
import com.github.raulccabreu.redukt.states.StateListener

class MovieListActivity : AppCompatActivity(), StateListener<AppState> {

    protected val state: AppState
        get() = MovieListApp.redukt.state

    val listComponent = ListComponent<MovieItem>()
    val movieAdapter = ListAdapter<MovieItem> { item -> listComponent.showItem(item) { movieView(item) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieAdapter.items = movies
        setContentView(listComponent.showItemList(this) { movieListView() } )
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
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        MovieListApp.redukt.listeners.add(this)
        onChanged(state)
    }

    override fun onStop() {
        super.onStop()
        MovieListApp.redukt.listeners.remove(this)
    }

    override fun hasChanged(newState: AppState, oldState: AppState): Boolean {
        if (newState.movie != oldState.movie) return true
        return false
    }

    override fun onChanged(state: AppState) {
        if(state.movie!=null) {
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("movie_title", state.movie.title)
            intent.putExtra("movie_date", state.movie.releaseDate)
            intent.putExtra("movie_poster", state.movie.posterPath)
            intent.putExtra("movie_genre", state.movie.genre)
            this.startActivity(intent)
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
                    ActionCreator.instance.showMovie(movies[pos])
                }
            }
        }
    }

}
